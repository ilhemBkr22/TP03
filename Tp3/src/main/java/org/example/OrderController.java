package org.example;

public class OrderController {
    private OrderService os;

    public OrderController(OrderService orderService) {
        this.os = orderService;
    }

    public boolean createOrder(Order o) {
        return os.createOrder(o);
    }
}
