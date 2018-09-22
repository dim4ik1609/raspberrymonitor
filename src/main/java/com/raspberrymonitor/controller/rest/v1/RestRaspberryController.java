package com.raspberrymonitor.controller.rest.v1;

import com.raspberrymonitor.enity.Cpu;
import com.raspberrymonitor.enity.Ram;
import com.raspberrymonitor.enity.Temperature;
import com.raspberrymonitor.service.TemperatureService;
import com.raspberrymonitor.util.RaspberryUtilService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RestRaspberryController {

    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private RaspberryUtilService raspberryUtilService;
    private Logger logger = Logger.getLogger(RestRaspberryController.class);

    @RequestMapping(path = "/rest/v1/temperature/findall", method = RequestMethod.GET)
    public List<Temperature> findAll() {
        return temperatureService.findAll();
    }

    @RequestMapping(path = "/rest/v1/temperature/findbydate/{date}", method = RequestMethod.GET)
    public List<Temperature> findByDate(@PathVariable String date) {

        List<Temperature> temp = null;
        try {
            Date paramDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            temp = temperatureService.findByDate(paramDate);
        } catch (ParseException e) {
            logger.debug(e.getMessage());
        }
        return temp;
    }

    @RequestMapping(path = "/rest/v1/temperature/tempcurrent", method = RequestMethod.GET)
    public Temperature currentTemp() {
        Temperature temp = null;

        try {
            temp = raspberryUtilService.getCurrTemperature();
        } catch (InterruptedException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        return temp;
    }

    @RequestMapping(path = "/rest/v1/cpu/cpuusage", method = RequestMethod.GET)
    public Cpu cpuUsage() {
        Cpu cpu = null;

        try {
            cpu = raspberryUtilService.getCpuUsage();
        } catch (InterruptedException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        return cpu;
    }

    @RequestMapping(path = "/rest/v1/ram/ramusage", method = RequestMethod.GET)
    public Ram ramUsage() {
        Ram ram = null;

        try {
            ram = raspberryUtilService.getRamUsage();
        } catch (InterruptedException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        return ram;
    }

}
