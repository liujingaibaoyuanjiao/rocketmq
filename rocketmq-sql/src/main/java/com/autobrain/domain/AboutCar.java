package com.autobrain.domain;

import com.autobrain.utils.MyUtils;
import java.util.ArrayList;
import java.util.List;

public class AboutCar {

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
    private List<double[]> lists;// 约车规划路径
    private String crcCheck;// CRC校验


    public AboutCar(String[] strings) {
        startByte = strings[0]; // 起始字节
        messageID = strings[1]; // 消息标识
        messageLength = strings[2] + strings[3]; // 消息长度
        serialNumber = strings[4] + strings[5]; // 报文序列号
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] + strings[11] +
                strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];  // 域控制器ID
        commandIdentifier = strings[18] + strings[19];// 命令标识
        serialSize = strings[20] + strings[21]; // 回复流水号
        controlResult = strings[22]; // 控制结果
        timeStamp = strings[23] + strings[24] + strings[25] + strings[26];// 时间戳
        packageNumber = strings[27];// 包序号
        packageAmount = strings[28];// 包总数
        gpsLength = strings[29] + strings[30] + strings[31] + strings[32];// gps长度
        int gpsAmount = MyUtils.covert(gpsLength) / 16;//判断一共传输多少个gps
        int a = 33; //数组33开始读取(gps起始位置)
        double locationX1 = 0;//记录经度(用来去掉上一次与下一次经度重复)
        double locationY1 = 0;//记录纬度(用来去掉上一次与下一次纬度重复)
        lists = new ArrayList<>();//声明集合
        for (int j = 0; j < gpsAmount; j++) { //遍历每一个gps
            String s2 = strings[a] + strings[a + 1] + strings[a + 2] + strings[a + 3] + strings[a + 4] + strings[a + 5] + strings[a + 6] + strings[a + 7];  //获取经度
            String s4 = strings[a + 8] + strings[a + 9] + strings[a + 10] + strings[a + 11] + strings[a + 12] + strings[a + 13] + strings[a + 14] + strings[a + 15]; //获取纬度
            double locationX = MyUtils.getDouble(s2); //转化为高精度经度
            double locationY = MyUtils.getDouble(s4);//转化为高精度纬度
            a = a + 16;//下一个gps
            if (locationX == locationX1 && locationY == locationY1) {
                continue;//如果和上一次经纬度重复则开始下一次循环
            }
            double[] lngLat = {locationX, locationY};
            lists.add(lngLat);
            locationX1 = locationX;
            locationY1 = locationY;
        }
        int i = gpsAmount * 16 + 33;
        crcCheck = strings[i] + strings[i + 1];// CRC校验
    }

    public String getStartByte() {
        return startByte;
    }// 起始字节

    public String getMessageID() {
        return messageID;
    }// 消息标识

    public String getMessageLength() {
        return  MyUtils.covert(messageLength)+"";
    }// 消息长度

    public String getSerialNumber() {
        return serialNumber;
    }// 报文序列号

    public String getDomainControllerID() {
        return MyUtils.coverHexToChart(domainControllerID);
    }// 域控制器ID

    public String getCommandIdentifier() {
        return commandIdentifier;
    }// 命令标识

    public String getSerialSize() {
        return serialSize;
    }// 回复流水号

    public String getControlResult() {
        return controlResult;
    }// 控制结果

    public String getTimeStamp() {
        return MyUtils.getDate(timeStamp) + "";
    }// 时间戳

    public String getPackageNumber() {
        return MyUtils.covert(packageNumber)+"";
    }// 包序号

    public String getPackageAmount() {
        return MyUtils.covert(packageAmount)+"";
    }// 包总数

    public String getGpsLength() {
        return MyUtils.covert(gpsLength)+"";
    }// gps长度

    public List<double[]> getLists() {
        return lists;
    }// 约车规划路径

    public String getCrcCheck() {
        return crcCheck;
    }// CRC校验

    @Override
    public String toString() {
        return "AboutCar{" +
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
