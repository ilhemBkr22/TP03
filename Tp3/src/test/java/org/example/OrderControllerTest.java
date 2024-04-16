package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class OrderControllerTest {

    @Test
    public void testCreateOrder_Success() {
        OrderService orderServiceMock = mock(OrderService.class);
       Order order = new Order(1,"ilhem",12);
        when(orderServiceMock.createOrder(order)).thenReturn(true);
       OrderController orderController = new OrderController(orderServiceMock);
          boolean result = orderController.createOrder(order);
              verify(orderServiceMock).createOrder(order);
       assertTrue(result);
    }



    @Test
    public void testCreateOrder_Failure() {
        OrderService orderServiceMock = mock(OrderService.class);
        Order order = new Order(1,"ilhem",895);
       when(orderServiceMock.createOrder(order)).thenReturn(false);
       OrderController orderController = new OrderController(orderServiceMock);
       boolean result = orderController.createOrder(order);
       verify(orderServiceMock).createOrder(order);
       assertFalse(result);
    }
    @Test
    public void testCreateOrder_FailureWithOrderDao() {
           OrderDao orderDaoMock = mock(OrderDao.class);
           OrderService orderService = new OrderService(orderDaoMock);
     Order order = new Order(1,"ilhem",85);
    when(orderDaoMock.saveOrder(order)).thenReturn(false);

           boolean result = orderService.createOrder(order);
      verify(orderDaoMock).saveOrder(order);
    assertFalse(result);
    }


}
