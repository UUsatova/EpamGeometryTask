package com.epam.daoTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.epam.dao.CubeCreator;
import com.epam.dao.CubeValidator;
import com.epam.dao.DataExeption;
import com.epam.dao.DataReader;
import com.epam.dao.Director;
import com.epam.entity.Cube;
import com.epam.entity.Point;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class DirectorTest {

    @Test
    public void testReadShouldReturnListWithCorrectCubesWhenAllDataIsValiad() throws DataExeption{
        //given
        List<Cube> cubesExpected = new ArrayList<>();
        cubesExpected .add(new Cube( new Point(0.0, 0.0, 0.0), new Point(1.0, 0.0, 0.0),new Point(0.0, 1.0, 0.0),new Point(0.0, 0.0, 1.0)));
        cubesExpected .add(new Cube( new Point(0.0, 0.0, 0.0), new Point(2.0, 0.0, 0.0),new Point(0.0, 2.0, 0.0),new Point(0.0, 0.0, 2.0)));
        cubesExpected .add(new Cube( new Point(0.0, 0.0, 0.0), new Point(3.0, 0.0, 0.0),new Point(0.0, 3.0, 0.0),new Point(0.0, 0.0, 3.0)));
       

        DataReader dataReader = Mockito.mock(DataReader.class);
        String fileName = "fileName";
        List<String> allDataFromFile = new ArrayList<>(
            Arrays.asList("0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 ",
        "0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 ",
        "0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 "));
        when(dataReader.read(fileName)).thenReturn(allDataFromFile);


        CubeValidator cubeValidator = Mockito.mock(CubeValidator.class);
        when(cubeValidator.isCube(any())).thenReturn(true);

        CubeCreator cubeCreator = Mockito.mock(CubeCreator.class);
        when(cubeCreator.create("0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 ")).thenReturn(Optional.of(new Cube( new Point(0.0, 0.0, 0.0), new Point(1.0, 0.0, 0.0),new Point(0.0, 1.0, 0.0),new Point(0.0, 0.0, 1.0))));
        when(cubeCreator.create("0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 ")).thenReturn(Optional.of(new Cube(new Point(0.0, 0.0, 0.0), new Point(2.0, 0.0, 0.0),new Point(0.0, 2.0, 0.0),new Point(0.0, 0.0, 2.0))));
        when(cubeCreator.create("0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 ")).thenReturn(Optional.of(new Cube(new Point(0.0, 0.0, 0.0), new Point(3.0, 0.0, 0.0),new Point(0.0, 3.0, 0.0),new Point(0.0, 0.0, 3.0))));
       
        Director director = new Director(dataReader,cubeValidator,cubeCreator);
        //then
        assertEquals( cubesExpected , director.read(fileName));


    }

    @Test
    public void testReadShouldReturnListWithCorrectCubesWhenSomeDataIsInvaliadOrIncorrect() throws DataExeption{
        //given
        List<Cube> cubesExpected = new ArrayList<>();
        cubesExpected .add(new Cube( new Point(0.0, 0.0, 0.0), new Point(2.0, 0.0, 0.0),new Point(0.0, 2.0, 0.0),new Point(0.0, 0.0, 2.0)));
        
        DataReader dataReader = Mockito.mock(DataReader.class);
        String fileName = "fileName";
        List<String> allDataFromFile = new ArrayList<>(
            Arrays.asList("0z.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 ",
        "0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 ",
        "0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 3.0 0.0 0.0 0.0 "));
        when(dataReader.read(fileName)).thenReturn(allDataFromFile);


        CubeValidator cubeValidator = Mockito.mock(CubeValidator.class);
        when(cubeValidator.isCube("0z.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 ")).thenReturn(false);
        when(cubeValidator.isCube("0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 ")).thenReturn(true);
        when(cubeValidator.isCube("0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 3.0 0.0 0.0 0.0 ")).thenReturn(true);

        CubeCreator cubeCreator = Mockito.mock(CubeCreator.class);
        when(cubeCreator.create("0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 1.0 ")).thenReturn(Optional.of(new Cube( new Point(0.0, 0.0, 0.0), new Point(1.0, 0.0, 0.0),new Point(0.0, 1.0, 0.0),new Point(0.0, 0.0, 1.0))));
        when(cubeCreator.create("0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 2.0 ")).thenReturn(Optional.of(new Cube(new Point(0.0, 0.0, 0.0), new Point(2.0, 0.0, 0.0),new Point(0.0, 2.0, 0.0),new Point(0.0, 0.0, 2.0))));
        when(cubeCreator.create("0.0 0.0 0.0 3.0 0.0 0.0 0.0 3.0 3.0 0.0 0.0 0.0 ")).thenReturn(Optional.empty());
       
        Director director = new Director(dataReader,cubeValidator,cubeCreator);

        // then
        assertEquals( cubesExpected , director.read(fileName));


    }

     @Test(expected=com.epam.dao.DataExeption.class)
    public void testReadShouldWrightAboutErrorToLogFileAndThrowExeption() throws DataExeption {
        //given
        String fileName = "fileName";
        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.read(fileName)).thenThrow(new DataExeption());
        CubeValidator cubeValidator = Mockito.mock(CubeValidator.class);
        CubeCreator cubeCreator = Mockito.mock(CubeCreator.class);
       
        Director director = new Director(dataReader,cubeValidator,cubeCreator);
        //when
        director.read(fileName);

    }
  
}
