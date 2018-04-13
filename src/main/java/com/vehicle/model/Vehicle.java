package com.vehicle.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vehicle.deserialize.VehicleTypeDeserialize;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonDeserialize(using = VehicleTypeDeserialize.class)
    private VehicleType vehicleType;
}
