package com.tp.domain.validation.model;

public record ConsumptionData(String dateTime,
                              String device,
                              double value,
                              ConsumptionMetadata metadata) {
}
