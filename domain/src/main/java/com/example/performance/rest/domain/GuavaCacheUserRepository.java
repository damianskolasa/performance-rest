package com.example.performance.rest.domain;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class GuavaCacheUserRepository implements UserRepository {

    private Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    @Override
    public void assignUserToGroup(String userId, String group) {
        cache.put(userId, group);
    }

    @Override
    public Optional<String> userGroup(String userId) {
        return Optional.ofNullable(cache.getIfPresent(userId));
    }
}
