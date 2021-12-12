package com.epam.service;

public class CubeParametrs {

    private final double volume;
    private final double surfaceArea;

    public CubeParametrs(double volume,double surfaceArea){
        this.volume = volume;
        this.surfaceArea = surfaceArea;

    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
    
}
