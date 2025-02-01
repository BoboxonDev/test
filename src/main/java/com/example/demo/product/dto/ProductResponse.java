package com.example.demo.product.dto;

import com.example.demo.shop.dto.ShopResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Long price;

    private String description;

    @NotNull
    private Long shopId;

    private ShopResponse shopResponse;
}
