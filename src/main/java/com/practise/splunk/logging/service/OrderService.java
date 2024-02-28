package com.practise.splunk.logging.service;

import com.practise.splunk.logging.dto.Order;
import com.practise.splunk.logging.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    Logger logger= LogManager.getLogger(OrderService.class);

    private List<Order> orderList = new ArrayList<>();

    public Order addOrder(Order order) {
        logger.info("OrderService:addOrder execution started..");
        logger.info("OrderService:addOrder request payload {} ", Mapper.mapToJsonString(order));
        order.setOrderPlacedDate(new Date());
        order.setTransactionId(UUID.randomUUID().toString());
        this.orderList.add(order);
        logger.info("OrderService:addOrder response  {} ", Mapper.mapToJsonString(order));
        logger.info("OrderService:addOrder execution ended..");
        return order;
    }

    public List<Order> getAllOrders() {
        logger.info("OrderService:getOrders execution started..");
        List<Order> list = null;
        list = this.orderList;
        logger.info("OrderService:getOrders response  {} ", Mapper.mapToJsonString(this.orderList));
        logger.info("OrderService:getOrders execution ended..");
        return list;
    }

    public Order getOrder(int id) {
        logger.info("OrderService:getOrder execution started..");
        Order order = this.orderList.stream()
                .filter(ord -> ord.getId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("Order not found with id : " + id));
        logger.info("OrderService:getOrder execution ended..");
        return order;
    }
}
