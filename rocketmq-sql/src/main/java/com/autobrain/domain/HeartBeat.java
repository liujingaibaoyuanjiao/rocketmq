package com.autobrain.domain;

public class HeartBeat {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String voltageValue;// 电压值
    private String crcCheck;// CRC校验

    public HeartBeat(String[] strings) {
        if (strings.length>=23) {
            startByte = strings[0];
            messageID = strings[1];
            messageLength = strings[2] + strings[3];
            serialNumber = strings[4] + strings[5];
            domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                    strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
            commandIdentifier = strings[18] + strings[19];
            voltageValue = strings[20] + strings[21];
            crcCheck = strings[22] + strings[23];
        }
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

    public String getVoltageValue() {
        return voltageValue;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "HeartBeat{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", voltageValue='" + voltageValue + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
