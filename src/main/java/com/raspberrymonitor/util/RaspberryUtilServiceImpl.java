package com.raspberrymonitor.util;

import com.raspberrymonitor.enity.Cpu;
import com.raspberrymonitor.enity.Ram;
import com.raspberrymonitor.enity.Temperature;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class RaspberryUtilServiceImpl implements RaspberryUtilService {

    private Logger logger = Logger.getLogger(RaspberryUtilServiceImpl.class);

    public Temperature getCurrTemperature() throws InterruptedException, IOException {

        Temperature temp = null;

        Process cmd = Runtime.getRuntime().exec("vcgencmd measure_temp");
        BufferedReader br = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
        String s = br.readLine();
        cmd.waitFor();
        logger.debug("cmd exit code=" + cmd.exitValue() + " val=" + s);
        s = s.replace("temp=", "").replace("'C", "");

        temp = new Temperature(Float.parseFloat(s), Calendar.getInstance().getTime());
        cmd.destroy();

        return temp;
    }

    public Cpu getCpuUsage() throws InterruptedException, IOException {
        Cpu cpu = null;

        Process cmd = Runtime.getRuntime().exec("top -b -n 1");
        BufferedReader br = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
        String s = "";
        for (int i = 0; i < 3; i++) {
            s = br.readLine();
        }
        cmd.waitFor();
        logger.debug("cmd exit code=" + cmd.exitValue() + " val=" + s);
        String[] arrCpu = s.split(",");
        int prCpuUsage = Math.round(100.0f - Float.parseFloat(arrCpu[3].replace("id", "").replace(" ", "")));

        cpu = new Cpu(prCpuUsage, Calendar.getInstance().getTime());
        cmd.destroy();

        return cpu;
    }

    public Ram getRamUsage() throws InterruptedException, IOException {
        Ram ram = null;

        Process cmd = Runtime.getRuntime().exec("top -b -n 1");
        BufferedReader br = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
        String s = "";
        for (int i = 0; i < 4; i++) {
            s = br.readLine();
        }
        cmd.waitFor();
        logger.debug("cmd exit code=" + cmd.exitValue() + " val=" + s);
        String[] arrRam = s.split(",");
        Double totalRam = 0.0d, usedRam = 0.0d;
        totalRam = Double.parseDouble(arrRam[0].replace("KiB Mem :", "").replace("total", "").trim());
        usedRam = Double.parseDouble(arrRam[2].replace("used", "").trim());

        ram = new Ram((int)Math.round((usedRam/totalRam)*100), new Date());
        cmd.destroy();

        return ram;
    }
}
