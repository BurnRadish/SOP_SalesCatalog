package com.example.rabbitmq_service.RestController;

import com.example.rabbitmq_service.entity.transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public ResponseEntity<?> OrderFinish(@RequestBody transaction result){
        rabbitTemplate.convertAndSend("ProductTransaction","Order",result);
        return ResponseEntity.ok(result); //result.getAddress(), result.getResultprice(), result.getEmail()); //result.getTran()+" "+ result.getAddress() +" "+result.getEmail()+" "+result.getResultprice();
    }
}
