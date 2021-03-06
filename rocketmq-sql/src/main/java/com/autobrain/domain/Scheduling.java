package com.autobrain.domain;

import com.autobrain.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class Scheduling {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String serialSize;// 回复流水号
    private String controlResult;// 控制结果
    private String timeStamp;// 时间戳
    private String packageNumber;// 包序号
    private String packageAmount;// 包总数
    private String gpsLength;// gps长度
    private List<Object[]> lists;
    private String crcCheck;// CRC校验


    public Scheduling(String[] strings) {
        startByte = strings[0];
        messageID = strings[1];
        messageLength = strings[2] + strings[3];
        serialNumber = strings[4] + strings[5];
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];
        commandIdentifier = strings[18] + strings[19];
        serialSize = strings[20] + strings[21];
        controlResult = strings[22];
        timeStamp = strings[23] + strings[24] + strings[25] + strings[26];
        packageNumber = strings[27];
        packageAmount = strings[28];
        gpsLength = strings[29] + strings[30] + strings[31] + strings[32];
//        longitude=strings[33] + strings[34] + strings[35] + strings[36]+strings[37] + strings[38] + strings[39] + strings[40];
//        latitude=strings[41] + strings[42] + strings[43] + strings[44]+strings[45] + strings[46] + strings[47] + strings[48];
        int covert = MyUtils.covert(gpsLength) / 16;//判断一共传输多少个gps
        int a = 33; //数组33开始读取(gps起始位置)
        double locationX1 = 0;//记录经度(用来去掉上一次与下一次经度重复)
        double locationY1 = 0;//记录纬度(用来去掉上一次与下一次纬度重复)
        lists = new ArrayList<>();//声明集合
        for (int j = 0; j < covert; j++) { //遍历每一个gps
            String s2 = strings[a] + strings[a + 1] + strings[a + 2] + strings[a + 3] + strings[a + 4] + strings[a + 5] + strings[a + 6] + strings[a + 7];  //获取经度
            String s4 = strings[a + 8] + strings[a + 9] + strings[a + 10] + strings[a + 11] + strings[a + 12] + strings[a + 13] + strings[a + 14] + strings[a + 15]; //获取纬度
            double locationX = MyUtils.getDouble(s2); //转化为高精度经度
            double locationY = MyUtils.getDouble(s4);//转化为高精度纬度
            a = a + 16;
            if (locationX == locationX1 && locationY == locationY1) {
                continue;//如果和上一次经纬度重复则开始下一次循环
            }
//            Object[] objects = {"约车规划路径", serialNumber, MyUtils.getDate(timeStamp), locationX, locationY, MyUtils.covert(packageNumber), domainControllerID};
            Object[] objects = {"调度规划路径", locationX, locationY};
            lists.add(objects);
            locationX1 = locationX;
            locationY1 = locationY;
        }
//        String msg = storeSqlDao.addPlanGps(lists);
//        log.info("约车规划路径" + "第" + packageNumber + "包" + msg);
        int i = covert * 16 + 33;
        crcCheck = strings[i] + strings[i + 1];
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public String getPackageAmount() {
        return packageAmount;
    }

    public String getGpsLength() {
        return gpsLength;
    }

    public List<Object[]> getLists() {
        return lists;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", serialSize='" + serialSize + '\'' +
                ", controlResult='" + controlResult + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", packageNumber='" + packageNumber + '\'' +
                ", packageAmount='" + packageAmount + '\'' +
                ", gpsLength='" + gpsLength + '\'' +
                ", lists=" + lists +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
