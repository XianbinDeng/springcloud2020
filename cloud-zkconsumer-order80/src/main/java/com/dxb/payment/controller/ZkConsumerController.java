package com.dxb.payment.controller;

import com.dxb.payment.entity.CommResult;
import com.dxb.payment.entity.PaymentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ZkConsumerController {
    public static final String INVOKE_URL="HTTP://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping(value = "/consumer/payment/create")
    public CommResult createPayment(PaymentModel paymentModel){
        return restTemplate.postForObject(INVOKE_URL+"/payment/create",paymentModel,CommResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommResult createPayment(@PathVariable Long  id){
        return restTemplate.getForObject(INVOKE_URL+"/payment/get/"+id,CommResult.class);
    }
    @GetMapping(value = "/consumer/discovery")
    public Object createPayment(){
        List<Map<String, List<ServiceInstance>>> serviceList=new ArrayList<Map<String,List<ServiceInstance>>>();
        List<String> serivces= discoveryClient.getServices();
        for (String str:serivces
        ) {
            Map<String,List<ServiceInstance>> map=new HashMap<String,List<ServiceInstance>>();
            List<ServiceInstance> instances=discoveryClient.getInstances(str);
            for (ServiceInstance instance:instances
            ) {
                map.put(str,instances);
                serviceList.add(map);
            }
        }
        return serviceList;
    }

}
