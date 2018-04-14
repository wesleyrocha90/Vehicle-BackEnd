package com.vehicle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.model.VehicleType;
import com.vehicle.repository.VehicleTypeRepository;
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
public class VehicleTypeControllerTest {
    
    private MockMvc mockMvc;
    
    @Mock
    private VehicleTypeRepository vehicleTypeRepository;
    
    @InjectMocks
    private VehicleTypeController vehicleTypeController;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleTypeController).build();
    }

    @Test
    public void testVehicleTypeFindAll_Ok() throws Exception {
        List<VehicleType> types = Arrays.asList(new VehicleType(1L, "Name", "Description"));
        Mockito.when(vehicleTypeRepository.findAll()).thenReturn(types);
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicleType").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Is.is(1)));
    }
    
    @Test
    public void testVehicleTypeSave_Ok() throws Exception {
        VehicleType vehicleType = new VehicleType(null, "Name", "Description");
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicleType").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(vehicleType)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    @Test
    public void testVehicleTypeSave_MissingData() throws Exception {
        VehicleType vehicleType = new VehicleType(null, "Name", null);
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicleType").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(vehicleType)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void testVehicleTypeDelete_Ok() throws Exception {
        VehicleType vehicleType = new VehicleType(1L, "Name", "Description");
        Mockito.when(vehicleTypeRepository.findById(vehicleType.getId())).thenReturn(Optional.of(vehicleType));
        mockMvc.perform(MockMvcRequestBuilders.delete("/vehicleType/{id}", vehicleType.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
