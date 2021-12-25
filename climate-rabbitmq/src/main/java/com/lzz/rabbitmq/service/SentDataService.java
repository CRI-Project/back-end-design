package com.lzz.rabbitmq.service;



import com.alibaba.fastjson.JSON;
import com.lzz.rabbitmq.entity.SensordataEntity;
import com.lzz.rabbitmq.entity.SensordatatestEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentDataService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sentData(SensordatatestEntity sensordatatestEntity){
        String exchange ="fanout_climate_dataTest_exchange";
        String routingKey = "";
        String jsonString = JSON.toJSONString(sensordatatestEntity);
        rabbitTemplate.convertAndSend(exchange,routingKey,jsonString);
    }

    public void sentData(SensordataEntity sensordataEntity){
        String exchange ="fanout_climate_data_exchange";
        String routingKey = "";
        String jsonString = JSON.toJSONString(sensordataEntity);
        rabbitTemplate.convertAndSend(exchange, routingKey ,jsonString);
    }
}
