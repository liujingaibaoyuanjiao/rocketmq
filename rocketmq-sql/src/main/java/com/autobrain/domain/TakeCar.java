package com.autobrain.domain;

import com.autobrain.utils.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TakeCar {
    private String startByte;// 起始字节
    private String messageID;// 消息标识
    private String messageLength;// 消息长度
    private String serialNumber;// 报文序列号
    private String domainControllerID;// 域控制器ID
    private String commandIdentifier;// 命令标识
    private String serialSize;// 回复流水号
    private String controlResult;// 控制结果
    private String electricity;// 电量
    private String voltage;//电压
    private String enduranceMileage;// 续航里程
    private String totalDistance;// 总里程
    private String carState;//  车状态
    private String timeStamp;// 时间戳
    private String packageNumber;// 包序号
    private String packageAmount;// 包总数
    private String gpsLength;// gps长度
    private List<double[]> lists;
    private String crcCheck;// CRC校验


    public TakeCar(String[] strings) {
        startByte = strings[0];// 起始字节
        messageID = strings[1];// 消息标识
        messageLength = strings[2] + strings[3];// 消息长度
        serialNumber = strings[4] + strings[5];// 报文序列号
        domainControllerID = strings[6] + strings[7] + strings[8] + strings[9] + strings[10] +
                strings[11] + strings[12] + strings[13] + strings[14] + strings[15] + strings[16] + strings[17];// 域控制器ID
        commandIdentifier = strings[18] + strings[19];// 命令标识
        serialSize = strings[20] + strings[21];// 回复流水号
        controlResult = strings[22];// 控制结果
        electricity = strings[23];// 电量
        voltage = strings[24] + strings[25];//电压
        enduranceMileage = strings[26] + strings[27];// 续航里程
        totalDistance = strings[28] + strings[29] + strings[30] + strings[31];// 总里程
        carState = strings[32] + strings[33] + strings[34] + strings[35];// 车状态
        timeStamp = strings[36] + strings[37] + strings[38] + strings[39];// 时间戳
        packageNumber = strings[40];// 包序号
        packageAmount = strings[41];// 包总数
        gpsLength = strings[42] + strings[43] + strings[44] + strings[45];// gps长度
        int gpsAmount = MyUtils.covert(gpsLength) / 16;//gps 数量
        int a = 46; //数组46开始读取
        double locationX1 = 0;
        double locationY1 = 0;
        lists = new ArrayList<>();
        for (int j = 0; j < gpsAmount; j++) { //遍历每一个gps
            String s2 = strings[a] + strings[a + 1] + strings[a + 2] + strings[a + 3] + strings[a + 4] + strings[a + 5] + strings[a + 6] + strings[a + 7];  //获取经度
            String s4 = strings[a + 8] + strings[a + 9] + strings[a + 10] + strings[a + 11] + strings[a + 12] + strings[a + 13] + strings[a + 14] + strings[a + 15]; //获取纬度
            double locationX = MyUtils.getDouble(s2); //转化为高精度
            double locationY = MyUtils.getDouble(s4);
            a = a + 16;
            if (locationX == locationX1 && locationY == locationY1) {
                continue;
            }
            double[] lngLat = {locationX, locationY};
            lists.add(lngLat);
            locationX1 = locationX;
            locationY1 = locationY;
        }
        int i = gpsAmount * 16 + 46;
        crcCheck = strings[i] + strings[i + 1];
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

    public String getSerialSize() {
        return serialSize;
    }

    public String getControlResult() {
        return controlResult;
    }

    public String getElectricity() {
        return MyUtils.covert(electricity)+"";
    }

    public String getVoltage() {
        return MyUtils.covert(voltage)+"";
    }

    public String getEnduranceMileage() {
        return MyUtils.covert(enduranceMileage)+"";
    }

    public String getTotalDistance() {
        return MyUtils.covert(totalDistance)+"";
    }

    public String getCarState() {
        return carState;
    }

    public String getTimeStamp() {
        return MyUtils.getDate(timeStamp)+"";
    }

    public String getPackageNumber() {
        return MyUtils.covert(packageNumber)+"";
    }

    public String getPackageAmount() {
        return MyUtils.covert(packageAmount)+"";
    }

    public String getGpsLength() {
        return MyUtils.covert(gpsLength)+"";
    }

    public List<double[]> getLists() {
        return lists;
    }

    public String getCrcCheck() {
        return crcCheck;
    }

    public static Logger getLog() {
        return log;
    }

    @Override
    public String toString() {
        return "TakeCar{" +
                "startByte='" + startByte + '\'' +
                ", messageID='" + messageID + '\'' +
                ", messageLength='" + messageLength + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", domainControllerID='" + domainControllerID + '\'' +
                ", commandIdentifier='" + commandIdentifier + '\'' +
                ", serialSize='" + serialSize + '\'' +
                ", controlResult='" + controlResult + '\'' +
                ", electricity='" + electricity + '\'' +
                ", voltage='" + voltage + '\'' +
                ", enduranceMileage='" + enduranceMileage + '\'' +
                ", totalDistance='" + totalDistance + '\'' +
                ", carState='" + carState + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", packageNumber='" + packageNumber + '\'' +
                ", packageAmount='" + packageAmount + '\'' +
                ", gpsLength='" + gpsLength + '\'' +
                ", lists=" + lists +
                ", crcCheck='" + crcCheck + '\'' +
                '}';
    }
}
