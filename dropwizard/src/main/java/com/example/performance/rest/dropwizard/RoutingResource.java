package com.example.performance.rest.dropwizard;


import com.example.performance.rest.domain.Balancer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/route")
@Produces(MediaType.APPLICATION_JSON)
public class RoutingResource {

    private Balancer balancer;

    public RoutingResource(Balancer balancer) {
        this.balancer = balancer;
    }

    @GET
    @Path("{id}")
    public String get(@PathParam("id") String id) {
        return balancer.routeUser(id);
    }

}
