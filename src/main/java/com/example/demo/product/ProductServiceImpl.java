package com.example.demo.product;

import com.example.demo.external.SHopMicroComponent;
import com.example.demo.product.dto.ProductRequest;
import com.example.demo.product.dto.ProductResponse;
import com.example.demo.shop.ShopRepository;
import com.example.demo.shop.dto.ShopResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;

    private final SHopMicroComponent sHopMicroComponent;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SHopMicroComponent sHopMicroComponent) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.sHopMicroComponent = sHopMicroComponent;
    }

    @Override
    public void create(ProductRequest request) {

        var entity = new ProductEntity();
        if (request.getShopMicroId() != null) {
            var microSHop = sHopMicroComponent.getSHopId(request.getShopMicroId());

            entity.setMicroShopId(microSHop.getId());
        }
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());


        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());

        productRepository.save(entity);

    }

    @Override
    public List<ProductResponse> getAll() {
        var products = productRepository.findAllByDeleteAtIsNull();
        List<ProductResponse> list = new ArrayList<>();

        products.forEach(product -> {
            var dto = new ProductResponse();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setDescription(product.getDescription());

            if (product.getShop() != null) {

                dto.setShopId(product.getShop().getId());
                var d = new ShopResponse();
                d.setId(product.getShop().getId());
                d.setName(product.getShop().getName());
                d.setLocation(product.getShop().getLocation());
                d.setPhoneNumber(product.getShop().getPhoneNumber());

                dto.setShopResponse(d);
            }

            list.add(dto);
        });
        return list;
    }

    @Override
    public ProductResponse getById(Long id) {
        var entity = productRepository.findById(id).orElseThrow();
        var dto = new ProductResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    @Override
    public void updateProduct(ProductRequest id) {

    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        var entity = new ProductEntity();
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());

        var updateEntity = productRepository.save(entity);

        var dto = new ProductResponse();
        dto.setId(updateEntity.getId());
        dto.setName(updateEntity.getName());
        dto.setPrice(updateEntity.getPrice());
        dto.setDescription(updateEntity.getDescription());

        return dto;
    }

    @Override
    public ProductResponse deleteProductById(Long id) {
        var entity = productRepository.findById(id).orElseThrow();
        entity.setDeleteAt(LocalDateTime.now());

        var dto = new ProductResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());

        productRepository.save(entity);
        return dto;
    }

    public ShopRepository getShopRepository() {
        return shopRepository;
    }
}
