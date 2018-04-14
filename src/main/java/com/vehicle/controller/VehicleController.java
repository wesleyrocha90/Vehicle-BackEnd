package com.vehicle.controller;

import com.vehicle.model.Vehicle;
import com.vehicle.repository.VehicleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Vehicle CRUD")
@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @ApiOperation(value = "return all vehicles")
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(vehicleRepository.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "return one vehicle")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            return new ResponseEntity(optionalVehicle.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "save or update one vehicle", 
            notes = "When you use this method to save a new data, you mustn't give id and the vehicleType value must be just one int referencing the pre saved vehicleType.")
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Vehicle vehicle) {
        return new ResponseEntity(vehicleRepository.save(vehicle), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete one vehicle")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            vehicleRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
