package com.raspberrymonitor.scheduling;

import com.raspberrymonitor.enity.Temperature;
import com.raspberrymonitor.service.TemperatureService;
import com.raspberrymonitor.util.RaspberryUtilService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TemperatureTask {

    private Logger logger = Logger.getLogger(TemperatureTask.class);
    public TemperatureService temperatureService;
    private RaspberryUtilService raspberryUtilService;

    public void setRaspberryUtilService(RaspberryUtilService raspberryUtilService) {
        this.raspberryUtilService = raspberryUtilService;
    }

    public void setTemperatureService(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    public void saveTemperature(){
        Temperature temp = null;
        try {
            temp = raspberryUtilService.getCurrTemperature();
            Temperature lastTem = null;
            lastTem = temperatureService.findLast();
            if(lastTem == null || lastTem.getValue() != temp.getValue())
                temperatureService.create(temp);
        } catch (InterruptedException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }
}
