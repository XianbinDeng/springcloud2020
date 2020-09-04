package com.dxb.payment.controller;

import com.dxb.payment.entity.CommResult;
import com.dxb.payment.entity.PaymentModel;
import com.dxb.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommResult createPayment(@RequestBody PaymentModel paymentModel){
        int result=paymentService.createPayment(paymentModel);
        log.info("添加数据成功,result="+result);
        if(result>0){
            return new CommResult(200,serverPort+"添加成功！",result);
        }else{
            return new CommResult(500,serverPort+"添加失败",result);
        }
    }

    @GetMapping(value = "/payment/getzk")
    public String paymentZk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommResult createPayment(@PathVariable Long  id){
        PaymentModel result=paymentService.getPaymentModel(id);
        log.info("查询数据成功,result="+result);
        if(result!=null){
            return new CommResult(200,serverPort+"查询成功",result);
        }else{
            return new CommResult(500,serverPort+"查询失败",result);
        }
    }
}
