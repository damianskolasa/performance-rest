package com.example.performance.rest.spring;

import com.example.performance.rest.domain.Balancer;
import com.example.performance.rest.domain.GuavaCacheUserRepository;
import com.example.performance.rest.domain.ListBalancingStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/route/{id}")
public class RouteController {

    Balancer balancer = new Balancer(new GuavaCacheUserRepository(), new ListBalancingStrategy());

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String sayHello(@PathVariable(value="id") String id) {
        return balancer.routeUser(id);
    }

}
