package com.epam.repositoryTest.specificationsTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.repository.specification.impl.IdSpecification;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IdSpecificationTest {

    @Test
    public void specifiedTestShoulReturnTrueWhenCubeIdFitsSpecification () {
        //given
        IdSpecification idSpecification = new IdSpecification(1);
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        when(cube.getId()).thenReturn(1);
        //then
        assertTrue(idSpecification.specified(cube));
    }

    @Test
    public void specifiedTestShoulReturnFalseWhenCubeIdNotFitsSpecification() {
        //given
        IdSpecification idSpecification = new IdSpecification(2);
        CubeIdetifiable cube = Mockito.mock(CubeIdetifiable.class);
        when(cube.getId()).thenReturn(1);
        //then
        assertFalse(idSpecification.specified(cube));
    }

    
}
