package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

public class CarExerciseStateInformation {

    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String timeStamp;// 时间戳
    private String gpsSpeed;// gps速度
    private String threeAxisAcceleration;// 三轴加速度
    private String angularAcceleration;// 三轴角加速度
    private String oilMass;// 油量
    private String gear;// 档位
    private String speed;// 车速
    private String engineSpeed;// 发动机转速
    private String engineTemperature;// 发动机温度
    private String cabTemperature;// 驾驶室温度
    private String courseRadian;// 航向弧度
    private String crcCheck;// CRC校验


    public CarExerciseStateInformation(String[] strings) {

            startByte = strings[0];// 起始字节
            messageID = strings[1];// 消息标识
            messageLength = strings[2] + strings[3];// 消息长度
            serialNumber = strings[4] + strings[5];// 报文序列号
            domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] +
                    strings[11] + strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];// 域控制器ID
            commandIdentifier = strings[18] + strings[19];// 命令标识
            timeStamp = strings[20] + strings[21] + strings[22] + strings[23];// 时间戳
            gpsSpeed = strings[24] + strings[25];// gps速度
            threeAxisAcceleration = strings[26] + strings[27];// 三轴加速度
            angularAcceleration = strings[28] + strings[29];// 三轴角加速度
            oilMass = strings[30] + strings[31];// 油量
            gear = strings[32] + strings[33];// 档位
            speed = strings[34] + strings[35];// 车速
            engineSpeed = strings[36] + strings[37];// 发动机转速
            engineTemperature = strings[38] + strings[39];// 发动机温度
            cabTemperature = strings[40] + strings[41];// 驾驶室温度
            courseRadian = strings[42] + strings[43] + strings[44] + strings[45];// 航向弧度
            crcCheck = strings[46] + strings[47];// CRC校验
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

    public String getTimeStamp() {
        return MyUtils.covert(timeStamp)+"";
    }

    public String getGpsSpeed() {
        return MyUtils.covert(gpsSpeed)+"";
    }

    public String getThreeAxisAcceleration() {
        return threeAxisAcceleration;
    }

    public String getAngularAcceleration() {
        return angularAcceleration;
    }

    public String getOilMass() {
        return MyUtils.covert(oilMass)+"";
    }

    public String getGear() {
        return MyUtils.coverHexToChart(gear);
    }

    public String getSpeed() {

        return MyUtils.covert(speed)/100+"";
    }
    public String getEngineSpeed() {
        return MyUtils.covert(engineSpeed)+"";
    }

    public String getEngineTemperature() {
        return engineTemperature;
    }

    public String getCabTemperature() {
        return MyUtils.covert(cabTemperature)+"";
    }

    public String getCourseRadian() {
        return courseRadian;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "CarExerciseStateInformation{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", gpsSpeed='" + gpsSpeed + '\'' +
                ", threeAxisAcceleration='" + threeAxisAcceleration + '\'' +
                ", angularAcceleration='" + angularAcceleration + '\'' +
                ", oilMass='" + oilMass + '\'' +
                ", gear='" + gear + '\'' +
                ", speed='" + speed + '\'' +
                ", engineSpeed='" + engineSpeed + '\'' +
                ", engineTemperature='" + engineTemperature + '\'' +
                ", cabTemperature='" + cabTemperature + '\'' +
                ", courseRadian='" + courseRadian + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
