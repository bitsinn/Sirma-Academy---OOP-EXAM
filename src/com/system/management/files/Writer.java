package com.system.management.files;


import java.io.Serializable;
import java.util.List;

public interface Writer {
    void write(List<Serializable> obj, String fileName);
}
