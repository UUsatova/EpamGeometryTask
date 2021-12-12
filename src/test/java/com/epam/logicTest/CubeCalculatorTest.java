package com.epam.logicTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.epam.entity.Cube;
import com.epam.entity.Point;
import com.epam.logic.CubeCalculator;

import org.junit.Test;

public class CubeCalculatorTest {

    @Test
    public void isCubeShouldReturnTrueWhenPointsSetCube(){
     assertTrue(new CubeCalculator().isCube(new Point(0,0,0), new Point(0,0,1), new Point(0,1,0), new Point(1,0,0)));
        
    }

    @Test
    public void isCubeShouldReturnFalseWhenPointsNotSetCube(){
     assertFalse(new CubeCalculator().isCube(new Point(1,2,3), new Point(1,1,4), new Point(0,1,0), new Point(2,2,1)));

    }

    @Test
    public void getfaceLengthShouldReturnLengthFaceOfTheCube(){
     assertEquals(1,new CubeCalculator().getfaceLength(new Cube(new Point(0,0,0), new Point(0,0,1), new Point(0,1,0), new Point(1,0,0))),0.0001);
   
    }

    @Test
    public void calculateSurfaceAreaShouldReturnSurfaceAreaOfTheCube(){
     assertEquals(6,new CubeCalculator().calculateSurfaceArea(new Cube(new Point(0,0,0), new Point(0,0,1), new Point(0,1,0), new Point(1,0,0))),0.0001);
    }

    @Test
    public void calculateVolumeShouldReturncalculateVolumeOfTheCube(){
        assertEquals(1,new CubeCalculator().calculateVolume(new Cube(new Point(0,0,0), new Point(0,0,1), new Point(0,1,0), new Point(1,0,0))),0.0001);
       }
    







}
