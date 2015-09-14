package com.ycy.mybatis.test;

import com.ycy.mybatis.dao.impl.UserMappermpl;
import com.ycy.mybatis.module.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
public class MybatisTest2 {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void  before() throws IOException {
    String resource="SqlMapConfig.xml";
        InputStream in =Resources.getResourceAsStream(resource);
        sqlSessionFactory= new  SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void  testGet() throws Exception {
        UserMappermpl userService=new UserMappermpl(sqlSessionFactory);
         User user= userService.getUserById(1);
        System.out.println(user.getUsername());
    }
}
