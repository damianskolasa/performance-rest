package com.example.performance.rest.jee;

import com.example.performance.rest.domain.Balancer;
import com.example.performance.rest.domain.GuavaCacheUserRepository;
import com.example.performance.rest.domain.ListBalancingStrategy;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class BalancerProducer {


    @Singleton
    @Produces
    public Balancer produceBalancer() {
        return new Balancer(new GuavaCacheUserRepository(), new ListBalancingStrategy());
    }
}
