package com.tp.domain.ingestion;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledIngestion {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("ingestion report");
    }
}
