package com.think123.consumer.controller;

import com.think123.consumer.client.UserClient;
import com.think123.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController {
/*

    @Autowired
    private RestTemplate restTemplate;
*/

  //  @Autowired
   // private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Integer id){
        User user = userClient.queryById(id);
        return user;
    }

   // @GetMapping("{id}")
   // @HystrixCommand(fallbackMethod = "queryByIdFallBack")//失败容错的指令:开启线程隔离和降级处理
    //保证返回结果一致
   /*
   配置超时时长
    @HystrixCommand(commandProperties =
            {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            })*/
  /*  @HystrixCommand(commandProperties =
            {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
            })
    public String queryById(@PathVariable("id") Integer id){
        if(id % 2 == 0){
            throw  new  RuntimeException("失败!");
        }
        String url="http://user-service/user/"+id;
        String user=restTemplate.getForObject(url, String.class);
        return user;
    }*/
    /*public String queryByIdFallBack( Integer id){
        return "不好意思,服务器太拥挤了!";
    }
    public String queryByIdFallBack(){
        return "不好意思,服务器太拥挤了!";
    }
*/

  //  @Autowired
   // private RibbonLoadBalancerClient client;

  /*  @GetMapping("{id}")
    public User queryById(@PathVariable("id") Integer id){
        //根据服务id获取实例
       // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例中,取出ip和端口
        //ServiceInstance instance = instances.get(0);

        //ServiceInstance instance1 = client.choose("user-service");

      //  String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        String url="http://user-service/user/"+id;
        User user=restTemplate.getForObject(url, User.class);
        return user;
    }*/
}