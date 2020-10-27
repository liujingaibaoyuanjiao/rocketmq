package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

public class FiveSecondsGPS {

    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String gpsLength;// gps长度
    private String longitude;// 经度
    private String latitude;// 纬度
    private String crcCheck;// CRC校验

    public FiveSecondsGPS(String[] strings) {
            startByte = strings[0];
            messageID = strings[1];
            messageLength = strings[2] + strings[3];
            serialNumber = strings[4] + strings[5];
            domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                    strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
            commandIdentifier = strings[18] + strings[19];
            gpsLength = strings[20];
            longitude = strings[21] + strings[22] + strings[23] + strings[24] + strings[25] + strings[26] + strings[27] + strings[28];
            latitude = strings[29] + strings[30] + strings[31] + strings[32] + strings[33] + strings[34] + strings[35] + strings[36];
            crcCheck = strings[37] + strings[38];
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

    public String getGpsLength() {
        return MyUtils.covert(gpsLength)+"";
    }

    public double getLongitude() {
        return MyUtils.getDouble(longitude);
    }

    public double getLatitude() {
        return MyUtils.getDouble(latitude);
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "FiveSecondsGPS{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", gpsLength='" + gpsLength + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
