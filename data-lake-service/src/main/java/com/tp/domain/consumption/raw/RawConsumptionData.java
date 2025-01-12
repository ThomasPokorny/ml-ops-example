package com.tp.domain.consumption.raw;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDateTime;

@Entity
@Table(name = "raw_consumption_data")
@Getter
@Setter
public class RawConsumptionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", columnDefinition = "jsonb", nullable = false)
    @ColumnTransformer(write = "?::jsonb")
    private String data;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
}
