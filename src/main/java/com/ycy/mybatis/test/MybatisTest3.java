package com.ycy.mybatis.test;

import com.ycy.mybatis.dao.UserMapper;
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
public class MybatisTest3 {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void  before() throws IOException {
        String resource="SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public  void testGet() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userService=  sqlSession.getMapper(UserMapper.class);
        User user=  userService.getUserById(1);
        sqlSession.close();
        System.out.println(user.getUsername());
    }
    @Test
    public  void testFindByname() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=  sqlSession.getMapper(UserMapper.class);
        List<User> userList=  userMapper.findUserByName("陈小明");
        sqlSession.close();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
    }

    /**
     * 查询用户使用ResultMap
     * @throws Exception
     */
    @Test
    public  void findUserResultMap() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=  sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("小明");
        user.setSex("1");
        List<User> userList=  userMapper.findUserResultMap(user);
        sqlSession.close();
        for (User user1 : userList) {
            System.out.println(user1.getUsername());
        }
    }

}
