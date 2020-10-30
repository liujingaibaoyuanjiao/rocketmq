package com.autobrain.utils;


import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private String msg;

    ClientHandler(String msg) {
        this.msg = msg;
    }

    //通道就绪事件
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("我是客户端" + ctx.channel().localAddress());
        if (msg.contains("约车")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String instruct = jsonObject.get("instruct") + "01-" + jsonObject.get("upLon") + "," + jsonObject.get("upLat") + "-" + jsonObject.get("downLon") + "," + jsonObject.get("downLat") + "-" + jsonObject.get("parkLon") + "," + jsonObject.get("parkLat");
            String domainController = jsonObject.get("domainController") + "";
            boolean flag = sendNetty(null, instruct, domainController, "code", ctx);
            if (flag) {
                log.info("Netty成功");
            }
            log.info(instruct + "==============" + domainController);
        } else if (msg.contains("取车") || msg.contains("用车") || msg.contains("还车") || msg.contains("泊车")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String instruct = jsonObject.get("instruct") + "";
            String domainController = jsonObject.get("domainController") + "";
            boolean flag = sendNetty(null, instruct, domainController, "code", ctx);
            if (flag) {
                log.info("Netty成功");
            }
            log.info(instruct + "==============" + domainController);
        }else if (msg.contains("更换上车点")){
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String instruct = "约车"+ "02-" + jsonObject.get("upLon") + "," + jsonObject.get("upLat") + "-" + jsonObject.get("downLon") + "," + jsonObject.get("downLat") + "-" + jsonObject.get("parkLon") + "," + jsonObject.get("parkLat");
            String domainController = jsonObject.get("domainController") + "";
            boolean flag = sendNetty(null, instruct, domainController, "code", ctx);
            if (flag) {
                log.info("Netty成功");
            }
            log.info(instruct + "==============" + domainController);
        }else if (msg.contains("更换下车点")){
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String instruct = "约车"+ "03-" + jsonObject.get("upLon") + "," + jsonObject.get("upLat") + "-" + jsonObject.get("downLon") + "," + jsonObject.get("downLat") + "-" + jsonObject.get("parkLon") + "," + jsonObject.get("parkLat");
            String domainController = jsonObject.get("domainController") + "";
            boolean flag = sendNetty(null, instruct, domainController, "code", ctx);
            if (flag) {
                log.info("Netty成功");
            }
            log.info(instruct + "==============" + domainController);
        }else if(msg.contains("路由")){
            JSONObject jsonObject = JSONObject.parseObject(msg);
            String instruct = "约车"+ "04-" + jsonObject.get("upLon") + "," + jsonObject.get("upLat") + "-" + jsonObject.get("downLon") + "," + jsonObject.get("downLat") + "-" + jsonObject.get("parkLon") + "," + jsonObject.get("parkLat");
            String domainController = jsonObject.get("domainController") + "";
            boolean flag = sendNetty(null, instruct, domainController, "code", ctx);
            if (flag) {
                log.info("Netty成功");
            }
            log.info(instruct + "==============" + domainController);
        }
        ctx.close();
    }

    /**
     * 向Netty发送【APP操作指令】【OTA文件数据包】
     *
     * @param packageList OTA文件数据包集合
     * @param codeStr     APP操作指令：【约车-上车点-下车点-泊车点/下一个目的点】【取/用/还/泊车】【调度-上车点-下车点】【OTA升级-版本号】
     * @param tag         标签
     * @param yuKongID    域控制器ID
     * @param ctx         上下文对象
     * @return 发送成功与否
     * 备注：
     * 如果只是发送【指令】，【packageList】填写【null】
     * 如果只是发送【OTA数据包】，【codeStr】填写【null】
     */
    public static boolean sendNetty(List<String> packageList, String codeStr, String yuKongID, String tag, ChannelHandlerContext ctx) {
        if (yuKongID == null || yuKongID.equals("")) {
            throw new NullPointerException("域控制器为空!");
        }
        MyDataInfo.MyMessage myMessage = null;
        boolean flag = false;
        if (tag.equals("code")) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CodeDataType)
                    .setCodeData(MyDataInfo.CodeData.newBuilder()
                            .setYuKongID(yuKongID)
                            .setData(codeStr).build()).build();
        } else if (tag.equals("package")) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.FileDataType)
                    .setFileData(MyDataInfo.FileData.newBuilder()
                            .setYuKongID(yuKongID)
                            .addAllPackageData(packageList).build()).build();
        }
        ChannelFuture channelFuture = ctx.channel().writeAndFlush(myMessage);
        if (channelFuture != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * mq通过Netty客户端发送数据
     *
     * @param data 要发送的String数据
     * @return 字节数组
     */
    public static byte[] mqToNetty(String data) {
        data = "0F00" + ConvertCode.bytes2HexString(data.getBytes()); //加入命令标识标识
        String str1Len = Integer.toHexString(data.length() / 2);  //消息体的长度
        //判断长度的长度（长度多少位）
        if (str1Len.length() == 1) {
            str1Len = "000" + str1Len;
        } else {
            str1Len = "00" + str1Len;
        }
        data = "5B10" + str1Len + "" + data; //组合命令
        byte[] bytes = ConvertCode.hexStrToBinaryStr(data); //获取字节数据
        return bytes;
    }

}