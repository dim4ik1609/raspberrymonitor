package com.raspberrymonitor.service;

import com.raspberrymonitor.enity.Temperature;

import java.util.Date;
import java.util.List;

public interface TemperatureService {

    public List<Temperature> findAll();
    public void create(Temperature temp);
    public Temperature findLast();
    public List<Temperature> findByDate(Date date);
}
