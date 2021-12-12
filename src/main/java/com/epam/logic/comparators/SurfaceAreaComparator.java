package com.epam.logic.comparators;

import java.util.Comparator;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;

public class SurfaceAreaComparator implements Comparator<CubeIdetifiable> {

    private final CubeCalculator calculator ;
    
    public SurfaceAreaComparator(CubeCalculator calculator ){
        this.calculator = calculator;

    }
    
    @Override
    public int compare(CubeIdetifiable arg0, CubeIdetifiable arg1) {
        return Double.compare(calculator.calculateSurfaceArea(arg0), calculator.calculateSurfaceArea(arg1)) ;
    
    }
    
} 
