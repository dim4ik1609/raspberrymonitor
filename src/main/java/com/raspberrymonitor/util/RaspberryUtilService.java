package com.raspberrymonitor.util;

import com.raspberrymonitor.enity.Cpu;
import com.raspberrymonitor.enity.Ram;
import com.raspberrymonitor.enity.Temperature;

import java.io.IOException;

public interface RaspberryUtilService {

    public Temperature getCurrTemperature() throws InterruptedException, IOException;
    public Cpu getCpuUsage() throws InterruptedException, IOException;
    public Ram getRamUsage() throws InterruptedException, IOException;
}
