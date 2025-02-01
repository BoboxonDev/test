package com.example.demo.shop;

import com.example.demo.shop.dto.ShopRequest;
import com.example.demo.shop.dto.ShopResponse;

import java.util.List;

public interface ShopService {

    void create(ShopRequest request);

    List<ShopResponse> getAll();

    ShopResponse getById(Long id);

    void updateShop(ShopRequest id);

    ShopResponse updateShop(Long id, ShopRequest request);

    ShopResponse deleteShopById(Long id);

}


