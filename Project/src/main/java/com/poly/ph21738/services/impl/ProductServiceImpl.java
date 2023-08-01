package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Product;
import com.poly.ph21738.repositories.impl.ProductRepository;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ICommmomService<Product, UUID> {
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public Boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Boolean delete(Product product) {
        return productRepository.delete(product);
    }

    @Override
    public List<Product> findByName(String keyword) {
        return productRepository.findByName(keyword);
    }
}
