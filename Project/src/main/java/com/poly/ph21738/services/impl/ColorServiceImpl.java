package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Color;
import com.poly.ph21738.repositories.impl.ColorRepository;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class ColorServiceImpl implements ICommmomService<Color, UUID> {
    private ColorRepository colorRepository = new ColorRepository();

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color findById(UUID id) {
        return colorRepository.findById(id);
    }

    @Override
    public Boolean add(Color color) {
        return colorRepository.add(color);
    }

    @Override
    public Boolean update(Color color) {
        return colorRepository.update(color);
    }

    @Override
    public Boolean delete(Color color) {
        return colorRepository.delete(color);
    }

    @Override
    public List<Color> findByName(String keyword) {
        return colorRepository.findByName(keyword);
    }
}