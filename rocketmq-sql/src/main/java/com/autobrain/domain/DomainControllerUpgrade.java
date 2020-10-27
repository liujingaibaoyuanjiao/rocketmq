package com.autobrain.domain;

public class DomainControllerUpgrade {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String serialSize;// 回复流水号
    private String controlResult;// 控制结果
    private String currentDomainControllerSystemVersion;// 当前域控制器系统版本
    private String crcCheck;//CRC校验

    public DomainControllerUpgrade(String[] strings) {
        startByte=strings[0];
        messageID=strings[1];
        messageLength=strings[2]+strings[3];
        serialNumber=strings[4]+strings[5];
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
        commandIdentifier = strings[18] + strings[19];
        serialSize = strings[20] + strings[21];
        controlResult = strings[22];
        currentDomainControllerSystemVersion=strings[23]+strings[24]+strings[25]+strings[26]+strings[27]+strings[28];
        crcCheck=strings[29]+strings[30];
    }

    public String getStartByte() {
        return startByte;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageLength() {
        return messageLength;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getDomainControllerID() {
        return domainControllerID;
    }

    public String getCommandIdentifier() {
        return commandIdentifier;
    }

    public String getSerialSize() {
        return serialSize;
    }

    public String getControlResult() {
        return controlResult;
    }

    public String getCurrentDomainControllerSystemVersion() {
        return currentDomainControllerSystemVersion;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "domainControllerUpgrade{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", serialSize='" + serialSize + '\'' +
                ", controlResult='" + controlResult + '\'' +
                ", currentDomainControllerSystemVersion='" + currentDomainControllerSystemVersion + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
