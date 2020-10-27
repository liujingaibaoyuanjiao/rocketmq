package com.autobrain.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyUtils {
    //16进制字符串转ASCII
    public static String coverHexToChart(String hex) {
        String[] strings = bytes2HexStringArray(hexStrToBinaryStr(hex));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            Integer integer = Integer.valueOf(string, 16);
            if (integer!=0){
                int a = integer;
                char c = (char) a;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static byte[] hexStrToBinaryStr(String hexString) {

        if ((hexString==null || hexString.equals(" "))) {
            return null;
        }

        if (hexString.contains("0x") && hexString.contains(" ")) {
            hexString = hexString.replaceAll(" ", "");
            hexString = hexString.replaceAll("0x","");
        }else if (hexString.contains("0x") ){
            hexString = hexString.replaceAll("0x","");
        }else if (hexString.contains(" ") ){
            hexString = hexString.replaceAll(" ","");
        }

        int len = hexString.length();
        int index = 0;

        byte[] bytes = new byte[len / 2];

        while (index < len) {

            String sub = hexString.substring(index, index + 2);

            bytes[index/2] = (byte)Integer.parseInt(sub,16);

            index += 2;
        }
        return bytes;
    }




    /**
     * 将字节数组转换成16进制的字符数组
     * @param b
     * @return
     */
    public static String[] bytes2HexStringArray(byte[] b) {
        String[] strArray = null;
        try {
            strArray = new String[b.length];
            String hex;
            for (int i = 0; i < b.length; i++) {
                hex = Integer.toHexString(b[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                hex = hex.toUpperCase();
                strArray[i] = hex;
            }
        } catch (Exception e) {

        }
        return strArray ;
    }


    /**
     * 获取线程池
     */
    public static ThreadPoolExecutor getPool() {
        return new ThreadPoolExecutor(100, 1000, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10000));
    }


    /**
     * 获取设置UUID
     */
    public static String getUUID() {
        long timeMillis = System.currentTimeMillis();
        int randMath = (int) (Math.random() * 1000000);
        return String.valueOf(timeMillis) + randMath;
    }

    /**
     * 获取当前年月日的日期
     */
    public static String getDate() {
        Date date = new Date();
        //格式化时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //返回时间
        return format.format(date);
    }


    //字节数组转字符串数组
    public static String[] bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String[] arrs = new String[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            arrs[i] = hex;
        }
        return arrs;
    }


    //16进制字符串转byte数组
    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    private static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * 字节数组转字16进制字符串数组
     */
    public static String bytesToHex(byte[] bytes) {
        return new BigInteger(1, bytes).toString(16);
    }

    /**
     * 16进制字符串转10进制
     */
    public static Integer covert(String content) {
        return new BigInteger(content, 16).intValue();
    }

    /**
     * 16进制字符串转换成时间
     */
    public static String getDate(String instruct) {
        long l = new BigInteger(instruct, 16).longValue();//把16进制字符串转化为10进制
        Date date1 = new Date(l * 1000);//转化为秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //格式化时间
        return sdf.format(date1);//返回时间
    }

    /**
     * 获取高精度double类型数据
     */
    public static double getDouble(String s) {
        long longBits = Long.valueOf(s, 16);
        return Double.longBitsToDouble(longBits);
    }

    /**
     * 获取float的IEEE754存储格式
     */
    private static String floatToIEEE754(float value) {
        //符号位
        String sflag = value > 0 ? "0" : "1";
        //整数部分
        int fz = (int) Math.floor(value);
        //整数部分二进制
        String fzb = Integer.toBinaryString(fz);
        //小数部分，格式： 0.02
        String valueStr = String.valueOf(value);
        String fxStr = "0" + valueStr.substring(valueStr.indexOf("."));
        float fx = Float.parseFloat(fxStr);
        //小数部分二进制
        String fxb = toBin(fx);

        //指数位
        String e = Integer.toBinaryString(127 + fzb.length() - 1);
        //尾数位
        String m = fzb.substring(1) + fxb;

        StringBuilder result = new StringBuilder(sflag + e + m);

        while (result.length() < 32) {
            result.append("0");
        }
        if (result.length() > 32) {
            result = new StringBuilder(result.substring(0, 32));
        }
        return result.toString();
    }

    private static String toBin(float f) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Float> set = new HashSet<Float>();
        int MAX = 24; // 最多8位

        int bits = 0;
        do {
            f = calc(f, set, list);
            bits++;
        } while (f != -1 && bits < MAX);
        StringBuilder result = new StringBuilder();
        for (Integer i : list) {
            result.append(i);
        }
        return result.toString();
    }

    private static float calc(float f, Set<Float> set, List<Integer> list) {
        if (f == 0 || set.contains(f))
            return -1;
        float t = f * 2;
        if (t >= 1) {
            list.add(1);
            return t - 1;
        } else {
            list.add(0);
            return t;
        }
    }

    /**
     * 将字符串的浮点数转换为IEEE754的四字节16进制数据
     */
    public static String strFloatToStrHex(String str) {
        float floatNum = Float.parseFloat(str); //转换为浮点数
        String erStr = floatToIEEE754(floatNum); //得到二进制的数
        //把2进制字符串erStr，转成10进制keys
        int keys = Integer.parseInt(erStr, 2);//数字2代表进制，可以是各种进制，转换成10进制
        //把10进制keys转成16进制result，toUpperCase()是把小写字母转换成大写字母
        return Integer.toHexString(keys).toUpperCase();
    }

}
