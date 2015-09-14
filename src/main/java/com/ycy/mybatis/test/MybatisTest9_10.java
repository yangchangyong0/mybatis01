package com.ycy.mybatis.test;

import com.ycy.mybatis.dao.OrdersCustomMapper;
import com.ycy.mybatis.dao.UserMapper;
import com.ycy.mybatis.dao.impl.UserMappermpl;
import com.ycy.mybatis.module.Orders;
import com.ycy.mybatis.module.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
public class MybatisTest9_10 {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void  before() throws IOException {
        String resource="SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
    }
    //一级缓存测试
    @Test
    public  void findOrderAndDetail() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //第一次查询
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user= userMapper.getUserById(1);
        System.out.println(user.getUsername());
        //第二次查询（没有关闭sqlsession）
        User user2= userMapper.getUserById(1);
        System.out.println(user2.getUsername());
    }
    //二级缓存测试
    @Test
    public  void cache2() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        SqlSession sqlSession2=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2=sqlSession2.getMapper(UserMapper.class);

        //第一次查询
        User user= userMapper.getUserById(1);
        System.out.println(user.getUsername());
        sqlSession.close();

        //第二次查询（）
        User user2= userMapper2.getUserById(1);
        System.out.println(user2.getUsername());


        sqlSession2.close();
    }

}
