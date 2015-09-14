package com.ycy.mybatis.test;

import com.ycy.mybatis.module.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/8/28 0028.
 */
public class MybatisFrist {
    private SqlSessionFactory sqlSessionFactory = null;

    //创建工厂
    @Before
    public void before() throws IOException {
        //创建会话工厂
        String resource = "SqlMapConfig.xml";
        InputStream in = null;
        in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);


    }

    @Test
    public void testGet() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        User user = sqlSession.selectOne("test.getUserById", 1);
        System.out.println(user.getUsername());
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        List<User> userList = sqlSession.selectList("test.findUserByName", "小");
        System.out.println(userList.size());
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("杨长用");
        user.setAddress("重庆");
        user.setBirthday(new Date());
        user.setSex("1");
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("--------" + user.getId());
    }

    @Test
    public void testDel() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("test.deleteUser", 27);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("杨长用修改");
        user.setAddress("重庆");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setId(27);
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("--------" + user.getId());
    }
}
