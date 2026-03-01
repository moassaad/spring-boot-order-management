package com.nti.project.service;

import com.nti.project.dto.OrderRequest;
import com.nti.project.entity.Order;
import com.nti.project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;
//
//    public OrderService(OrderRepository orderRepository){
//        this.orderRepository = orderRepository;
//    }

    public void save(OrderRequest orderRequest){
        var order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(orderRequest.getDueDate());

        orderRepository.save(order);
    }
}
