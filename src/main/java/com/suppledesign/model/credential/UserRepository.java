package com.suppledesign.model.credential;

public interface UserRepository {
    User findByUsername(String username);
}
