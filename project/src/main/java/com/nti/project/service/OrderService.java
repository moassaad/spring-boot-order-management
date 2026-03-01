package com.nti.project.service;

import com.nti.project.dto.OrderRequest;
import com.nti.project.entity.Order;
import com.nti.project.exception.OrderNotFoundException;
import com.nti.project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;
//
//    public OrderService(OrderRepository orderRepository){
//        this.orderRepository = orderRepository;
//    }

    public Order saveAnyOrder(Order order, OrderRequest orderRequest){
        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(orderRequest.getDueDate());

        return orderRepository.save(order);
    }
    public Order save(OrderRequest orderRequest){
        return saveAnyOrder(new Order(), orderRequest);
//        var order = new Order();
//        order.setCustomerId(orderRequest.getCustomerId());
//        order.setProductId(orderRequest.getProductId());
//        order.setQuantity(orderRequest.getQuantity());
//        order.setOrderDate(orderRequest.getDueDate());
//
//        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order updateOrder(String id, OrderRequest orderRequest) {
        Order order = this.getOrderById(id);
        return saveAnyOrder(order, orderRequest);
    }

    public Order deleteOrder(String id) {
        Order order = this.getOrderById(id);
        orderRepository.delete(order);
        return order;
    }

}
