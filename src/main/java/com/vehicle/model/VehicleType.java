package com.vehicle.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleType implements Serializable  {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    @Column(name = "desc")
    private String description;
}
