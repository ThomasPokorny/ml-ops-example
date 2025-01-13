package com.tp.domain.consumption.aggregates.monthly;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface MonthlyConsumptionDataRepository extends JpaRepository<MonthlyConsumptionData, Long> {
    Optional<MonthlyConsumptionData> findByDateAndDevice(Date date, String device);
}
