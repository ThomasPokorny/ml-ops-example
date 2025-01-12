package com.tp.domain.consumption;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionDataService {
    private final ConsumptionDataRepository consumptionDataRepository;
    private final ConsumptionDataMapper consumptionDataMapper;

    public void save(ConsumptionDataDto consumptionDataDto) {
        ConsumptionData consumptionData = this.consumptionDataMapper.toEntity(consumptionDataDto);
        this.consumptionDataRepository.save(consumptionData);
    }
}