package com.practise.splunk.logging.main;

import com.practise.splunk.logging.dto.Order;
import com.practise.splunk.logging.service.OrderService;
import com.practise.splunk.logging.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.practise.splunk"})
@RequestMapping("/orders")
public class SplunkDemoApplication {

    Logger logger = LogManager.getLogger(SplunkDemoApplication.class);

    @Autowired
    private OrderService service;

    @PostMapping("/addOrder")
    public Order placeOrder(@RequestBody Order order) {
        logger.info("OrderController:placeOrder persist order request {}", Mapper.mapToJsonString(order));
        Order addOrder = this.service.addOrder(order);
        logger.info("OrderController:placeOrder response from service {}", Mapper.mapToJsonString(addOrder));
        return addOrder;
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        List<Order> orders = this.service.getAllOrders();
        logger.info("OrderController:getOrders response from service {}", Mapper.mapToJsonString(orders));
        return orders;
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable int id) {
        logger.info("OrderController:getOrder fetch order by id {}", id);
        Order order = this.service.getOrder(id);
        logger.info("OrderController:getOrder fetch order response {}", Mapper.mapToJsonString(order));
        return order;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplunkDemoApplication.class, args);
    }

}