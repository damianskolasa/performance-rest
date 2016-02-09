package com.example.performance.rest.vertx;

import com.example.performance.rest.domain.Balancer;
import com.example.performance.rest.domain.GuavaCacheUserRepository;
import com.example.performance.rest.domain.ListBalancingStrategy;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class LoadBalancerVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        BalancerVertxWrapper balancer = new BalancerVertxWrapper(new Balancer(new GuavaCacheUserRepository(), new ListBalancingStrategy()));

        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route().produces("application/json");
        router.get("/route/:id").handler(balancer::route);

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

}