package com.vehicle.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.vehicle.model.VehicleType;
import com.vehicle.repository.VehicleTypeRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleTypeDeserialize extends StdDeserializer<VehicleType> {
    
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeDeserialize() {
        this(null);
    }

    public VehicleTypeDeserialize(Class<?> vc) {
        super(vc);
    }

    @Override
    public VehicleType deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Long id = (Long) node.asLong();
        return vehicleTypeRepository.findById(id).orElse(null);
    }    
}
