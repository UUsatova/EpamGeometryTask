package com.epam.logicTest.comporatorsTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.comparators.IdComporator;

import org.junit.Test;
import org.mockito.Mockito;

public class IdComporatorTest {

    @Test
    public void compareTestShouldReturnPositiveIdDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        when(arg0.getId()).thenReturn(0);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        when(arg1.getId()).thenReturn(1);
        IdComporator comporator = new IdComporator();
        //then
        assertEquals(1, comporator.compare(arg0, arg1));
 
    }

    @Test
    public void compareTesttShouldReturnNegativeIdDifferense() {
        //given
        CubeIdetifiable arg0 = Mockito.mock(CubeIdetifiable.class);
        when(arg0.getId()).thenReturn(8);
        CubeIdetifiable arg1 = Mockito.mock(CubeIdetifiable.class);
        when(arg1.getId()).thenReturn(0);
        IdComporator comporator = new IdComporator();
        // then
        assertEquals(-8, comporator.compare(arg0, arg1));
 
    }
    
    
}
