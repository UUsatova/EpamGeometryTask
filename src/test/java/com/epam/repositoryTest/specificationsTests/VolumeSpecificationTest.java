package com.epam.repositoryTest.specificationsTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;
import com.epam.repository.specification.impl.VolumeSpecification;

import org.junit.Test;
import org.mockito.Mockito;

public class VolumeSpecificationTest {

    @Test
    public void specifiedTestShoulReturnTrueWhenCubeVolumeFitsSpecification () {
        //given
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        VolumeSpecification specification = new VolumeSpecification(3.0, 5.0,cubeCalculator);
        when(cubeCalculator.calculateVolume(cube)).thenReturn(3.5);
        //then
        assertTrue(specification.specified(cube));
    }

    @Test
    public void specifiedTestShoulReturnTrueWhenCubeVolumeNotFitsSpecification () {
        //given
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        CubeCalculator cubeCalculator = Mockito.mock(CubeCalculator.class);
        VolumeSpecification specification = new VolumeSpecification(3.0, 5.0,cubeCalculator);
        when(cubeCalculator.calculateVolume(cube)).thenReturn(8.0);
        //then
        assertFalse(specification.specified(cube));
    }


}
