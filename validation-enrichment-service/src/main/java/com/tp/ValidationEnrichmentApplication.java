package com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ValidationEnrichmentApplication {
    private static final String INGESTION_LABEL = """
             _    __      ___     __      __  _          \s
            | |  / /___ _/ (_)___/ /___ _/ /_(_)___  ____\s
            | | / / __ `/ / / __  / __ `/ __/ / __ \\/ __ \\
            | |/ / /_/ / / / /_/ / /_/ / /_/ / /_/ / / / /
            |___/\\__,_/_/_/\\__,_/\\__,_/\\__/_/\\____/_/ /_/\s
              / ___/___  ______   __(_)_______           \s
              \\__ \\/ _ \\/ ___/ | / / / ___/ _ \\          \s
             ___/ /  __/ /   | |/ / / /__/  __/          \s
            /____/\\___/_/    |___/_/\\___/\\___/           \s
                                                         \s                                                                                  \s
            """;
    public static void main(String[] args) {
        SpringApplication.run(ValidationEnrichmentApplication.class, args);
        System.out.println(INGESTION_LABEL);
    }
}
