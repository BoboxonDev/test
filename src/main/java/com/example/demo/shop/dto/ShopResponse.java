package com.example.demo.shop.dto;

import com.example.demo.product.dto.ProductResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopResponse {

    private Long id;

    private String name;

    private String location;

    private String phoneNumber;

    private List<ProductResponse> products;

}
