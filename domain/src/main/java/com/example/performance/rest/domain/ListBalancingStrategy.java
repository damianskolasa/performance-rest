package com.example.performance.rest.domain;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ListBalancingStrategy {

    final List<String> seed = new ArrayList<>();
    final AtomicInteger index = new AtomicInteger(0);
    int size = 0;

    public ListBalancingStrategy() {
        prepareSeed();
    }

    private void prepareSeed() {
        for (GroupsConfiguration.Group group : GroupsConfiguration.INSTANCE.getGroups()) {
            IntStream.range(0, group.weight).forEach(t -> seed.add(group.name));
        }
        size = seed.size();
    }

    public String calculateNextFreeGroup() {
        return seed.get(index.getAndSet(index.intValue() % size));
    }
}
