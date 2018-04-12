package com.vehicle;

import com.vehicle.model.Vehicle;
import com.vehicle.repository.VehicleRepository;
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

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(vehicleRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findAll(@PathVariable Long id) {
        return new ResponseEntity(vehicleRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Vehicle vehicle) {
        return new ResponseEntity(vehicleRepository.save(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
