package com.vehicle.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test()
    public void testVehicleTypeSave() throws Exception {
        mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(vehicleJson))
                .andExpect(status().isCreated());
    }
}
