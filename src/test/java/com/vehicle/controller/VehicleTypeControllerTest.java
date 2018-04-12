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
public class VehicleTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final String vehicleTypeJson = "{"
            + "\"name\":\"CATEFORIA_1\","
            + "\"description\":\"Veículo de passeio\""
            + "}";

    @Test()
    public void testVehicleTypeSave() throws Exception {
        mockMvc.perform(post("/vehicleType").contentType(MediaType.APPLICATION_JSON).content(vehicleTypeJson))
                .andExpect(status().isCreated());
    }
}
