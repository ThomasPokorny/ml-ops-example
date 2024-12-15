package com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IngestionService {
    private static final String INGESTION_LABEL = """
             __     __   __     ______     ______     ______     ______   __     ______     __   __   \s
            /\\ \\   /\\ "-.\\ \\   /\\  ___\\   /\\  ___\\   /\\  ___\\   /\\__  _\\ /\\ \\   /\\  __ \\   /\\ "-.\\ \\  \s
            \\ \\ \\  \\ \\ \\-.  \\  \\ \\ \\__ \\  \\ \\  __\\   \\ \\___  \\  \\/_/\\ \\/ \\ \\ \\  \\ \\ \\/\\ \\  \\ \\ \\-.  \\ \s
             \\ \\_\\  \\ \\_\\\\"\\_\\  \\ \\_____\\  \\ \\_____\\  \\/\\_____\\    \\ \\_\\  \\ \\_\\  \\ \\_____\\  \\ \\_\\\\"\\_\\\s
              \\/_/   \\/_/ \\/_/   \\/_____/   \\/_____/   \\/_____/     \\/_/   \\/_/   \\/_____/   \\/_/ \\/_/\s
                                                                                                      \s
             ______     ______     ______     __   __   __     ______     ______                      \s
            /\\  ___\\   /\\  ___\\   /\\  == \\   /\\ \\ / /  /\\ \\   /\\  ___\\   /\\  ___\\                     \s
            \\ \\___  \\  \\ \\  __\\   \\ \\  __<   \\ \\ \\'/   \\ \\ \\  \\ \\ \\____  \\ \\  __\\                     \s
             \\/\\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\__|    \\ \\_\\  \\ \\_____\\  \\ \\_____\\                   \s
              \\/_____/   \\/_____/   \\/_/ /_/   \\/_/      \\/_/   \\/_____/   \\/_____/                   \s
                                                                                                      \s
            """;
    public static void main(String[] args) {
        SpringApplication.run(IngestionService.class, args);
        System.out.println(INGESTION_LABEL);
    }
}
