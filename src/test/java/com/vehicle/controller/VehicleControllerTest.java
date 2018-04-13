package com.vehicle.controller;

import com.vehicle.model.VehicleType;
import com.vehicle.repository.VehicleRepository;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    final String vehicleJson = "{"
            + "\"name\":\"Meu carro\","
            + "\"description\":\"Meu primeiro carro\","
            + "\"plate\":\"AAA-000\""
            + "}";

    @Test
    public void testVehicleSave() throws Exception {
        mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(vehicleJson))
                .andExpect(status().isCreated());
    }
}
