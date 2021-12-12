package com.epam.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.epam.dao.CubeCreator;
import com.epam.entity.Cube;
import com.epam.entity.Point;

import org.junit.Test;


public class CubeCreatorTest {

    @Test
    public void testCreateShouldCreateCubeWithCorrectDataAndValied(){
        //given
        CubeCreator cubeCreator = new CubeCreator();

        // when
        Cube expected = new Cube(new Point(0, 0, 0),new Point(0, 0, 1), new Point(0, 1, 0), new Point(1, 0, 0)) ;
        Cube actual = cubeCreator.create("0.0 0.0 0.0 0.0 0.0 1.0 0.0 1.0 0.0 1.0 0.0 0.0 ").get();

        //then
        assertEquals(expected,actual);
    }

    @Test(expected=java.lang.NumberFormatException.class)
    public void testCreateShouldThrowExeptionWhenDataIsInvalied(){
        //given
        CubeCreator cubeCreator = new CubeCreator();
        //then
        cubeCreator.create("0.0 0.0 0.0 0.z 0.0 1.0 0.0 1.0 0.0 1.0 0.0 0.0 ");

    }

    @Test
    public void testCreateShouldCreateNullCubeWhenDataIsValiedButIncorrect(){
        //given
        CubeCreator cubeCreator = new CubeCreator();
        //then
        assertFalse(cubeCreator.create("1.0 0.0 0.0 0.0 0.0 1.0 0.0 1.0 0.0 1.0 0.0 0.0 ").isPresent());

    }
    
}
