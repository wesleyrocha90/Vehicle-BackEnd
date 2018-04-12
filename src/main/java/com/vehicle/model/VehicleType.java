package com.vehicle.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vehicle_type")
@Data
public class VehicleType implements Serializable  {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    @Column(name = "desc")
    private String description;
}
