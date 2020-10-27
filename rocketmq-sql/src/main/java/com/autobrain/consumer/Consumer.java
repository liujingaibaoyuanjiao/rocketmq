package com.autobrain.consumer;

import com.alibaba.fastjson.JSONObject;
import com.autobrain.dao.*;
import com.autobrain.domain.*;
import com.autobrain.utils.MyUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Component
public class Consumer {
    //注入入库方法
    @Autowired
    private StoreSqlDao storeSqlDao;

    private Map<String, String> setOid = new HashMap<String, String>();

    private Map<String, String> setInstruct = new HashMap<String, String>();

    private Map<String, String> setIdentify = new HashMap<String, String>();


    @SneakyThrows
    @PostConstruct
    public void start() {
        // 获取消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("instruct-sql");
        // 指定NameSrv地址
//        consumer.setNamesrvAddr("139.217.56.46:9876");
        consumer.setNamesrvAddr("192.168.1.9:9876");
        // 指定拉取的消息
        consumer.subscribe("instruct", "*");
        // 设置消费位置
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        // 设置集群得消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //设置消费线程的最小数量，默认为20个线程
        consumer.setConsumeThreadMin(20);
        //设置消费线程的最大数量，默认为64个线程
        consumer.setConsumeThreadMax(64);
        // 批量消费消息，一次消费多少条消息，默认为1
        consumer.setConsumeMessageBatchMaxSize(64);
        // 批量拉取消息，一次性最多拉取多少条消息，默认为32条
        consumer.setPullBatchSize(128);
        // 设置消息拉取间隔，默认为 0
        consumer.setPullInterval(0);
        // 注册回调函数,监听消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    //遍历拉取得消息
                    for (MessageExt msg : msgs) {
                        //获取消息体
                        byte[] body = msg.getBody();
                        run(body);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                //返回成功标志
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        log.info("消费者启动成功");
    }

    @SneakyThrows
    private void run(byte[] bytes) {
        // 获取16进制字符串数组
        String[] strings = MyUtils.bytesToHexString(bytes);
        String s = new String(bytes);
        if (s.contains("app")) {
            JSONObject jsonObject = JSONObject.parseObject(s);
            setOid.put((String) jsonObject.get("domainController"), (String) jsonObject.get("oid"));
            setInstruct.put((String) jsonObject.get("domainController"), (String) jsonObject.get("instruct"));
            setIdentify.put((String) jsonObject.get("domainController"), (String) jsonObject.get("identify"));
            log.info(s);
        }
        if (strings.length > 19) {
            switch ((strings[18] + strings[19])) {
//                握手
                case "0286":
                    ShakeHands hands = new ShakeHands(strings);
//                    log.info("握手" + hands);
                    break;
//               心跳
                case "0282":
                    HeartBeat heart = new HeartBeat(strings);
//                    log.info("心跳" + heart);
                    break;
//               gps
                case "0284":
                    if (strings.length > 38) {
//                         拆解gps
                        FiveSecondsGPS fiveSecondsGPS = new FiveSecondsGPS(strings);
//                        创建集合
                        List<Object[]> fiveSecondsGPSList = new ArrayList<>();
//                        数据存入数组
                        Object[] fiveSecondsGPSArr = {MyUtils.getUUID(), fiveSecondsGPS.getCommandIdentifier(), fiveSecondsGPS.getCrcCheck(), fiveSecondsGPS.getDomainControllerID(),
                                fiveSecondsGPS.getGpsLength(), fiveSecondsGPS.getLatitude(), fiveSecondsGPS.getLongitude(), fiveSecondsGPS.getMessageID(), fiveSecondsGPS.getMessageLength(),
                                fiveSecondsGPS.getSerialNumber(), fiveSecondsGPS.getStartByte(), setOid.get(fiveSecondsGPS.getDomainControllerID()), setInstruct.get(fiveSecondsGPS.getDomainControllerID()),
                                MyUtils.getDate()
                        };
//                        数组加入集合
                        fiveSecondsGPSList.add(fiveSecondsGPSArr);
//                        批量插入
                        String isSuccess = storeSqlDao.addFiveSecondsGPS(fiveSecondsGPSList);
                        log.info(isSuccess + "===" + Arrays.toString(fiveSecondsGPSArr));
                    }
                    break;
//                车辆运动状态信息
                case "0b13":
                    if (strings.length > 47) {
                        CarExerciseStateInformation ces = new CarExerciseStateInformation(strings);
                        //获取域控制器
                        String CarExerciseStateDomainControllerID = ces.getDomainControllerID();
                        //获取集合
                        List<Object[]> list = new ArrayList<>();
                        //数据存入数组
                        Object[] carExerciseStateArr = {MyUtils.getUUID(), ces.getAngularAcceleration(), ces.getCabTemperature(), ces.getCommandIdentifier(), ces.getCourseRadian(), ces.getCrcCheck(), ces.getDomainControllerID(),
                                ces.getEngineSpeed(), ces.getEngineTemperature(), ces.getGear(), ces.getGpsSpeed(), setInstruct.get(CarExerciseStateDomainControllerID), ces.getMessageID(), ces.getMessageLength(), setOid.get(CarExerciseStateDomainControllerID),
                                ces.getOilMass(), ces.getSerialNumber(), ces.getSpeed(), ces.getStartByte(), ces.getThreeAxisAcceleration(), MyUtils.getDate()};
                        //数组加入集合
                        list.add(carExerciseStateArr);
                        //插入数据
                        String carExerciseStateInformation = storeSqlDao.addCarExerciseStateInformation(list);
                        //打印日志
                        log.info(carExerciseStateInformation + Arrays.toString(carExerciseStateArr));
                    }
                    break;
//                约车
                case "0b16":
                    AboutCar aboutCar = new AboutCar(strings);
//                    获取域控制器
                    String aboutCarDomainControllerID = aboutCar.getDomainControllerID();
//                    获取集合
                    List<Object[]> list = new ArrayList<>();
//                    入库
                    for (double[] arr : aboutCar.getLists()) {
                        Object[] aboutArr = {MyUtils.getUUID(), aboutCar.getCommandIdentifier(), aboutCar.getControlResult(), aboutCar.getCrcCheck(), aboutCar.getDomainControllerID(), aboutCar.getLists().size() + "",
                                arr[1], arr[0], aboutCar.getMessageID(), aboutCar.getMessageLength(), aboutCar.getPackageAmount(), aboutCar.getPackageNumber(), aboutCar.getSerialNumber(),
                                aboutCar.getSerialSize(), aboutCar.getStartByte(), MyUtils.getDate(), setInstruct.get(aboutCarDomainControllerID), setOid.get(aboutCarDomainControllerID), setIdentify.get(aboutCarDomainControllerID)};
                        list.add(aboutArr);
                        Thread.sleep(1);
                    }
                    String aboutCarInformation = storeSqlDao.addAboutCarInformation(list);
                    log.info(aboutCarInformation + "=====" + aboutCar);
                    break;
//                 取车/用车/还车/泊车
                case "0a04":
//                     拆解取车/用车/还车/泊车
                    TakeCar takeCar = new TakeCar(strings);
//                    获取域控制器
                    String takeCarDomainControllerID = takeCar.getDomainControllerID();
//                    创建集合
                    List<Object[]> takeCarList = new ArrayList<>();
                    for (double[] arr : takeCar.getLists()) {
                        Object[] takeCarArr = {MyUtils.getUUID(), takeCar.getCarState(), takeCar.getCommandIdentifier(), takeCar.getControlResult(), takeCar.getCrcCheck(), takeCar.getDomainControllerID(),
                                takeCar.getElectricity(), takeCar.getEnduranceMileage(), takeCar.getLists().size() + "", arr[1], arr[0], takeCar.getMessageID(), takeCar.getMessageLength(),
                                takeCar.getPackageAmount(), takeCar.getPackageNumber(), takeCar.getSerialNumber(), takeCar.getSerialSize(), takeCar.getStartByte(), MyUtils.getDate(), takeCar.getTotalDistance(),
                                takeCar.getVoltage(), setOid.get(takeCarDomainControllerID), setInstruct.get(takeCarDomainControllerID), setIdentify.get(takeCarDomainControllerID)};
                        Thread.sleep(1);
                        takeCarList.add(takeCarArr);
                    }
//                    入库
                    String takeCarInformation = storeSqlDao.addTakeCarInformation(takeCarList);
//                    打印日志
                    log.info(setInstruct.get(takeCarDomainControllerID) + takeCarInformation + "===" + takeCar);
                    if (s.contains("还车")) {
                        setOid.remove(takeCarDomainControllerID);
                        setInstruct.remove(takeCarDomainControllerID);
                        setIdentify.remove(takeCarDomainControllerID);
                    }
                    break;
//                解析域控制器升级
                case "0125":
                    DomainControllerUpgrade domainControllerUpgrade = new DomainControllerUpgrade(strings);
//                    log.info("域控制器升级" + domainControllerUpgrade);
                    break;
//                 辆自动驾驶采集信息
                case "0b17":
//                    拆解信息
                    CarAutomaticDriveGetInformation adf = new CarAutomaticDriveGetInformation(strings);
//                    获取域控制器
                    String carAutomaticDriveInformationDomainControllerID = adf.getDomainControllerID();
//                    创建集合
                    List<Object[]> carAutomaticDriveInformationList = new ArrayList<>();
//                    数据出入数组
                    Object[] carAutomaticDriveInformationArr = {
                            MyUtils.getUUID(), adf.getEPB(), adf.getGPSTime(), adf.getVelocityInTheXAxisDirectionOfTheObstacle(), adf.getVelocityInTheYAxisDirectionOfTheObstacle(), adf.getXCoordinateOfTheLocus(), adf.getXCoordinateOfTheObstaclePosition(),
                            adf.getYCoordinateOfTheLocus(), adf.getYCoordinateOfTheObstaclePosition(), adf.getAcceleratorPedalOpening(), adf.getBarrierHigh(), adf.getBarrierLong(), adf.getBarrierState(), adf.getBarrierWidth(), adf.getBicycleIdentificationMoment(),
                            adf.getBicycleIdentificationNumber(), adf.getBrakeFluidPressure(), adf.getBrakeLamp(), adf.getBrakePedalCondition(), adf.getBrakePedalOpening(), adf.getCarDoorState(), adf.getCarSpeed(), adf.getCarState(), adf.getCommandIdentifier(),
                            adf.getCrcCheck(), adf.getDangerWarningLight(), adf.getDippedHeadlight(), adf.getDomainControllerID(), adf.getDrivingModeFeedback(), adf.getFogLamps(), adf.getGasPedalCondition(), adf.getGearInformation(), adf.getHeartbeatHandshakeSignal(),
                            adf.getHighBeam(), adf.getHorizontalFaultInformation(), adf.getHumanIntervention(), setInstruct.get(carAutomaticDriveInformationDomainControllerID), adf.getLocusPointRate(), adf.getLongitudinalAcceleration(),
                            adf.getLongitudinalEnabledSignal(), adf.getLongitudinalFaultInformation(), adf.getMessageID(), adf.getMessageLength(), adf.getModeSwitch(), adf.getMotorVehicleIdentificationMoment(), adf.getNumberOfMotorVehicleIdentification(),
                            adf.getNumberOfTrafficSigns(), setOid.get(carAutomaticDriveInformationDomainControllerID), adf.getObstacleOrientation(), adf.getObstaclePriority(), adf.getObstacleTrajectoryProbability(), adf.getObstaclesID(), adf.getObstructionBehavior(),
                            adf.getPredictedTrajectoryDuration(), adf.getRelativeTimeOfLocusPoint(), adf.getRemainingMileage(), adf.getSerialNumber(), adf.getSignalOfTurnSignalDialRodSwitch(), adf.getSpeedAddOrSubtractSwitch(), adf.getStartByte(), adf.getSteeringAngle(),
                            adf.getSteeringAngularVelocity(), adf.getSteeringDirectionIndicator(), adf.getSteeringModeFeedback(), adf.getSteeringWheelCorner(), adf.getSteeringWheelCornerTurnSpeed(), adf.getSteeringWheelTorque(), adf.getSwitchSignalsSuchAsDangerAlarm(),
                            adf.getTargetAcceleration(), adf.getTheBicycleRecognizesTheXCoordinate(), adf.getTheBicycleRecognizesTheYCoordinate(), adf.getTheRoadIDWhereTheTrackPointIs(), adf.getTheXCoordinateOfTheLocus(), adf.getTheYCoordinateOfTheLocus(),
                            adf.getTheZCoordinateOfTheLocus(), adf.getTimeStamp(), adf.getToIdentify(), adf.getToModel(), adf.getTrafficLightIdentificationMoment(), adf.getTrafficLightIdentificationNumber(), adf.getTrafficLightsIdentifyXCoordinates(),
                            adf.getTrafficLightsIdentifyYCoordinates(), adf.getTrafficSignIdentificationTime(), adf.getTrafficSignsIdentifyXCoordinates(), adf.getTrafficSignsIdentifyYCoordinates(), adf.getTrajectoryPointAcceleration(),
                            adf.getTrajectoryPointOrientation(), adf.getTransverseAcceleration(), adf.getTransverseEnablingSignal(), adf.getTurnSignal(), adf.getVehicleIdentificationXCoordinates(), adf.getVehicleIdentificationYCoordinates(),
                            adf.getWheelDirection(), adf.getWheelSpeed(), adf.getWheelSpeedMark(), adf.getWheelSteeringAngle(), adf.getWiper(), adf.getYawingRate(), adf.getPedestrianRecognitionTime(), adf.getPedestrianRecognitionTimes(), adf.getPedestrianRecognitionXCoordinate(),
                            adf.getPedestrianRecognitionYCoordinate()
                    };
//                    数组加入集合
                    carAutomaticDriveInformationList.add(carAutomaticDriveInformationArr);
//                    批量入库
                    String carAutoDriverInformation = storeSqlDao.addCarAutoDriverInformation(carAutomaticDriveInformationList);
//                    打印日志
                    log.info(carAutoDriverInformation + Arrays.toString(carAutomaticDriveInformationArr));
                    break;
//                 解析调度
                case "0b0b":
                    Scheduling scheduling = new Scheduling(strings);
//                    log.info("调度" + scheduling);
                    break;
//                 电量、总里程和续航里程状态
                case "0299":
//                    拆解电量、总里程和续航里程状态
                    ElectricityTotalMileageRangeState etm = new ElectricityTotalMileageRangeState(strings);
//                    创建集合
                    List<Object[]> electricityTotalMileageRangeStateList = new ArrayList<>();
//                    数据存入数组
                    Object[] electricityTotalMileageRangeStateArr = {MyUtils.getUUID(), etm.getBatteryPackPowerBatteryModel(), etm.getCommandIdentifier(), etm.getCrcCheck(), etm.getDomainControllerID(), etm.getMessageID(),
                            etm.getMessageLength(), etm.getPowerBatteryChargingCurrentValue(), etm.getPowerBatteryChargingVoltageValue(), etm.getPowerCellTemperature(), etm.getSerialNumber(), etm.getSerialNumberOfReplyInstructionMessage(),
                            etm.getStartByte(), etm.getStateOfTheVehicle(), MyUtils.getDate(), etm.getTotalMileage(), etm.getVehicleVINCode(), etm.getVoltageValueOfSmallBattery(), etm.getResidualPowerSOC(), etm.getLifeMileage(),
                            setOid.get(etm.getDomainControllerID()), setInstruct.get(etm.getDomainControllerID())
                    };
//                    数组加入集合
                    electricityTotalMileageRangeStateList.add(electricityTotalMileageRangeStateArr);
//                    批量插入
                    String electricityTotalMileageRangeStateIsSuccess = storeSqlDao.addTotalElectricityMileage(electricityTotalMileageRangeStateList);
//                    打印日志
                    log.info(electricityTotalMileageRangeStateIsSuccess + "====" + Arrays.toString(electricityTotalMileageRangeStateArr));
                    break;
//                警告
                case "0301":
//                    拆解警告
                    Warning warning = new Warning(strings);
//                    创建集合
                    List<Object[]> warningList = new ArrayList<>();
//                    数据存入数组
                    Object[] warningArr = {MyUtils.getUUID(), warning.getAcceleration(), warning.getAngularAcceleration(), warning.getCommandIdentifier(), warning.getCrcCheck(), warning.getDomainControllerID(), warning.getFaultCode(),
                            warning.getGpsLength(), warning.getLatitude(), warning.getLongitude(), warning.getMessageID(), warning.getMessageLength(), warning.getSerialNumber(), warning.getStartByte(), warning.getTimeStamp(),
                            warning.getVoltageValue(), warning.getWarningType(), setOid.get(warning.getDomainControllerID()), setInstruct.get(warning.getDomainControllerID())};
//                    数组加入集合
                    warningList.add(warningArr);
//                    批量插入
                    String warningIsSuccess = storeSqlDao.addWarning(warningList);
//                    打印日志
                    log.info(warningIsSuccess + "===" + Arrays.toString(warningArr));
                    break;
            }
        }
    }
}
