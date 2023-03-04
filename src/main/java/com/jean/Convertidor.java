package com.jean;

import java.util.Map;

public interface Convertidor {
    public Map<String,String> getSupportedUnits();
    public double getconvert(String to, String from, double cantidad);
}
