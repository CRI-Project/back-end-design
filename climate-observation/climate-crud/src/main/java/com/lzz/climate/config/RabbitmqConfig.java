package com.lzz.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_climate_data_exchange", true, false);
    }

    @Bean
    public FanoutExchange fanoutExchange2() {
        return new FanoutExchange("fanout_climate_dataTest_exchange", true, false);
    }

    @Bean
    public Queue climateDataFrontendQueue() {
        return new Queue("climate_data_frontend_queue" , true ,false , true);
    }

    @Bean
    public Queue climateDataBackendQueue() {
        return new Queue("climate_data_backend_queue" , true ,false ,true);

    }

    @Bean
    public Queue climateDataFrontendQueue2() {
        return new Queue("climate_dataTest_frontend_queue" ,true ,false ,true);
    }

    @Bean
    public Queue climateDataBackendQueue2() {
        return new Queue("climate_dataTest_backend_queue" ,true,false,true);
    }


    @Bean
    public Binding climateDataFrontendBiding() {
        return BindingBuilder.bind(climateDataFrontendQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding climateDataBackendBinding() {
        return BindingBuilder.bind(climateDataBackendQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding climateDataFrontendBiding2() {
        return BindingBuilder.bind(climateDataFrontendQueue2()).to(fanoutExchange2());
    }

    @Bean
    public Binding climateDataBackendBinding2() {
        return BindingBuilder.bind(climateDataBackendQueue2()).to(fanoutExchange2());
    }


}
