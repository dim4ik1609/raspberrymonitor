package com.raspberrymonitor.service;

import com.raspberrymonitor.dao.TemperatureDao;
import com.raspberrymonitor.enity.Temperature;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

public class TemperatureServiceImpl implements TemperatureService {

    private TemperatureDao temperatureDao;

    public void setTemperatureDao(TemperatureDao temperatureDao) {
        this.temperatureDao = temperatureDao;
    }

    @Transactional
    public List<Temperature> findAll() {
        return this.temperatureDao.findAll();
    }

    @Transactional
    public void create(Temperature temp) {
        this.temperatureDao.create(temp);
    }

    @Transactional
    public Temperature findLast() {
        return this.temperatureDao.findLast();
    }

    @Transactional
    public List<Temperature> findByDate(Date date) {
        return temperatureDao.findByDate(date);
    }
}
