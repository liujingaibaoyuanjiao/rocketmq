package com.autobrain.consumer;


import com.autobrain.utils.NettyClient;
import com.autobrain.utils.ThreadPool;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@SuppressWarnings("all")
@Component
@Slf4j
public class AppMqNetty {

    private static ThreadPoolExecutor pool = ThreadPool.getPool();

    @SneakyThrows
    @PostConstruct
    public void start() {
        //获取消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ROBOTaxi-netty");
        //指定namesrv地址
//        String ip = "172.16.1.7:9876;172.16.1.8:9876";
        String ip = "192.168.1.9:9876";
//        String ip = "139.217.56.46:9876";
        consumer.setNamesrvAddr(ip);
        consumer.setVipChannelEnabled(false);
        //指定拉取的消息
        consumer.subscribe("instruct", "app");
        //设置消费位置
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //设置集群得消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //注册回调函数,监听是否有消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : msgs) {
                    //获取消息
                    String s1 = new String(msg.getBody());
                    log.info("消费:" + s1);
                    NettyClient client = new NettyClient(s1);
                    pool.execute(client);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        log.info("消费者启动成功");
    }
}
