package com.epam.repository.specification.impl;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.repository.specification.Specification;

public class SurfaceAreaSpecification implements Specification {
    private final double FROM_AREA;
    private final double TO_AREA;
    CubeCalculator calculator ;

    public SurfaceAreaSpecification(double FROM_AREA, double TO_AREA,CubeCalculator calculator) {
        this.FROM_AREA = FROM_AREA;
        this.TO_AREA = TO_AREA;
        this.calculator = calculator;

    }

    @Override
    public boolean specified(CubeIdetifiable cube) {
        double surfaceArea = calculator.calculateSurfaceArea(cube);
        
        return surfaceArea >= FROM_AREA && surfaceArea <= TO_AREA ;
    }
    
}
