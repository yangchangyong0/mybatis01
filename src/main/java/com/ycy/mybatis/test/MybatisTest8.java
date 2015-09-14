package com.ycy.mybatis.test;

import com.ycy.mybatis.dao.OrdersCustomMapper;
import com.ycy.mybatis.module.Orderdetail;
import com.ycy.mybatis.module.Orders;
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
public class MybatisTest8 {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void  before() throws IOException {
        String resource="SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
    }
    //一对一 订单-用户详情
    @Test
    public  void findOrderAndDetail() throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper=     sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders>  ordersList=  ordersCustomMapper.findOrderAndUserLazyLoding();
        System.out.println(11);
        for (Orders ordersCustom : ordersList) {
            System.out.println(ordersCustom.getUser().getUsername());
        }
        sqlSession.close();
    }


}
