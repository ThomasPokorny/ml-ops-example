package com.tp.domain.consumption.aggregates.daily;

import com.tp.domain.consumption.MetadataConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "daily_consumption_data")
@Getter
@Setter
public class DailyConsumptionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "device", nullable = false)
    private String device;

    @Column(name = "value", nullable = false)
    private Double value;
}
