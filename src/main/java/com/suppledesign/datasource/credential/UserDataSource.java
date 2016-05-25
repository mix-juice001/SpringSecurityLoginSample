package com.suppledesign.datasource.credential;

import com.suppledesign.model.credential.User;
import com.suppledesign.model.credential.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataSource implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
