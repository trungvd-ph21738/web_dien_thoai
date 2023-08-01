package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Rom;
import com.poly.ph21738.repositories.impl.RomRepository;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class RomServiceImpl implements ICommmomService<Rom, UUID> {
    private RomRepository romRepository = new RomRepository();
    @Override
    public List<Rom> findAll() {
        return romRepository.findAll();
    }

    @Override
    public Rom findById(UUID id) {
        return romRepository.findById(id);
    }

    @Override
    public Boolean add(Rom rom) {
        return romRepository.add(rom);
    }

    @Override
    public Boolean update(Rom rom) {
        return romRepository.update(rom);
    }

    @Override
    public Boolean delete(Rom rom) {
        return romRepository.delete(rom);
    }

    @Override
    public List<Rom> findByName(String keyword) {
        return romRepository.findByName(keyword);
    }
}
