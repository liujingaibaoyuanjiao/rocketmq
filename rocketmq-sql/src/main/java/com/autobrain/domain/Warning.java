package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

public class Warning {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String  warningType;// 预警类型
    private String  voltageValue;// 电压值
    private String timeStamp;// 时间戳
    private String gpsLength;// gps长度
    private String longitude;// 经度
    private String latitude;// 纬度
    private String acceleration;// 加速度
    private String angularAcceleration;// 角加速度
    private String faultCode;// 故障码
    private String  crcCheck;//CRC校验

    public Warning(String[] strings) {
        startByte = strings[0];
        messageID = strings[1];
        messageLength = strings[2] + strings[3];
        serialNumber = strings[4] + strings[5];
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
        commandIdentifier = strings[18] + strings[19];
        warningType = strings[20];
        voltageValue = strings[21]+strings[22];
        timeStamp = strings[23]+strings[24]+strings[25]+strings[26];
        gpsLength=strings[27]+strings[28];
        longitude=strings[29]+strings[30]+strings[31]+strings[32]+strings[33]+strings[34]+strings[35]+strings[36];
        latitude=strings[37]+strings[38]+strings[39]+strings[40]+strings[41]+strings[42]+strings[43]+strings[44];
        acceleration=strings[45]+strings[46];
        angularAcceleration=strings[47]+strings[48];
        faultCode=strings[49];
        crcCheck=strings[50]+strings[51];
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

    public String getWarningType() {
        return warningType;
    }

    public String getVoltageValue() {
        return MyUtils.covert(voltageValue)+"";
    }

    public String getTimeStamp() {
        return MyUtils.getDate(timeStamp);
    }

    public String getGpsLength() {
        return MyUtils.covert(gpsLength)+"";
    }

    public String getLongitude() {
        return MyUtils.getDouble(longitude)+"";
    }

    public String getLatitude() {
        return MyUtils.getDouble(latitude)+"";
    }

    public String getAcceleration() {
        return MyUtils.covert(acceleration)+"";
    }

    public String getAngularAcceleration() {
        return MyUtils.covert(angularAcceleration)+"";
    }

    public String getFaultCode() {
        return faultCode;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "Warning{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", warningType='" + warningType + '\'' +
                ", voltageValue='" + voltageValue + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", gpsLength='" + gpsLength + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", acceleration='" + acceleration + '\'' +
                ", angularAcceleration='" + angularAcceleration + '\'' +
                ", faultCode='" + faultCode + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
