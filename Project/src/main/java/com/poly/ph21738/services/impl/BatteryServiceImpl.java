package com.poly.ph21738.services.impl;

import com.poly.ph21738.entities.Battery;
import com.poly.ph21738.repositories.impl.BatteryRepositoryImpl;
import com.poly.ph21738.services.ICommmomService;

import java.util.List;
import java.util.UUID;

public class BatteryServiceImpl implements ICommmomService<Battery, UUID> {
    private BatteryRepositoryImpl batteryRepository = new BatteryRepositoryImpl();

    @Override
    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }

    @Override
    public Battery findById(UUID id) {
        return batteryRepository.findById(id);
    }

    @Override
    public Boolean add(Battery battery) {
        return batteryRepository.add(battery);
    }

    @Override
    public Boolean update(Battery battery) {
        return batteryRepository.update(battery);
    }

    @Override
    public Boolean delete(Battery battery) {
        return batteryRepository.delete(battery);
    }

    @Override
    public List<Battery> findByName(String keyword) {
        return batteryRepository.findByName(keyword);
    }
}
