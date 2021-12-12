package com.epam.logicTest.comporatorsTests;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.logic.comparators.VolumeComparator;

import org.junit.Test;
import org.mockito.Mockito;

public class VolumeComparatorTest {
    @Test
    public void compareTestShouldReturnPositiveVolumeDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        when(cubeCalculator.calculateVolume(arg0)).thenReturn(8.0);
        when(cubeCalculator.calculateVolume(arg1)).thenReturn(1.0);
       VolumeComparator comporator = new VolumeComparator(cubeCalculator);
       //then
        assertTrue(comporator.compare(arg0, arg1) > 0);
 
    }

    @Test
    public void compareTesttShouldReturnNegativeVolumeDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        when(cubeCalculator.calculateVolume(arg0)).thenReturn(1.0);
        when(cubeCalculator.calculateVolume(arg1)).thenReturn(8.0);
        VolumeComparator comporator = new VolumeComparator(cubeCalculator);
        //then
        assertTrue(comporator.compare(arg0, arg1) < 0);
 
    }
    
    
}
