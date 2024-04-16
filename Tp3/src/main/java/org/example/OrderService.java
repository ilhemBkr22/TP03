package org.example;

public class OrderService {
    private OrderDao od;

    public OrderService(OrderDao orderDao) {
        this.od = orderDao;
    }
    public boolean createOrder(Order order) {
       return od.saveOrder(order);
    }

}
