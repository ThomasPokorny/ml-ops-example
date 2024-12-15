package com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DataLakeApplication {
    private static final String DATA_LAKE_LABEL = """
            
             ________  ________  _________  ________          ___       ________  ___  __    _______         \s
            |\\   ___ \\|\\   __  \\|\\___   ___\\\\   __  \\        |\\  \\     |\\   __  \\|\\  \\|\\  \\ |\\  ___ \\        \s
            \\ \\  \\_|\\ \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\|\\  \\       \\ \\  \\    \\ \\  \\|\\  \\ \\  \\/  /|\\ \\   __/|       \s
             \\ \\  \\ \\\\ \\ \\   __  \\   \\ \\  \\ \\ \\   __  \\       \\ \\  \\    \\ \\   __  \\ \\   ___  \\ \\  \\_|/__     \s
              \\ \\  \\_\\\\ \\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\       \\ \\  \\____\\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\    \s
               \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\       \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\_______\\   \s
                \\|_______|\\|__|\\|__|    \\|__|  \\|__|\\|__|        \\|_______|\\|__|\\|__|\\|__| \\|__|\\|_______|   \s
                                                                                                             \s
                                                                                                             \s
                                                                                                             \s
                                                                                           \s
            """;
    public static void main(String[] args) {
        SpringApplication.run(DataLakeApplication.class, args);
        System.out.println(DATA_LAKE_LABEL);
    }
}
