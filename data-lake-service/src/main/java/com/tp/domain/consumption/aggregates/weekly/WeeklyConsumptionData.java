package com.tp.domain.consumption.aggregates.weekly;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "weekly_consumption_data")
@Getter
@Setter
public class WeeklyConsumptionData {

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
