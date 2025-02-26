package com.itheima.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {
    // 设置交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("hmall.fanout2");
    }

    // 设置队列
    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.queue3");
    }
    // 设置绑定方式
    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }
    // 设置队列
    @Bean
    public Queue fanoutQueue4(){
        return new Queue("fanout.queue4");
    }
    // 设置绑定方式
    @Bean
    public Binding fanoutBinding4(Queue fanoutQueue4, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue4).to(fanoutExchange);
    }


}
