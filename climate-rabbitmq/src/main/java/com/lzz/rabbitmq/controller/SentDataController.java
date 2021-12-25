package com.lzz.rabbitmq.controller;



import com.lzz.rabbitmq.entity.SensordataEntity;
import com.lzz.rabbitmq.entity.SensordatatestEntity;
import com.lzz.rabbitmq.service.SentDataService;
import com.lzz.rabbitmq.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentDataController {

    @Autowired
    private SentDataService sentDataService;

    @PostMapping("/sendSensorDataMessage")
    @ApiOperation("传感器数据mq传值")
    @ApiParam(name="sensordataEntity" , value="传感器数据实体类(尽量传完整)")
    public R sendSensorDataMessage(@RequestBody SensordataEntity sensordataEntity){
        sentDataService.sentData(sensordataEntity);
        return R.ok();
    }

    @PostMapping("/sendSensorDataTestMessage")
    @ApiOperation("传感器数据测试mq传值")
    @ApiParam(name="sensordatatestEntity" , value="传感器数据测试实体类(尽量传完整)")
    public R sendSensorDataTestMessage(@RequestBody SensordatatestEntity sensordatatestEntity){
        sentDataService.sentData(sensordatatestEntity);
        return R.ok();
    }
}
