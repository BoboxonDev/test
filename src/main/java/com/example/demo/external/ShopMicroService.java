package com.example.demo.external;

import com.example.demo.external.dto.SHopEResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "shop-service", url = "http://localhost:8084") // URL to'g'ri belgilangan
public interface ShopMicroService {

    @GetMapping("/api/shop")
    SHopEResponse getShop(@RequestParam Long id);
}

