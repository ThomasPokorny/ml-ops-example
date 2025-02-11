package com.tp.domain.consumption.raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawConsumptionDataRepository extends JpaRepository<RawConsumptionData, Long> {
}
