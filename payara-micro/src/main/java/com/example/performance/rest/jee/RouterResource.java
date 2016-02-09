package com.example.performance.rest.jee;


import com.example.performance.rest.domain.Balancer;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/route")
@Stateless
public class RouterResource {

    @Inject
    private Balancer balancer;

    @GET
    @Path("/{clientId}")
    @Produces("application/json")
    public String route(@PathParam("clientId") String clientId) {
        return balancer.routeUser(clientId);
    }

}
