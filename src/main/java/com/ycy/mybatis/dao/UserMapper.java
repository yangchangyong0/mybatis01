package com.ycy.mybatis.dao;

import com.ycy.mybatis.module.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
public interface UserMapper {
    public User getUserById(int id) throws Exception;

    public List<User> findUserByName(@Param("username") String username) throws Exception;

    public void  insertUser(User user) throws  Exception;

    public void deleteUser(int id)throws  Exception;

    public  void updateUser(User use) throws  Exception;

    public List<User>  findUserResultMap(User user)throws Exception;
}
