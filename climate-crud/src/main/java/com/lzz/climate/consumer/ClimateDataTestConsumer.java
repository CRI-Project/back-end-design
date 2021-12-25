package com.lzz.climate.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzz.climate.entity.SensordataEntity;
import com.lzz.climate.entity.SensordatatestEntity;
import com.lzz.climate.service.SensordatatestService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service

public class ClimateDataTestConsumer {

    @Autowired
    private SensordatatestService sensordatatestService;

    @RabbitHandler
    @RabbitListener(queues={"climate_dataTest_backend_queue"})
    public void receiveMessages(Message message , Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("后端接收到SensordataTest类型的消息 ---> " + msg);
        boolean ack = true;
        Exception exception = null;
        try {
            if (msg.contains("deadletter")){
                throw new RuntimeException("dead letter exception");
            }
        }catch (Exception e){
            ack =false;
            exception = e;
        }
        if (!ack){
            log.error("消息消费发生异常，error msg:{}", exception.getMessage() ,exception);
        }else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag() , false);
        }

        JSON json = JSON.parseObject(msg);
        SensordatatestEntity jsonObject = JSONObject.toJavaObject(json , SensordatatestEntity.class);
        sensordatatestService.save(jsonObject);
    }
}
