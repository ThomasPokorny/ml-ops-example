package com.tp.domain.enrichment;

import com.tp.domain.validation.model.ConsumptionData;

public interface ConsumptionEnrichment {
    void enrich(ConsumptionData consumptionData);
}
