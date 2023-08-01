package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Brand;
import com.poly.ph21738.repositories.impl.BrandRepositoryImpl;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class BrandServiceImpl implements ICommmomService<Brand, UUID> {
    private BrandRepositoryImpl brandRepository = new BrandRepositoryImpl();

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(UUID id) {
        return brandRepository.findById(id);
    }

    @Override
    public Boolean add(Brand brand) {
        return brandRepository.add(brand);
    }

    @Override
    public Boolean update(Brand brand) {
        return brandRepository.update(brand);
    }

    @Override
    public Boolean delete(Brand brand) {
        return brandRepository.delete(brand);
    }

    @Override
    public List<Brand> findByName(String keyword) {
        return brandRepository.findByName(keyword);
    }
}
