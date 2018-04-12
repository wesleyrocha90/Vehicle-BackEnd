package com.vehicle.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Vehicle implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    @Column(name = "desc")
    private String description;
    
    @Column
    private String plate;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_type")
    private VehicleType vehicleType;
}
