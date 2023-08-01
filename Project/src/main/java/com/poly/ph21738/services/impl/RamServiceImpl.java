package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Ram;
import com.poly.ph21738.repositories.impl.RamRepository;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class RamServiceImpl implements ICommmomService<Ram, UUID> {
    private RamRepository ramRepository = new RamRepository();

    @Override
    public List<Ram> findAll() {
        return ramRepository.findAll();
    }

    @Override
    public Ram findById(UUID id) {
        return ramRepository.findById(id);
    }

    @Override
    public Boolean add(Ram ram) {
        return ramRepository.add(ram);
    }

    @Override
    public Boolean update(Ram ram) {
        return ramRepository.update(ram);
    }

    @Override
    public Boolean delete(Ram ram) {
        return ramRepository.delete(ram);
    }

    @Override
    public List<Ram> findByName(String keyword) {
        return ramRepository.findByName(keyword);
    }
}
