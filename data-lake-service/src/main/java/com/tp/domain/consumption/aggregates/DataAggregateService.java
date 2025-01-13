package com.tp.domain.consumption.aggregates;

import com.tp.domain.consumption.ConsumptionDataDto;

public interface DataAggregateService {
    void addToAggregate(ConsumptionDataDto dto);
}
