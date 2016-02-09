package com.example.performance.rest.dropwizard;

import com.example.performance.rest.domain.Balancer;
import com.example.performance.rest.domain.GuavaCacheUserRepository;
import com.example.performance.rest.domain.ListBalancingStrategy;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RoutingApplication extends Application<RoutingConfiguration> {

    @Override
    public String getName() {
        return "routing";
    }

    @Override
    public void run(RoutingConfiguration configuration,
                    Environment environment) {
        final RoutingResource resource = new RoutingResource(new Balancer(new GuavaCacheUserRepository(), new ListBalancingStrategy()));

        environment.jersey().register(resource);
    }

}
