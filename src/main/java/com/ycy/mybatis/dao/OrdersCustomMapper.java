package com.ycy.mybatis.dao;

import com.ycy.mybatis.module.Orders;
import com.ycy.mybatis.module.OrdersCustom;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
public interface OrdersCustomMapper {
   //一对一ResultType
   public List<OrdersCustom> findOrderCustomer() throws  Exception;
   //一对一ResultMap
   public  List<Orders> findOrderResultMap() throws  Exception;
   //一对多
   public  List<Orders> findOrderAndDetail() throws  Exception;

   //一对一延迟加载
   public List<Orders> findOrderAndUserLazyLoding() throws  Exception;

}
