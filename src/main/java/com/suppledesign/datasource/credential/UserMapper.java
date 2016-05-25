package com.suppledesign.datasource.credential;

import com.suppledesign.model.credential.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);

//    List<GrantedAuthority> listRolesOf(@Param("username") String username);
}
