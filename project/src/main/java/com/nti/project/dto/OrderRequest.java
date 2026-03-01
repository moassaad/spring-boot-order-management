package com.nti.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
//    @NotNull(message = "orderId cant be null")
//    private Integer  orderId;

    @NotNull(message = "customerId cant be null")
    private Long  customerId;

    @NotNull(message = "productId cant be null")
    private Long  productId;

    @NotNull(message = "quantity cant be null")
    private Integer  quantity;

    @NotNull(message = "dueDate cant be null")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDate dueDate;

//    @NotNull(message = "items cant be null")
//    @NotEmpty(message= "items cant be empty")
//    @Size(min=1, max=3,message = "must be between 1 and 3")
//    private List<@Valid OrderItems> items;

}

