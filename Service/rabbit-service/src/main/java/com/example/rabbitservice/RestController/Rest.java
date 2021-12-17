package com.example.rabbitservice.RestController;

import com.example.rabbitservice.entity.transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
