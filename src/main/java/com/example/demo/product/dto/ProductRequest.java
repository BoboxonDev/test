package com.example.demo.product.dto;

import com.example.demo.shop.dto.ShopResponse;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String name;

    private Long price;

    private String description;

    @NonNull
    private Long shopId;

    private Long shopMicroId;



}
