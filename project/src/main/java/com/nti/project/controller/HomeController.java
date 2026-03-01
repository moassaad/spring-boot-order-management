package com.nti.project.controller;

import com.nti.project.dto.OrderRequest;
import com.nti.project.entity.Order;
import com.nti.project.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    public final OrderService orderService;

    @GetMapping("/order")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable String id){

       return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public ResponseEntity<?> newOrder(@RequestBody @Valid OrderRequest orderRequest){
//        orderService.save(orderRequest);
        return new ResponseEntity<>(orderService.save(orderRequest), HttpStatus.OK);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody @Valid OrderRequest orderRequest){
        return orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/order/{id}")
    public Order updateOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }
}
