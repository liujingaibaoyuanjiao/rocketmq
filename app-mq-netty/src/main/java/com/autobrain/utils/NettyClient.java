package com.autobrain.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClient implements Runnable {

    private String s1;

    public NettyClient(String s1) {
        this.s1 = s1;
    }

    @Override
    public void run() {
        //1. 创建一个线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //2. 创建客户端的启动助手，完成相关配置
        Bootstrap b = new Bootstrap();
        try{
            //3. 设置线程组
            b.group(group)
                    .channel(NioSocketChannel.class)  //4. 设置客户端通道的实现类
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,10000)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new ProtobufVarint32FrameDecoder());
                            pipeline.addLast(new ProtobufDecoder(MyDataInfo.MyMessage.getDefaultInstance()));
                            pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                            pipeline.addLast(new ProtobufEncoder());
                            pipeline.addLast(new ClientHandler(s1));
                        }
                    });
            //7.启动客户端去连接服务器端  connect方法是异步的   sync方法是同步阻塞的
//            ChannelFuture cf = b.connect("139.217.56.46", 18081).sync();
            ChannelFuture cf = b.connect("172.16.1.9", 18081).sync ();
            log.info("连接服务器成功");
            //8.关闭通道
            cf.channel().closeFuture().sync();
        }catch (InterruptedException e){
            log.info("netty异常了");
            e.printStackTrace();
        }finally {
            log.info("关闭客户端线程组");
            group.shutdownGracefully();
        }
    }
}
