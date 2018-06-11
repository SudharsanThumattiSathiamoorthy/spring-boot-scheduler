package com.example.sudhar.springbootscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTasks {

    private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 20000)
    public void sendMailToCustomers() {

        System.out.println("sendMailToCustomers Job ran at "
                + format.format(new Date()));
    }
}
