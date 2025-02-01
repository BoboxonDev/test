package com.example.demo.shop;

import com.example.demo.product.ProductRepository;
import com.example.demo.product.dto.ProductResponse;
import com.example.demo.shop.dto.ShopRequest;
import com.example.demo.shop.dto.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ShopServiceImpl implements ShopService{


    private final ShopRepository shopRepository;

    private final ProductRepository productRepository;

    public ShopServiceImpl(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void create(ShopRequest request) {
        var entity = new ShopEntity();
        entity.setName(request.getName());
        entity.setLocation(request.getLocation());
        entity.setPhoneNumber(request.getPhoneNumber());

        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());

        shopRepository.save(entity);
    }

    @Override
    public List<ShopResponse> getAll() {
        var shops = shopRepository.findAllByDeleteAtIsNull();
        List<ShopResponse> list = new ArrayList<>();

        shops.forEach(shop -> {
            var dto = new ShopResponse();
            dto.setId(shop.getId());
            dto.setName(shop.getName());

            dto.setPhoneNumber(shop.getPhoneNumber());


            var products = productRepository.findAllByShopIdIn(shop.getId());
            if (products!=null){

            List<ProductResponse> plist = new ArrayList<>();

            products.forEach(product -> {
                var p = new ProductResponse();
                p.setId(product.getId());
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());

                plist.add(p);
            });
                dto.setProducts(plist);
            }

            list.add(dto);
        });
        return list;
    }

    @Override
    public ShopResponse getById(Long id) {
        var entity = shopRepository.findById(id).orElseThrow();
        var dto = new ShopResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }

    @Override
    public void updateShop(ShopRequest id) {
    }

    @Override
    public ShopResponse updateShop(Long id, ShopRequest request) {
        var entity = new ShopEntity();
        entity.setName(request.getName());
        entity.setLocation(request.getLocation());
        entity.setPhoneNumber(request.getPhoneNumber());

        var updateEntity = shopRepository.save(entity);
        var dto = new ShopResponse();
        dto.setId(updateEntity.getId());
        dto.setName(updateEntity.getName());
        dto.setLocation(updateEntity.getLocation());
        dto.setPhoneNumber(updateEntity.getPhoneNumber());

        return dto;
    }

    @Override
    public ShopResponse deleteShopById(Long id) {
        var entity = shopRepository.findById(id).orElseThrow();
        entity.setDeleteAt(LocalDateTime.now());

        var dto = new ShopResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setPhoneNumber(entity.getPhoneNumber());

        shopRepository.save(entity);

        return dto;
    }
}
