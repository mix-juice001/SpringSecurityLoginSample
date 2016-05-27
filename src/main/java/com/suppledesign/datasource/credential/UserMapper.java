package com.suppledesign.datasource.credential;

import com.suppledesign.model.credential.UserBasis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Mapper
public interface UserMapper {

    UserBasis findByUsername(@Param("username") String username);

    List<GrantedAuthority> rolesOf(@Param("username") String username);
}
