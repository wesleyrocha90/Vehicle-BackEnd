package com.vehicle.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vehicle.deserialize.VehicleTypeDeserialize;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column(name = "`desc`")
    @NotBlank
    private String description;

    @Column
    @NotBlank
    private String plate;

    @ManyToOne
    @JoinColumn(name = "vehicle_type")
    @JsonDeserialize(using = VehicleTypeDeserialize.class)
    private VehicleType vehicleType;
}
