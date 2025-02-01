package com.example.demo.external;

import com.example.demo.external.dto.SHopEResponse;
import org.springframework.stereotype.Component;

@Component
public class SHopMicroComponent {
    private final ShopMicroService shopMicroService;

    public SHopMicroComponent(ShopMicroService shopMicroService) {
        this.shopMicroService = shopMicroService;
    }

    public SHopEResponse getSHopId(Long shopId) {
        try {
            return shopMicroService.getShop(shopId);
        } catch (Exception e) {
            throw new RuntimeException("micdkcnkjncs");
        }
    }
}
