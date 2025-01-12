package com.tp.domain.ingestion;

import java.util.Map;

public record ConsumptionDataDto(String dateTime, String device, double value, Map<String, String> metadata) {
}
