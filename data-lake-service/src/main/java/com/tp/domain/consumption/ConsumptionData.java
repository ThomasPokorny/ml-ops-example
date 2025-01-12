package com.tp.domain.consumption;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "consumption_data")
@Getter
@Setter
public class ConsumptionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "device", nullable = false)
    private String device;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "metadata", columnDefinition = "jsonb")
    @Convert(converter = MetadataConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private Map<String, String> metadata;
}
