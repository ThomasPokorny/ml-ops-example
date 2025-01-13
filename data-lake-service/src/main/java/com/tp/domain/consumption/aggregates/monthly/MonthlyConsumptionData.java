package com.tp.domain.consumption.aggregates.monthly;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "monthly_consumption_data")
@Getter
@Setter
public class MonthlyConsumptionData {

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
