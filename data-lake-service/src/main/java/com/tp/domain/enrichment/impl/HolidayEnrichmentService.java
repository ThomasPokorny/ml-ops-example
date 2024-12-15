package com.tp.domain.enrichment.impl;

import com.tp.domain.enrichment.ConsumptionEnrichment;
import com.tp.domain.validation.model.ConsumptionData;
import org.springframework.stereotype.Service;

@Service
public class HolidayEnrichmentService implements ConsumptionEnrichment {
    @Override
    public void enrich(ConsumptionData consumptionData) {
        consumptionData.metadata().setHoliday(false);
    }
}
