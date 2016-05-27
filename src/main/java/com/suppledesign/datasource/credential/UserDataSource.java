package com.suppledesign.datasource.credential;

import com.suppledesign.model.credential.User;
import com.suppledesign.model.credential.UserBasis;
import com.suppledesign.model.credential.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataSource implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        UserBasis userBasis = userMapper.findByUsername(username);
        List<GrantedAuthority> roles = userMapper.rolesOf(username);
        return new User(userBasis, roles);
    }
}
