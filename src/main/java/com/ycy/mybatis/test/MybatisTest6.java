package com.ycy.mybatis.test;

import com.ycy.mybatis.dao.OrdersCustomMapper;
import com.ycy.mybatis.dao.UserMapper;
import com.ycy.mybatis.module.Orders;
import com.ycy.mybatis.module.OrdersCustom;
import com.ycy.mybatis.module.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
public class MybatisTest6 {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void  before() throws IOException {
        String resource="SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public  void findOrderCustomer() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper=     sqlSession.getMapper(OrdersCustomMapper.class);
        List<OrdersCustom>  ordersCustoms=  ordersCustomMapper.findOrderCustomer();
        sqlSession.close();
        for (OrdersCustom ordersCustom : ordersCustoms) {
            System.out.println(ordersCustom.getUsername());
        }

    }
    @Test
    public  void findOrderResultMap() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper=     sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders>  ordersList=  ordersCustomMapper.findOrderResultMap();
        sqlSession.close();
        for (Orders ordersCustom : ordersList) {
            System.out.println(ordersCustom.getUser().getUsername());
        }

    }


}
