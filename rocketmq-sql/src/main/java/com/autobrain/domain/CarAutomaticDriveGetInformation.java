package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

import java.math.BigInteger;
import java.sql.Timestamp;

public class CarAutomaticDriveGetInformation {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String timeStamp;// 时间戳
    private String steeringWheelCorner;//方向盘转角
    private String steeringWheelCornerTurnSpeed;//方向盘转速
    private String steeringDirectionIndicator;//转向方向标识
    private String horizontalFaultInformation;//横向故障信息
    private String steeringModeFeedback;//转向模式反馈
    private String wheelSteeringAngle; //车轮转向角度
    private String humanIntervention;//人工干预
    private String steeringWheelTorque;//方向盘扭矩
    private String transverseAcceleration;//横向加速度
    private String toIdentify;//转向标识
    private String steeringAngularVelocity; //转向角速度
    private String steeringAngle; //转向角度
    private String toModel; //转向模式
    private String transverseEnablingSignal; //横向使能信号
    private String carSpeed;//车速
    private String wheelSpeedMark; //轮速效标识
    private String yawingRate; //横摆率
    private String wheelDirection; //轮速方向
    private String wheelSpeed; //轮速
    private String longitudinalAcceleration;//纵向加速度
    private String longitudinalEnabledSignal;//纵向使能信号
    private String longitudinalFaultInformation;//纵向故障信息
    private String brakePedalOpening;//制动踏板开度
    private String brakeFluidPressure;//制动液压力值
    private String targetAcceleration;//目标加速度
    private String acceleratorPedalOpening;//加速踏板开度
    private String gearInformation;//档位信息
    private String EPB;//EPB
    private String wiper;//雨刷
    private String carDoorState;//车门状态
    private String highBeam;//远光灯
    private String dippedHeadlight;//近光灯
    private String gasPedalCondition;//油门踏板状态
    private String brakePedalCondition;//制动踏板状态
    private String fogLamps;//雾灯
    private String turnSignal;//转向灯
    private String signalOfTurnSignalDialRodSwitch;//转向灯拨杆开关信号
    private String dangerWarningLight;//危险警报灯
    private String switchSignalsSuchAsDangerAlarm;//危险警报等开关信号
    private String brakeLamp;//制动灯
    private String heartbeatHandshakeSignal;//心跳握手信号
    private String drivingModeFeedback;//驾驶模式反馈
    private String carState;//车辆状态
    private String remainingMileage;//剩余里程
    private String speedAddOrSubtractSwitch;//速度加减开关
    private String modeSwitch;//模式切换
    private String XCoordinateOfTheLocus;//轨迹点X坐标
    private String YCoordinateOfTheLocus;//轨迹点Y坐标
    private String obstaclesID;//障碍物ID
    private String XCoordinateOfTheObstaclePosition;//障碍物位置X坐标
    private String YCoordinateOfTheObstaclePosition;//障碍物位置Y坐标
    private String obstacleOrientation;//障碍物朝向
    private String VelocityInTheXAxisDirectionOfTheObstacle;//障碍物X轴方向速度
    private String VelocityInTheYAxisDirectionOfTheObstacle;//障碍物Y轴方向速度
    private String barrierLong;//障碍物长
    private String barrierWidth;//障碍物宽
    private String barrierHigh;//障碍物高
    private String GPSTime;//GPS时间
    private String predictedTrajectoryDuration;//预测轨迹时长
    private String barrierState;//障碍物状态
    private String obstaclePriority;//障碍物优先级
    private String obstacleTrajectoryProbability;//障碍物轨迹概率
    private String obstructionBehavior;//障碍物行为
    private String theXCoordinateOfTheLocus;//轨迹点X坐标
    private String theYCoordinateOfTheLocus;//轨迹点Y坐标
    private String theZCoordinateOfTheLocus;//轨迹点Z坐标
    private String trajectoryPointOrientation;//轨迹点朝向
    private String locusPointRate;//轨迹点速率
    private String trajectoryPointAcceleration;//轨迹点加速度
    private String relativeTimeOfLocusPoint;//轨迹点相对时间
    private String theRoadIDWhereTheTrackPointIs;//轨迹点所在道路ID
    private String trafficLightsIdentifyXCoordinates;//红绿灯识别X坐标
    private String trafficLightsIdentifyYCoordinates;//红绿灯识别Y坐标
    private String trafficLightIdentificationMoment;//红绿灯识别时刻
    private String trafficLightIdentificationNumber;//红绿灯识别次数
    private String vehicleIdentificationXCoordinates;//机动车识别X坐标
    private String vehicleIdentificationYCoordinates;//机动车识别Y坐标
    private String motorVehicleIdentificationMoment;//机动车识别时刻
    private String numberOfMotorVehicleIdentification;//机动车识别次数
    private String theBicycleRecognizesTheXCoordinate;//自行车识别X坐标
    private String theBicycleRecognizesTheYCoordinate;//自行车识别Y坐标
    private String bicycleIdentificationMoment;//自行车识别时刻
    private String bicycleIdentificationNumber;//自行车识别次数
    private String pedestrianRecognitionXCoordinate;// 行人识别X坐标
    private String pedestrianRecognitionYCoordinate;// 行人识别Y坐标
    private String pedestrianRecognitionTime;// 行人识别时刻
    private String pedestrianRecognitionTimes;// 行人识别次数
    private String trafficSignsIdentifyXCoordinates;//交通标识识别X坐标
    private String trafficSignsIdentifyYCoordinates;//交通标识识别Y坐标
    private String trafficSignIdentificationTime;//交通标识识别时刻
    private String numberOfTrafficSigns;//交通标识识别次数
    private String crcCheck;//CRC check

    public CarAutomaticDriveGetInformation(String[] strings) {
        startByte = strings[0]; // 起始字节
        messageID = strings[1]; // 消息标识
        messageLength = strings[2] + strings[3];// 消息长度
        serialNumber = strings[4] + strings[5];// 报文序列
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];//域控制器ID
        commandIdentifier = strings[18] + strings[19];//命令标识
        timeStamp = strings[20] + strings[21] + strings[22] + strings[23];//时间戳
        steeringWheelCorner = strings[24] + strings[25];// 方向盘转角
        steeringWheelCornerTurnSpeed = strings[26] + strings[27];// 方向盘转速
        steeringDirectionIndicator = strings[28];// 转向方向标识
        horizontalFaultInformation = strings[29]; //横向故障信息
        steeringModeFeedback = strings[30];//转向模式反馈
        wheelSteeringAngle = strings[31] + strings[32]; //车轮转向角度
        humanIntervention = strings[33];//人工干预
        steeringWheelTorque = strings[34] + strings[35];//方向盘扭矩
        transverseAcceleration = strings[36] + strings[37];//横向加速度
        toIdentify = strings[38];//转向标识
        steeringAngularVelocity = strings[39] + strings[40]; //转向角速度
        steeringAngle = strings[41] + strings[42]; //转向角度
        toModel = strings[43]; //转向模式
        transverseEnablingSignal = strings[44]; //横向使能信号
        carSpeed = strings[45] + strings[46];//车速
        wheelSpeedMark = strings[47]; //轮速效标识
        yawingRate = strings[48] + strings[49]; //横摆率
        wheelDirection = strings[50]; //轮速方向
        wheelSpeed = strings[51] + strings[52]; //轮速
        longitudinalAcceleration = strings[53] + strings[54];//纵向加速度
        longitudinalEnabledSignal = strings[55];//纵向使能信号
        longitudinalFaultInformation = strings[56];//纵向故障信息
        brakePedalOpening = strings[57] + strings[58];//制动踏板开度
        brakeFluidPressure = strings[59] + strings[60];//制动液压力值
        targetAcceleration = strings[61] + strings[62];//目标加速度
        acceleratorPedalOpening = strings[63] + strings[64];//加速踏板开度
        gearInformation = strings[65];//档位信息
        EPB = strings[66];//EPB
        wiper = strings[67];//雨刷
        carDoorState = strings[68];//车门状态
        highBeam = strings[69];//远光灯
        dippedHeadlight = strings[70];//近光灯
        gasPedalCondition = strings[71];//油门踏板状态
        brakePedalCondition = strings[72];//制动踏板状态
        fogLamps = strings[73];//雾灯
        turnSignal = strings[74];//转向灯
        signalOfTurnSignalDialRodSwitch = strings[75];//转向灯拨杆开关信号
        dangerWarningLight = strings[76];//危险警报灯
        switchSignalsSuchAsDangerAlarm = strings[77];//危险警报等开关信号
        brakeLamp = strings[78];//制动灯
        heartbeatHandshakeSignal = strings[79];//心跳握手信号
        drivingModeFeedback = strings[80];//驾驶模式反馈
        carState = strings[81];//车辆状态
        remainingMileage = strings[82] + strings[83];//剩余里程
        speedAddOrSubtractSwitch = strings[84];//速度加减开关
        modeSwitch = strings[85];//模式切换
        XCoordinateOfTheLocus = strings[86] + strings[87] + strings[88] + strings[89] + strings[90] + strings[91] + strings[92] + strings[93];//轨迹点X坐标
        YCoordinateOfTheLocus = strings[94] + strings[95] + strings[96] + strings[97] + strings[98] + strings[99] + strings[100] + strings[101];//轨迹点Y坐标
        obstaclesID = strings[102];//障碍物ID
        XCoordinateOfTheObstaclePosition = strings[103] + strings[104] + strings[105] + strings[106] + strings[107] + strings[108] + strings[109] + strings[110];//障碍物位置X坐标
        YCoordinateOfTheObstaclePosition = strings[111] + strings[112] + strings[113] + strings[114] + strings[115] + strings[116] + strings[117] + strings[118];//障碍物位置Y坐标
        obstacleOrientation = strings[119] + strings[120];//障碍物朝向
        VelocityInTheXAxisDirectionOfTheObstacle = strings[121] + strings[122];//障碍物X轴方向速度
        VelocityInTheYAxisDirectionOfTheObstacle = strings[123] + strings[124];//障碍物Y轴方向速度
        barrierLong = strings[125] + strings[126];//障碍物长
        barrierWidth = strings[127] + strings[128];//障碍物宽
        barrierHigh = strings[129] + strings[130];//障碍物高
        GPSTime = strings[131] + strings[132] + strings[133] + strings[134];//GPS时间
        predictedTrajectoryDuration = strings[135] + strings[136];//预测轨迹时长
        barrierState = strings[137];//障碍物状态
        obstaclePriority = strings[138];//障碍物优先级
        obstacleTrajectoryProbability = strings[139] + strings[140];//障碍物轨迹概率
        obstructionBehavior = strings[141];//障碍物行为
        theXCoordinateOfTheLocus = strings[142] + strings[143] + strings[144] + strings[145] + strings[146] + strings[147] + strings[148] + strings[149];//轨迹点X坐标
        theYCoordinateOfTheLocus = strings[150] + strings[151] + strings[152] + strings[153] + strings[154] + strings[155] + strings[156] + strings[157];//轨迹点Y坐标
        theZCoordinateOfTheLocus = strings[158] + strings[159] + strings[160] + strings[161] + strings[162] + strings[163] + strings[164] + strings[165];//轨迹点Z坐标
        trajectoryPointOrientation = strings[166] + strings[167];//轨迹点朝向
        locusPointRate = strings[168] + strings[169];//轨迹点速率
        trajectoryPointAcceleration = strings[170] + strings[171];//轨迹点加速度
        relativeTimeOfLocusPoint = strings[172] + strings[173] + strings[174] + strings[175];//轨迹点相对时间
        theRoadIDWhereTheTrackPointIs = strings[176];//轨迹点所在道路ID
        trafficLightsIdentifyXCoordinates = strings[177] + strings[178] + strings[179] + strings[180] + strings[181] + strings[182] + strings[183] + strings[184];//红绿灯识别X坐标
        trafficLightsIdentifyYCoordinates = strings[185] + strings[186] + strings[187] + strings[188] + strings[189] + strings[190] + strings[191] + strings[192];//红绿灯识别Y坐标
        trafficLightIdentificationMoment = strings[193] + strings[194] + strings[195] + strings[196];//红绿灯识别时刻
        trafficLightIdentificationNumber = strings[197] + strings[198];//红绿灯识别次数
        vehicleIdentificationXCoordinates = strings[199] + strings[200] + strings[201] + strings[202] + strings[203] + strings[204] + strings[205] + strings[206];//机动车识别X坐标
        vehicleIdentificationYCoordinates = strings[207] + strings[208] + strings[209] + strings[210] + strings[211] + strings[212] + strings[213] + strings[214];//机动车识别Y坐标
        motorVehicleIdentificationMoment = strings[215] + strings[216] + strings[217] + strings[218];//机动车识别时刻
        numberOfMotorVehicleIdentification = strings[219] + strings[220];//机动车识别次数
        theBicycleRecognizesTheXCoordinate = strings[221] + strings[222] + strings[223] + strings[224] + strings[225] + strings[226] + strings[227] + strings[228];//自行车识别X坐标
        theBicycleRecognizesTheYCoordinate = strings[229] + strings[230] + strings[231] + strings[232] + strings[233] + strings[234] + strings[235] + strings[236];//自行车识别Y坐标
        bicycleIdentificationMoment = strings[237] + strings[238] + strings[239] + strings[240];//自行车识别时刻
        bicycleIdentificationNumber = strings[241] + strings[242];//自行车识别次数

        pedestrianRecognitionXCoordinate = strings[243] + strings[244] + strings[245] + strings[246] + strings[247] + strings[248] + strings[249] + strings[250];// 行人识别X坐标
        pedestrianRecognitionYCoordinate = strings[251] + strings[252] + strings[253] + strings[254] + strings[255] + strings[256] + strings[257] + strings[258];// 行人识别Y坐标
        pedestrianRecognitionTime = strings[259] + strings[260] + strings[261] + strings[262];// 行人识别时刻
        pedestrianRecognitionTimes = strings[263] + strings[264];// 行人识别次数


        trafficSignsIdentifyXCoordinates = strings[265] + strings[266] + strings[267] + strings[268] + strings[269] + strings[270] + strings[271] + strings[272];//交通标识识别X坐标
        trafficSignsIdentifyYCoordinates = strings[273] + strings[274] + strings[275] + strings[276] + strings[277] + strings[278] + strings[279] + strings[280];//交通标识识别Y坐标
        trafficSignIdentificationTime = strings[281] + strings[282] + strings[283] + strings[284];//交通标识识别时刻
        numberOfTrafficSigns = strings[285] + strings[286];//交通标识识别次数
        crcCheck = strings[287] + strings[288];//CRC check
    }

    public String getStartByte() {
        return startByte;
    }// 起始字节

    public String getMessageID() {
        return messageID;
    }// 消息标识

    public Integer getMessageLength() {
        return MyUtils.covert(messageLength); // 消息长度
    }

    public String getSerialNumber() {
        return serialNumber;
    }// 报文序列

    public String getDomainControllerID() {
        return MyUtils.coverHexToChart(domainControllerID);
    }// 域控制器ID

    public String getCommandIdentifier() {
        return commandIdentifier;
    }// 命令标识

    public String getTimeStamp() {

        return MyUtils.getDate();
    }// 时间戳

    public String getSteeringWheelCorner() {
        return steeringWheelCorner;
    }// 方向盘转角

    public String getSteeringWheelCornerTurnSpeed() {
        return steeringWheelCornerTurnSpeed;
    } //方向盘转速

    public String getSteeringDirectionIndicator() {
        return steeringDirectionIndicator;
    } // 转向方向标识

    public String getHorizontalFaultInformation() {
        return horizontalFaultInformation;
    }// 横向故障信息

    public String getSteeringModeFeedback() {
        return steeringModeFeedback;
    }// 转向模式反馈

    public String getWheelSteeringAngle() {
        return wheelSteeringAngle;
    }// 车轮转向角度

    public String getHumanIntervention() {
        return humanIntervention;
    }// 人工干预

    public String getSteeringWheelTorque() {
        return steeringWheelTorque;
    }// 方向盘扭矩

    public String getTransverseAcceleration() {
        return transverseAcceleration;
    }// 横向加速度

    public String getToIdentify() {
        return toIdentify;
    }// 转向标识

    public String getSteeringAngularVelocity() {
        return steeringAngularVelocity;
    }// 转向角速度

    public String getSteeringAngle() {
        return steeringAngle;
    }// 转向角度

    public String getToModel() {
        return toModel;
    }// 转向模式

    public String getTransverseEnablingSignal() {
        return transverseEnablingSignal;
    } //横向使能信号

    public Double getCarSpeed() {
        return new BigInteger(carSpeed, 16).doubleValue();
    }// 车速

    public String getWheelSpeedMark() {
        return wheelSpeedMark;
    }// 轮速效标识

    public String getYawingRate() {
        return yawingRate;
    }// 横摆率

    public String getWheelDirection() {
        return wheelDirection;
    }// 轮速方向

    public String getWheelSpeed() {
        return wheelSpeed;
    }// 轮速

    public String getLongitudinalAcceleration() {
        return longitudinalAcceleration;
    } //纵向加速度

    public String getLongitudinalEnabledSignal() {
        return longitudinalEnabledSignal;
    }// 纵向使能信号

    public String getLongitudinalFaultInformation() {
        return longitudinalFaultInformation;
    }// 纵向故障信息

    public String getBrakePedalOpening() {
        return brakePedalOpening;
    }// 制动踏板开度

    public String getBrakeFluidPressure() {
        return brakeFluidPressure;
    }// 制动液压力值

    public String getTargetAcceleration() {
        return targetAcceleration;
    }// 目标加速度

    public String getAcceleratorPedalOpening() {
        return acceleratorPedalOpening;
    }// 加速踏板开度

    public String getGearInformation() {
        return gearInformation;
    }// 档位信息

    public String getEPB() {
        return EPB;
    }// EPB

    public String getWiper() {
        return wiper;
    }// 雨刷

    public String getCarDoorState() {
        return carDoorState;
    }//  车门状态

    public String getHighBeam() {
        return highBeam;
    }// 远光灯

    public String getDippedHeadlight() {
        return dippedHeadlight;
    }// 近光灯

    public String getGasPedalCondition() {
        return gasPedalCondition;
    }// 油门踏板状态

    public String getBrakePedalCondition() {
        return brakePedalCondition;
    }// 制动踏板状态

    public String getFogLamps() {
        return fogLamps;
    }// 雾灯

    public String getTurnSignal() {
        return turnSignal;
    }// 转向灯

    public String getSignalOfTurnSignalDialRodSwitch() {
        return signalOfTurnSignalDialRodSwitch;
    }// 转向灯拨杆开关信号

    public String getDangerWarningLight() {
        return dangerWarningLight;
    }// 危险警报灯

    public String getSwitchSignalsSuchAsDangerAlarm() {
        return switchSignalsSuchAsDangerAlarm;
    }// 危险警报等开关信号

    public String getBrakeLamp() {
        return brakeLamp;
    }//制动灯

    public String getHeartbeatHandshakeSignal() {
        return heartbeatHandshakeSignal;
    }// 心跳握手信号

    public String getDrivingModeFeedback() {
        return drivingModeFeedback;
    }// 驾驶模式反馈

    public String getCarState() {
        return carState;
    }// 车辆状态

    public String getRemainingMileage() {
        return remainingMileage;
    }// 剩余里程

    public String getSpeedAddOrSubtractSwitch() {
        return speedAddOrSubtractSwitch;
    }//速度加减开关

    public String getModeSwitch() {
        return modeSwitch;
    }//模式切换

    public Double getXCoordinateOfTheLocus() {
        return MyUtils.getDouble(XCoordinateOfTheLocus);
    }//  轨迹点X坐标

    public Double getYCoordinateOfTheLocus() {
        return MyUtils.getDouble(YCoordinateOfTheLocus);
    }//轨迹点Y坐标

    public String getObstaclesID() {
        return obstaclesID;
    }//障碍物ID

    public Double getXCoordinateOfTheObstaclePosition() {
        return MyUtils.getDouble(XCoordinateOfTheObstaclePosition);
    }//障碍物位置X坐标

    public Double getYCoordinateOfTheObstaclePosition() {
        return MyUtils.getDouble(YCoordinateOfTheObstaclePosition);
    }//障碍物位置Y坐标

    public String getObstacleOrientation() {
        return obstacleOrientation;
    }// 障碍物朝向

    public String getVelocityInTheXAxisDirectionOfTheObstacle() {
        return VelocityInTheXAxisDirectionOfTheObstacle;
    }// 障碍物X轴方向速度

    public String getVelocityInTheYAxisDirectionOfTheObstacle() {
        return VelocityInTheYAxisDirectionOfTheObstacle;
    } //障碍物Y轴方向速度

    public String getBarrierLong() {
        return barrierLong;
    } //障碍物长

    public String getBarrierWidth() {
        return barrierWidth;
    }//障碍物宽

    public String getBarrierHigh() {
        return barrierHigh;
    }//障碍物高

    public Timestamp getGPSTime() {
        return new Timestamp(System.currentTimeMillis());
    }// GPS时间

    public String getPredictedTrajectoryDuration() {
        return predictedTrajectoryDuration;
    }// 预测轨迹时长

    public String getBarrierState() {
        return barrierState;
    }// 障碍物状态

    public String getObstaclePriority() {
        return obstaclePriority;
    }// 障碍物优先级

    public String getObstacleTrajectoryProbability() {
        return obstacleTrajectoryProbability;
    }// 障碍物轨迹概率

    public String getObstructionBehavior() {
        return obstructionBehavior;
    }// 障碍物行为

    public Double getTheXCoordinateOfTheLocus() {
        return MyUtils.getDouble(theXCoordinateOfTheLocus);
    }// 轨迹点X坐标

    public Double getTheYCoordinateOfTheLocus() {
        return MyUtils.getDouble(theYCoordinateOfTheLocus);
    }// 轨迹点Y坐标

    public Double getTheZCoordinateOfTheLocus() {
        return MyUtils.getDouble(theZCoordinateOfTheLocus);
    }// 轨迹点Z坐标

    public String getTrajectoryPointOrientation() {
        return trajectoryPointOrientation;
    }// 轨迹点朝向

    public String getLocusPointRate() {
        return locusPointRate;
    }// 轨迹点速率

    public String getTrajectoryPointAcceleration() {
        return trajectoryPointAcceleration;
    }// 轨迹点加速度

    public Timestamp getRelativeTimeOfLocusPoint() {
        return new Timestamp(System.currentTimeMillis());
    }// 轨迹点相对时间

    public String getTheRoadIDWhereTheTrackPointIs() {
        return theRoadIDWhereTheTrackPointIs;
    }// 轨迹点所在道路ID

    public Double getTrafficLightsIdentifyXCoordinates() {
        return MyUtils.getDouble(trafficLightsIdentifyXCoordinates);
    }// 红绿灯识别X坐标

    public Double getTrafficLightsIdentifyYCoordinates() {
        return MyUtils.getDouble(trafficLightsIdentifyYCoordinates);
    }// 红绿灯识别Y坐标

    public Timestamp getTrafficLightIdentificationMoment() {
        return new Timestamp(System.currentTimeMillis());
    }// 红绿灯识别时刻

    public Long getTrafficLightIdentificationNumber() {
        return new BigInteger(trafficLightIdentificationNumber, 16).longValue();
    }// 红绿灯识别次数

    public Double getVehicleIdentificationXCoordinates() {
        return MyUtils.getDouble(vehicleIdentificationXCoordinates);
    }// 机动车识别X坐标

    public Double getVehicleIdentificationYCoordinates() {
        return MyUtils.getDouble(vehicleIdentificationYCoordinates);
    }// 机动车识别Y坐标

    public Timestamp getMotorVehicleIdentificationMoment() {
        return new Timestamp(System.currentTimeMillis());

    }//机动车识别时刻

    public Long getNumberOfMotorVehicleIdentification() {
        return new BigInteger(numberOfMotorVehicleIdentification, 16).longValue();
    }// 机动车识别次数

    public Double getTheBicycleRecognizesTheXCoordinate() {
        return MyUtils.getDouble(theBicycleRecognizesTheXCoordinate);
    }// 自行车识别X坐标

    public Double getTheBicycleRecognizesTheYCoordinate() {
        return MyUtils.getDouble(theBicycleRecognizesTheYCoordinate);
    }// 自行车识别Y坐标

    public Timestamp getBicycleIdentificationMoment() {
        return new Timestamp(System.currentTimeMillis());
    }//自行车识别时刻

    public Long getBicycleIdentificationNumber() {
        return new BigInteger(bicycleIdentificationNumber, 16).longValue();
    }// 自行车识别次数

    public Double getPedestrianRecognitionXCoordinate() {
        return MyUtils.getDouble(pedestrianRecognitionXCoordinate);
    }// 行人识别X坐标

    public Double getPedestrianRecognitionYCoordinate() {
        return MyUtils.getDouble(pedestrianRecognitionYCoordinate);
    }// 行人识别Y坐标

    public Timestamp getPedestrianRecognitionTime() {
        return new Timestamp(System.currentTimeMillis());
    }// 行人识别时刻

    public Long getPedestrianRecognitionTimes() {
        return new BigInteger(pedestrianRecognitionTimes, 16).longValue();
    }// 行人识别次数

    public Double getTrafficSignsIdentifyXCoordinates() {
        return MyUtils.getDouble(trafficSignsIdentifyXCoordinates);
    }// 交通标识识别X坐标

    public Double getTrafficSignsIdentifyYCoordinates() {
        return MyUtils.getDouble(trafficSignsIdentifyYCoordinates);
    }// 交通标识识别Y坐标

    public String getTrafficSignIdentificationTime() {
        return trafficSignIdentificationTime;
    }// 交通标识识别时刻

    public Long getNumberOfTrafficSigns() {
        return new BigInteger(numberOfTrafficSigns, 16).longValue();
    }// 交通标识识别次数

    public String getCrcCheck() {
        return crcCheck;
    }// CRC校验

    @Override
    public String toString() {
        return "CarAutomaticDriveGetInformation{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", steeringWheelCorner='" + steeringWheelCorner + '\'' +
                ", steeringWheelCornerTurnSpeed='" + steeringWheelCornerTurnSpeed + '\'' +
                ", steeringDirectionIndicator='" + steeringDirectionIndicator + '\'' +
                ", horizontalFaultInformation='" + horizontalFaultInformation + '\'' +
                ", steeringModeFeedback='" + steeringModeFeedback + '\'' +
                ", wheelSteeringAngle='" + wheelSteeringAngle + '\'' +
                ", humanIntervention='" + humanIntervention + '\'' +
                ", steeringWheelTorque='" + steeringWheelTorque + '\'' +
                ", transverseAcceleration='" + transverseAcceleration + '\'' +
                ", toIdentify='" + toIdentify + '\'' +
                ", steeringAngularVelocity='" + steeringAngularVelocity + '\'' +
                ", steeringAngle='" + steeringAngle + '\'' +
                ", toModel='" + toModel + '\'' +
                ", transverseEnablingSignal='" + transverseEnablingSignal + '\'' +
                ", carSpeed='" + carSpeed + '\'' +
                ", wheelSpeedMark='" + wheelSpeedMark + '\'' +
                ", yawingRate='" + yawingRate + '\'' +
                ", wheelDirection='" + wheelDirection + '\'' +
                ", wheelSpeed='" + wheelSpeed + '\'' +
                ", longitudinalAcceleration='" + longitudinalAcceleration + '\'' +
                ", longitudinalEnabledSignal='" + longitudinalEnabledSignal + '\'' +
                ", longitudinalFaultInformation='" + longitudinalFaultInformation + '\'' +
                ", brakePedalOpening='" + brakePedalOpening + '\'' +
                ", brakeFluidPressure='" + brakeFluidPressure + '\'' +
                ", targetAcceleration='" + targetAcceleration + '\'' +
                ", acceleratorPedalOpening='" + acceleratorPedalOpening + '\'' +
                ", gearInformation='" + gearInformation + '\'' +
                ", EPB='" + EPB + '\'' +
                ", wiper='" + wiper + '\'' +
                ", carDoorState='" + carDoorState + '\'' +
                ", highBeam='" + highBeam + '\'' +
                ", dippedHeadlight='" + dippedHeadlight + '\'' +
                ", gasPedalCondition='" + gasPedalCondition + '\'' +
                ", brakePedalCondition='" + brakePedalCondition + '\'' +
                ", fogLamps='" + fogLamps + '\'' +
                ", turnSignal='" + turnSignal + '\'' +
                ", signalOfTurnSignalDialRodSwitch='" + signalOfTurnSignalDialRodSwitch + '\'' +
                ", dangerWarningLight='" + dangerWarningLight + '\'' +
                ", switchSignalsSuchAsDangerAlarm='" + switchSignalsSuchAsDangerAlarm + '\'' +
                ", brakeLamp='" + brakeLamp + '\'' +
                ", heartbeatHandshakeSignal='" + heartbeatHandshakeSignal + '\'' +
                ", drivingModeFeedback='" + drivingModeFeedback + '\'' +
                ", carState='" + carState + '\'' +
                ", remainingMileage='" + remainingMileage + '\'' +
                ", speedAddOrSubtractSwitch='" + speedAddOrSubtractSwitch + '\'' +
                ", modeSwitch='" + modeSwitch + '\'' +
                ", XCoordinateOfTheLocus='" + XCoordinateOfTheLocus + '\'' +
                ", YCoordinateOfTheLocus='" + YCoordinateOfTheLocus + '\'' +
                ", obstaclesID='" + obstaclesID + '\'' +
                ", XCoordinateOfTheObstaclePosition='" + XCoordinateOfTheObstaclePosition + '\'' +
                ", YCoordinateOfTheObstaclePosition='" + YCoordinateOfTheObstaclePosition + '\'' +
                ", obstacleOrientation='" + obstacleOrientation + '\'' +
                ", VelocityInTheXAxisDirectionOfTheObstacle='" + VelocityInTheXAxisDirectionOfTheObstacle + '\'' +
                ", VelocityInTheYAxisDirectionOfTheObstacle='" + VelocityInTheYAxisDirectionOfTheObstacle + '\'' +
                ", barrierLong='" + barrierLong + '\'' +
                ", barrierWidth='" + barrierWidth + '\'' +
                ", barrierHigh='" + barrierHigh + '\'' +
                ", GPSTime='" + GPSTime + '\'' +
                ", predictedTrajectoryDuration='" + predictedTrajectoryDuration + '\'' +
                ", barrierState='" + barrierState + '\'' +
                ", obstaclePriority='" + obstaclePriority + '\'' +
                ", obstacleTrajectoryProbability='" + obstacleTrajectoryProbability + '\'' +
                ", obstructionBehavior='" + obstructionBehavior + '\'' +
                ", theXCoordinateOfTheLocus='" + theXCoordinateOfTheLocus + '\'' +
                ", theYCoordinateOfTheLocus='" + theYCoordinateOfTheLocus + '\'' +
                ", theZCoordinateOfTheLocus='" + theZCoordinateOfTheLocus + '\'' +
                ", trajectoryPointOrientation='" + trajectoryPointOrientation + '\'' +
                ", locusPointRate='" + locusPointRate + '\'' +
                ", trajectoryPointAcceleration='" + trajectoryPointAcceleration + '\'' +
                ", relativeTimeOfLocusPoint='" + relativeTimeOfLocusPoint + '\'' +
                ", theRoadIDWhereTheTrackPointIs='" + theRoadIDWhereTheTrackPointIs + '\'' +
                ", trafficLightsIdentifyXCoordinates='" + trafficLightsIdentifyXCoordinates + '\'' +
                ", trafficLightsIdentifyYCoordinates='" + trafficLightsIdentifyYCoordinates + '\'' +
                ", trafficLightIdentificationMoment='" + trafficLightIdentificationMoment + '\'' +
                ", trafficLightIdentificationNumber='" + trafficLightIdentificationNumber + '\'' +
                ", vehicleIdentificationXCoordinates='" + vehicleIdentificationXCoordinates + '\'' +
                ", vehicleIdentificationYCoordinates='" + vehicleIdentificationYCoordinates + '\'' +
                ", motorVehicleIdentificationMoment='" + motorVehicleIdentificationMoment + '\'' +
                ", numberOfMotorVehicleIdentification='" + numberOfMotorVehicleIdentification + '\'' +
                ", theBicycleRecognizesTheXCoordinate='" + theBicycleRecognizesTheXCoordinate + '\'' +
                ", theBicycleRecognizesTheYCoordinate='" + theBicycleRecognizesTheYCoordinate + '\'' +
                ", bicycleIdentificationMoment='" + bicycleIdentificationMoment + '\'' +
                ", bicycleIdentificationNumber='" + bicycleIdentificationNumber + '\'' +
                ", pedestrianRecognitionXCoordinate='" + pedestrianRecognitionXCoordinate + '\'' +
                ", pedestrianRecognitionYCoordinate='" + pedestrianRecognitionYCoordinate + '\'' +
                ", pedestrianRecognitionTime='" + pedestrianRecognitionTime + '\'' +
                ", pedestrianRecognitionTimes='" + pedestrianRecognitionTimes + '\'' +
                ", trafficSignsIdentifyXCoordinates='" + trafficSignsIdentifyXCoordinates + '\'' +
                ", trafficSignsIdentifyYCoordinates='" + trafficSignsIdentifyYCoordinates + '\'' +
                ", trafficSignIdentificationTime='" + trafficSignIdentificationTime + '\'' +
                ", numberOfTrafficSigns='" + numberOfTrafficSigns + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
