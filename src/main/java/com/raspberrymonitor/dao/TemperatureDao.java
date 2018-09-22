package com.raspberrymonitor.dao;

import com.raspberrymonitor.enity.Temperature;

import java.util.Date;
import java.util.List;

public interface TemperatureDao {

    public void create(Temperature temp);
    public void update(Temperature temp);
    public List<Temperature> findAll();
    public Temperature findById(long id);
    public Temperature findLast();
    public List<Temperature> findByDate(Date date);


}
