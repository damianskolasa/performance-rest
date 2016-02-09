package com.example.performance.rest.vertx;

import com.example.performance.rest.domain.Balancer;
import io.vertx.ext.web.RoutingContext;

public class BalancerVertxWrapper {

    private Balancer balancer;

    public BalancerVertxWrapper(Balancer balancer) {
        this.balancer = balancer;
    }

    public void route(RoutingContext context) {
        final String userId = context.request().getParam("id");
        String group = balancer.routeUser(userId);

        context.response().setStatusCode(200).end(group);
    }
}
