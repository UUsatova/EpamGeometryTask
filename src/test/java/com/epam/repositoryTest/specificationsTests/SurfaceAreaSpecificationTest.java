package com.epam.repositoryTest.specificationsTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.repository.specification.impl.SurfaceAreaSpecification;

import org.junit.Test;
import org.mockito.Mockito;

public class SurfaceAreaSpecificationTest {

    @Test
    public void specifiedTestShoulReturnTrueWhenCubeSurfaceAreaFitsSpecification () {
        //given
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        SurfaceAreaSpecification specification = new SurfaceAreaSpecification(3.0, 5.0,cubeCalculator);
        when(cubeCalculator.calculateSurfaceArea(cube)).thenReturn(4.0);
        //then
        assertTrue(specification.specified(cube));
    }

    public void specifiedTestShoulReturnTrueWhenCubeSurfaceAreaNotFitsSpecification () {
        //given
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        SurfaceAreaSpecification specification = new SurfaceAreaSpecification(3.0, 5.0,cubeCalculator);
        when(cubeCalculator.calculateSurfaceArea(cube)).thenReturn(8.0);
        // then
        assertFalse(specification.specified(cube));
    }
    
}
