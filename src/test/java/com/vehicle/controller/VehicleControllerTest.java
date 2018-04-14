package com.vehicle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.model.Vehicle;
import com.vehicle.repository.VehicleRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    
    private MockMvc mockMvc;
    
    @Mock
    private VehicleRepository vehicleRepository;
    
    @InjectMocks
    private VehicleController vehicleController;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }
    
    @Test
    public void testVehicleFindAll_Ok() throws Exception {
        List<Vehicle> types = Arrays.asList(new Vehicle(1L, "Name", "Description", "Plate", null));
        Mockito.when(vehicleRepository.findAll()).thenReturn(types);
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicle").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Is.is(1)));
    }
    
    @Test
    public void testVehicleSave_Ok() throws Exception {
        Vehicle vehicle = new Vehicle(null, "Name", "Description", "Plate", null);
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(vehicle)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    @Test
    public void testVehicleSave_MissingData() throws Exception {
        Vehicle vehicle = new Vehicle(null, "Name", "Description", null, null);
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(vehicle)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void testVehicleDelete_Ok() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "Name", "Description", "Plate", null);
        Mockito.when(vehicleRepository.findById(vehicle.getId())).thenReturn(Optional.of(vehicle));
        mockMvc.perform(MockMvcRequestBuilders.delete("/vehicle/{id}", vehicle.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
