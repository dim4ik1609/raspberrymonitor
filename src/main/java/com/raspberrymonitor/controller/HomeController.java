package com.raspberrymonitor.controller;

import com.raspberrymonitor.enity.Temperature;
import com.raspberrymonitor.service.TemperatureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

@Controller
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String homePage(Model model) {
        return "index";
    }
}
