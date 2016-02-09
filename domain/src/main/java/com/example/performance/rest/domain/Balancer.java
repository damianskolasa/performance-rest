package com.example.performance.rest.domain;

public class Balancer {

    private UserRepository repository;

    private ListBalancingStrategy strategy;

    public Balancer(UserRepository repository, ListBalancingStrategy strategy) {
        this.repository = repository;
        this.strategy = strategy;
    }

    public String routeUser(String clientId) {
        return repository.userGroup(clientId).orElseGet(() -> {
            String calculated = strategy.calculateNextFreeGroup();
            repository.assignUserToGroup(clientId, calculated);
            return calculated;
        });
    }

}
