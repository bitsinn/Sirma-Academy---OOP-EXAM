package com.system.management.files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.management.staff.Employee;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class JsonRead implements Reader{
    @Override
    public List<? extends Serializable> read(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(fileName), new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
