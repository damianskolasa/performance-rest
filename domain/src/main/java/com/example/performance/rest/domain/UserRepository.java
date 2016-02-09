package com.example.performance.rest.domain;

import java.util.Optional;

public interface UserRepository {

    void assignUserToGroup(String userId, String group);

    Optional<String> userGroup(String userId);

}
