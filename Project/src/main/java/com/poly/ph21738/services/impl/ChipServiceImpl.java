package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Chip;
import com.poly.ph21738.repositories.impl.ChipRepositoryImpl;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class ChipServiceImpl implements ICommmomService<Chip, UUID> {
    private ChipRepositoryImpl chipRepository = new ChipRepositoryImpl();

    @Override
    public List<Chip> findAll() {
        return chipRepository.findAll();
    }

    @Override
    public Chip findById(UUID id) {
        return chipRepository.findById(id);
    }

    @Override
    public Boolean add(Chip chip) {
        return chipRepository.add(chip);
    }

    @Override
    public Boolean update(Chip chip) {
        return chipRepository.update(chip);
    }

    @Override
    public Boolean delete(Chip chip) {
        return chipRepository.delete(chip);
    }

    @Override
    public List<Chip> findByName(String keyword) {
        return chipRepository.findByName(keyword);
    }
}