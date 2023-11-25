package com.system.management.files;

import java.io.Serializable;
import java.util.List;

public interface Reader {
    List<? extends Serializable> read(String fileName);
}
