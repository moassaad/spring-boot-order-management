package com.nti.project.controller;

import com.nti.project.dto.OrderItems;
import com.nti.project.dto.OrderRequest;
import com.nti.project.dto.OrderResponse;
import com.nti.project.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    public final OrderService orderService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello,NTI";
    }



    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello \t" +name;
    }
    @GetMapping("/order")
    public List<OrderResponse> newOrder(){
        List<OrderResponse> listOrders = new ArrayList<>();
        OrderResponse order = new OrderResponse();
        List<OrderItems> items = new ArrayList<>();

        items.add(new OrderItems(1,10));
        items.add(new OrderItems(5,2));
        items.add(new OrderItems(4,1));
        items.add(new OrderItems(8,4));

        order.setOrderId(1);
        order.setCustomerId(1);
        order.setItems(items);

        for(int i =0; i<11;i++){
            listOrders.add(order) ;
        }
        return listOrders;
    }
//    @PostMapping("/orders")
//public OrderRequest  newOrder(@RequestBody OrderRequest orderRequest){
//        return orderRequest;
//
//    }
    @PostMapping("/orders")
    public ResponseEntity<?> newOrder(@RequestBody @Valid OrderRequest orderRequest){
        orderService.save(orderRequest);
        return new ResponseEntity<>(orderRequest, HttpStatus.OK);
    }
}
