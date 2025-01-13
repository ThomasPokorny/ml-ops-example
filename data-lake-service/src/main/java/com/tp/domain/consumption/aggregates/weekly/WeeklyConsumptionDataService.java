package com.tp.domain.consumption.aggregates.weekly;

import com.tp.domain.consumption.ConsumptionDataDto;
import com.tp.domain.consumption.aggregates.DataAggregateService;
import com.tp.domain.consumption.aggregates.daily.DailyConsumptionData;
import com.tp.domain.consumption.aggregates.daily.DailyConsumptionDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class WeeklyConsumptionDataService implements DataAggregateService {
    private final WeeklyConsumptionDataRepository repository;

    public void addToAggregate(ConsumptionDataDto dto) {
        final var date = Date.from(LocalDateTime.parse(dto.dateTime()).toInstant(ZoneOffset.ofHours(0)));
        final var endOfWeek = getEndOfWeek(date);

        final var aggregate = repository.findByDateAndDevice(endOfWeek, dto.device()).orElseGet(() -> {
            final var createAggregate =  new WeeklyConsumptionData();
            createAggregate.setDevice(dto.device());
            createAggregate.setValue(0.0);
            createAggregate.setDate(endOfWeek);
            return createAggregate;
        });

        final var aggregatedValue = aggregate.getValue();
        aggregate.setValue(aggregatedValue + dto.value());

        this.repository.save(aggregate);
    }

    private Date getEndOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}