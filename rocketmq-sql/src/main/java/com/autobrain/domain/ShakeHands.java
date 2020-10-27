package com.autobrain.domain;

public class ShakeHands {

    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String systemOneBoardFirmwareVersionNumber;// 系统1板固件版本号
    private String bluetoothMAC;// 蓝牙MAC
    private String bluetoothVersionNumber; // 蓝牙版本号
    private String simICCID; //SIMICCID
    private String systemTwoBoardFirmwareVersionNumber;//系统2板固件版本号
    private String systemTwoBoardSN;// 系统2板SN号
    private String chassisNumber;// 车架号
    private String communicationModuleFirmwareVersion;// 通讯模块固件版本
    private String crcCheck;// CRC校验

    public ShakeHands(String[] strings) {
        if(strings.length>=92) {
            startByte = strings[0];
            messageID = strings[1];
            messageLength = strings[2] + strings[3];
            serialNumber = strings[4] + strings[5];
            domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                    strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
            commandIdentifier = strings[18] + strings[19];
            systemOneBoardFirmwareVersionNumber = strings[20] + strings[21] + strings[22];
            bluetoothMAC = strings[23] + strings[24] + strings[25] + strings[26] + strings[27] + strings[28];
            bluetoothVersionNumber = strings[29] + strings[30] + strings[31] + strings[32];
            simICCID = strings[33] + strings[34] + strings[35] + strings[36] + strings[37] + strings[38] + strings[39] + strings[40] + strings[41] + strings[42] +
                    strings[43] + strings[44] + strings[45] + strings[46] + strings[47] + strings[48] + strings[49] + strings[50] + strings[51] + strings[52];
            systemTwoBoardFirmwareVersionNumber = strings[53] + strings[54] + strings[55];
            systemTwoBoardSN = strings[56] + strings[57] + strings[58] + strings[59] + strings[60] + strings[61] +
                    strings[62] + strings[63] + strings[64] + strings[65] + strings[66] + strings[67];
            chassisNumber = strings[68] + strings[69] + strings[70] + strings[71] + strings[72] + strings[73] + strings[74] + strings[75] + strings[76]
                    + strings[77] + strings[78] + strings[79] + strings[80] + strings[81] + strings[82] + strings[83] + strings[84];
            communicationModuleFirmwareVersion = strings[85] + strings[86] + strings[87] + strings[88] + strings[89] + strings[90];
            crcCheck = strings[91] + strings[92];
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

    public String getSystemOneBoardFirmwareVersionNumber() {
        return systemOneBoardFirmwareVersionNumber;
    }

    public String getBluetoothMAC() {
        return bluetoothMAC;
    }

    public String getBluetoothVersionNumber() {
        return bluetoothVersionNumber;
    }

    public String getSimICCID() {
        return simICCID;
    }

    public String getSystemTwoBoardFirmwareVersionNumber() {
        return systemTwoBoardFirmwareVersionNumber;
    }

    public String getSystemTwoBoardSN() {
        return systemTwoBoardSN;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String getCommunicationModuleFirmwareVersion() {
        return communicationModuleFirmwareVersion;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "ShakeHands{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", systemOneBoardFirmwareVersionNumber='" + systemOneBoardFirmwareVersionNumber + '\'' +
                ", bluetoothMAC='" + bluetoothMAC + '\'' +
                ", bluetoothVersionNumber='" + bluetoothVersionNumber + '\'' +
                ", simICCID='" + simICCID + '\'' +
                ", systemTwoBoardFirmwareVersionNumber='" + systemTwoBoardFirmwareVersionNumber + '\'' +
                ", systemTwoBoardSN='" + systemTwoBoardSN + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", communicationModuleFirmwareVersion='" + communicationModuleFirmwareVersion + '\'' +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
