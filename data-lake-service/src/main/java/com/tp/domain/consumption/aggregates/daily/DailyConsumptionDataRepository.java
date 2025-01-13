package com.tp.domain.consumption.aggregates.daily;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface DailyConsumptionDataRepository extends JpaRepository<DailyConsumptionData, Long> {
    Optional<DailyConsumptionData> findByDate(Date date);
}
