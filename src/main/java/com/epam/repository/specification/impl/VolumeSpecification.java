package com.epam.repository.specification.impl;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.repository.specification.Specification;


public class VolumeSpecification implements Specification {
    private final double FROM_VOLUME;
    private final double TO_VOLUME;
    private final CubeCalculator calculator ;

    public VolumeSpecification(double FROM_VOLUME, double TO_VOLUME,CubeCalculator calculator ) {
        this.FROM_VOLUME = FROM_VOLUME;
        this.TO_VOLUME = TO_VOLUME;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(CubeIdetifiable cube) {
        double volume = calculator.calculateVolume(cube);
        
        return volume >= FROM_VOLUME && volume <= TO_VOLUME ;
    }
    
}
