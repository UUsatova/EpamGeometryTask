package com.epam.logicTest.comporatorsTests;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.logic.comparators.SurfaceAreaComparator;

import org.junit.Test;
import org.mockito.Mockito;

public class SurfaceAreaComparatorTest {

    
    @Test
    public void compareTesttShouldReturnPositiveSurfaceAreaDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        when(cubeCalculator.calculateSurfaceArea(arg0)).thenReturn(8.0);
        when(cubeCalculator.calculateSurfaceArea(arg1)).thenReturn(1.0);
        SurfaceAreaComparator comporator = new SurfaceAreaComparator(cubeCalculator);
        //then
        assertTrue(comporator.compare(arg0, arg1) > 0);
 
    }

    @Test
    public void compareTesttShouldReturnNegativeSurfaceAreaDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        when(cubeCalculator.calculateSurfaceArea(arg0)).thenReturn(1.0);
        when(cubeCalculator.calculateSurfaceArea(arg1)).thenReturn(8.0);
        SurfaceAreaComparator comporator = new SurfaceAreaComparator(cubeCalculator);
        //then
        assertTrue(comporator.compare(arg0, arg1) < 0);
 
    }
    
}
