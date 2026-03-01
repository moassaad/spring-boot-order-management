package com.nti.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer  orderId;
    private Integer  customerId;
    private List<OrderItems> items;





}
