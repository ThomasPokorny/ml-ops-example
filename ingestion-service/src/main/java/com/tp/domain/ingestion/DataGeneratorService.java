package com.tp.domain.ingestion;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataGeneratorService {

    private static final String CSV_FILE_PATH = "consumption_data.csv";
    private BufferedReader bufferedReader;
    private String[] headers;
    private String currentLine;

    // Date-Time formatter for standardization
    private static final DateTimeFormatter INPUT_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter STANDARD_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public DataGeneratorService() {
        try {
            // Initialize the reader and read headers
            bufferedReader = new BufferedReader(new FileReader(CSV_FILE_PATH));
            headers = bufferedReader.readLine().split(";");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Map<String, String>> generateConsumption() {
        List<Map<String, String>> deviceDataList = new ArrayList<>();
        try {
            if ((currentLine = bufferedReader.readLine()) != null) {
                String[] values = currentLine.split(";");
                String date = values[0];
                String time = values[1];

                // Combine Date and Time into a standardized DateTime format
                LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, INPUT_DATE_FORMATTER);
                String formattedDateTime = dateTime.format(STANDARD_DATE_FORMATTER);

                // Iterate over device columns and aggregate data
                for (int i = 2; i < headers.length; i++) { // Start from index 2 to skip Date and Time
                    Map<String, String> deviceData = new HashMap<>();
                    deviceData.put("DateTime", formattedDateTime);
                    deviceData.put("Device", headers[i]);
                    deviceData.put("Value", values[i]);
                    deviceDataList.add(deviceData);
                }
            } else {
                System.out.println("End of CSV file reached.");
                bufferedReader.close(); // Close the reader when done
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceDataList;
    }

}
