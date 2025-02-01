package com.example.demo.shop;

import com.example.demo.shop.dto.ShopRequest;
import com.example.demo.shop.dto.ShopResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;


    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody ShopRequest request){
        shopService.create(request);
        return null;
    }

    @GetMapping
    ResponseEntity<List<ShopResponse>> getAll() {return ResponseEntity.ok(shopService.getAll());}

    @GetMapping("{id}")
    ResponseEntity<ShopResponse> getById(@PathVariable Long id) {return ResponseEntity.ok(shopService.getById(id));}

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody ShopRequest request, @PathVariable Long id){
        shopService.updateShop(id,request);
        return null;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        shopService.deleteShopById(id);
        return null;
    }

 }
