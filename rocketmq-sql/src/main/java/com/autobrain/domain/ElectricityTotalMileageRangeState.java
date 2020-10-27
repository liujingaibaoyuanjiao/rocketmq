package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

public class ElectricityTotalMileageRangeState {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String serialNumberOfReplyInstructionMessage;//回复指令报文序列号
    private String residualPowerSOC;//剩余电量SOC
    private String lifeMileage;//续航里程
    private String totalMileage;//总里程
    private String stateOfTheVehicle;//车辆状态
    private String voltageValueOfSmallBattery;//小电瓶电压值
    private String powerCellTemperature;//动力电池温度
    private String powerBatteryChargingVoltageValue;//动力电池充电电压值
    private String powerBatteryChargingCurrentValue;//动力电池充电电流值
    private String batteryPackPowerBatteryModel;//电池包动力电池型号
    private String  timeStamp;//时间戳
    private String  vehicleVINCode;//车辆VIN编码
    private String  crcCheck;//CRC校验

    public ElectricityTotalMileageRangeState(String[] strings) {
        startByte = strings[0];
        messageID = strings[1];
        messageLength = strings[2] + strings[3];
        serialNumber = strings[4] + strings[5];
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
        commandIdentifier = strings[18] + strings[19];
        serialNumberOfReplyInstructionMessage=strings[20] + strings[21];
        residualPowerSOC=strings[22];
        lifeMileage=strings[23]+strings[24];
        totalMileage=strings[25]+strings[26]+strings[27]+strings[28];
        stateOfTheVehicle=strings[29]+strings[30]+strings[31]+strings[32];
        voltageValueOfSmallBattery=strings[33]+strings[34];
        powerCellTemperature=strings[35]+strings[36];
        powerBatteryChargingVoltageValue=strings[37]+strings[38];
        powerBatteryChargingCurrentValue=strings[39]+strings[40];
        batteryPackPowerBatteryModel=strings[41]+strings[42]+strings[43]+strings[44]+strings[45]+strings[46]+strings[47]+strings[48];
        timeStamp=strings[49]+strings[50]+strings[51]+strings[52];
        vehicleVINCode=strings[53]+strings[54]+strings[55]+strings[56];
        crcCheck=strings[57]+strings[58];
    }

    public String getStartByte() {
        return startByte;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageLength() {
        return MyUtils.covert(messageLength)+"";
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getDomainControllerID() {
        return MyUtils.coverHexToChart(domainControllerID);
    }

    public String getCommandIdentifier() {
        return commandIdentifier;
    }

    public String getSerialNumberOfReplyInstructionMessage() {
        return serialNumberOfReplyInstructionMessage;
    }

    public String getResidualPowerSOC() {
        return MyUtils.covert(residualPowerSOC)+"";
    }

    public String getLifeMileage() {
        return MyUtils.covert(lifeMileage)+"";
    }

    public String getTotalMileage() {
        return MyUtils.covert(totalMileage)+"";
    }

    public String getStateOfTheVehicle() {
        return stateOfTheVehicle;
    }

    public String getVoltageValueOfSmallBattery() {
        return MyUtils.covert(voltageValueOfSmallBattery)+"";
    }

    public String getPowerCellTemperature() {
        return MyUtils.covert(powerCellTemperature)+"";
    }

    public String getPowerBatteryChargingVoltageValue() {
        return MyUtils.covert(powerBatteryChargingVoltageValue)+"";
    }

    public String getPowerBatteryChargingCurrentValue() {
        return MyUtils.covert(powerBatteryChargingCurrentValue)+"";
    }

    public String getBatteryPackPowerBatteryModel() {
        return batteryPackPowerBatteryModel;
    }

    public String getTimeStamp() {
        return MyUtils.getDate(timeStamp);
    }

    public String getVehicleVINCode() {
        return vehicleVINCode;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "ElectricityTotalMileageRangeState{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", serialNumberOfReplyInstructionMessage='" + serialNumberOfReplyInstructionMessage + '\'' +
                ", residualPowerSOC='" + residualPowerSOC + '\'' +
                ", lifeMileage='" + lifeMileage + '\'' +
                ", totalMileage='" + totalMileage + '\'' +
                ", stateOfTheVehicle='" + stateOfTheVehicle + '\'' +
                ", voltageValueOfSmallBattery='" + voltageValueOfSmallBattery + '\'' +
                ", powerCellTemperature='" + powerCellTemperature + '\'' +
                ", powerBatteryChargingVoltageValue='" + powerBatteryChargingVoltageValue + '\'' +
                ", powerBatteryChargingCurrentValue='" + powerBatteryChargingCurrentValue + '\'' +
                ", batteryPackPowerBatteryModel='" + batteryPackPowerBatteryModel + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", vehicleVINCode='" + vehicleVINCode + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
