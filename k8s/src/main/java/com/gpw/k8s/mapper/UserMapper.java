package com.gpw.k8s.mapper;

import com.gpw.k8s.bean.User;

/**
 * @Author:Gpw
 * @Date:2021/3/8
 * @Description:
 */
public interface UserMapper {

    public User findUserByName(String name);

    public void insertUser(User user);
}
