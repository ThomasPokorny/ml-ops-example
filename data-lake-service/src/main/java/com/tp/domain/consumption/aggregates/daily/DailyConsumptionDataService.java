package com.tp.domain.consumption.aggregates.daily;

import com.tp.domain.consumption.ConsumptionDataDto;
import com.tp.domain.consumption.aggregates.DataAggregateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DailyConsumptionDataService implements DataAggregateService {
    private final DailyConsumptionDataRepository repository;

    public void addToAggregate(ConsumptionDataDto dto) {
        final var date = Date.from(LocalDateTime.parse(dto.dateTime()).toInstant(ZoneOffset.ofHours(0)));

        final var aggregate = repository.findByDate(date).orElseGet(() -> {
            final var createAggregate =  new DailyConsumptionData();
            createAggregate.setDevice(dto.device());
            createAggregate.setValue(0.0);
            createAggregate.setDate(date);
            return createAggregate;
        });

        final var aggregatedValue = aggregate.getValue();
        aggregate.setValue(aggregatedValue + dto.value());

        this.repository.save(aggregate);
    }
}