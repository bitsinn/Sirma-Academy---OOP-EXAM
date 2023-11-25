package com.system.management.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class JsonWrite implements Writer{
    @Override
    public void write(List<Serializable> obj, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), obj);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
