package com.tp.domain.consumption.raw;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RawConsumptionDataService {
    private final RawConsumptionDataRepository rawConsumptionDataRepository;

    public void save(String data) {
        final var rawConsumptionData = new RawConsumptionData();
        rawConsumptionData.setData(data);
        rawConsumptionDataRepository.save(rawConsumptionData);
    }
}
