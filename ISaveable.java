package com.codewithserdar;

import java.util.List;

public interface ISaveable {
    List<String> write();

    void read(List<String> var1);
}
