package com.vehicle.controller;

import com.vehicle.model.VehicleType;
import com.vehicle.repository.VehicleTypeRepository;
import io.swagger.annotations.Api;
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
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @ApiOperation(value = "return all vehiclesType")
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(vehicleTypeRepository.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "return one vehicleType")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<VehicleType> optionalVehicleType = vehicleTypeRepository.findById(id);
        if (optionalVehicleType.isPresent()) {
            return new ResponseEntity(optionalVehicleType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "save or update one vehicleType", 
            notes = "When you use this method to save a new data, you mustn't need to give id.")
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody VehicleType vehicleType) {
        return new ResponseEntity(vehicleTypeRepository.save(vehicleType), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete one vehicleType")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            vehicleTypeRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
