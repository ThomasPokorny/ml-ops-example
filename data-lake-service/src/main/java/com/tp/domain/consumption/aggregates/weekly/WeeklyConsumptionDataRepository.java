package com.tp.domain.consumption.aggregates.weekly;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface WeeklyConsumptionDataRepository extends JpaRepository<WeeklyConsumptionData, Long> {
    Optional<WeeklyConsumptionData> findByDate(Date date);
}
