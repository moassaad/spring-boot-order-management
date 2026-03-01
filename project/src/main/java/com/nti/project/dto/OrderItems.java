package com.nti.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @NotNull(message = "productId cant be null")
    private  Integer productId;
    @NotNull(message = "quantity cant be null")
    @Positive(message="quantity can be positive")
    private  Integer quantity;

}
