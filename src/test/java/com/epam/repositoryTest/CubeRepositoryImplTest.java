package com.epam.repositoryTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epam.entity.CubeIdetifiable;
import com.epam.entity.Point;
import com.epam.logic.comparators.IdComporator;
import com.epam.repository.CubeRepository;
import com.epam.repository.CubeRepositoryImpl;
import com.epam.repository.specification.impl.IdSpecification;

import org.junit.Test;
import org.mockito.Mockito;

public class CubeRepositoryImplTest {

    @Test
    public void queryAndIdSpecificationTestShouldReturnListOfCubesWhenIdMatches(){
        //given
        CubeIdetifiable firstCube = new CubeIdetifiable(1,new Point(0, 0, 0),new Point(0, 0, 1), new Point(0, 1, 0), new Point(1, 0, 0));
        CubeIdetifiable secondCube = new CubeIdetifiable(2,new Point(0, 0, 0),new Point(0, 0, 2), new Point(0, 2, 0), new Point(2, 0, 0));
        CubeRepository cubeRepository = new CubeRepositoryImpl();
        cubeRepository.add(firstCube);
        cubeRepository.add(secondCube);
        IdSpecification idSpecification = Mockito.mock(IdSpecification.class);
        when(idSpecification.specified(firstCube)).thenReturn(false);
        when(idSpecification.specified(secondCube)).thenReturn(true);

        List<CubeIdetifiable> expectedQuery = new ArrayList<>(Arrays.asList(new CubeIdetifiable(2,new Point(0, 0, 0),new Point(0, 0, 2), new Point(0, 2, 0), new Point(2, 0, 0))));
        //then
        assertEquals(expectedQuery, cubeRepository.query(idSpecification));

    }

    @Test
    public void queryTestShouldReturnEmptyListOfCubesWhenDoesNotFitSpecification(){
        //given
        CubeIdetifiable firstCube = new CubeIdetifiable(1,new Point(0, 0, 0),new Point(0, 0, 1), new Point(0, 1, 0), new Point(1, 0, 0));
        CubeIdetifiable secondCube = new CubeIdetifiable(2,new Point(0, 0, 0),new Point(0, 0, 2), new Point(0, 2, 0), new Point(2, 0, 0));
        CubeRepository cubeRepository = new CubeRepositoryImpl();
        cubeRepository.add(firstCube);
        cubeRepository.add(secondCube);
        IdSpecification idSpecification = Mockito.mock(IdSpecification.class);
        when(idSpecification.specified(firstCube)).thenReturn(false);
        when(idSpecification.specified(secondCube)).thenReturn(false);

        List<CubeIdetifiable> expectedQuery = new ArrayList<>();

        //then
        assertEquals(expectedQuery, cubeRepository.query(idSpecification));
    }

    @Test
    public void sortTestShouldReturnSortedListOfCubes(){
        //given
        CubeIdetifiable firstCube = new CubeIdetifiable(1,new Point(0, 0, 0),new Point(0, 0, 1), new Point(0, 1, 0), new Point(1, 0, 0));
        CubeIdetifiable secondCube = new CubeIdetifiable(2,new Point(0, 0, 0),new Point(0, 0, 2), new Point(0, 2, 0), new Point(2, 0, 0));
        CubeRepository cubeRepository = new CubeRepositoryImpl();
        cubeRepository.add(firstCube);
        cubeRepository.add(secondCube);
        
        IdComporator idComporator = Mockito.mock(IdComporator.class);
        when(idComporator.compare(firstCube, secondCube)).thenReturn(-1);

        List<CubeIdetifiable> expectedQuery = new ArrayList<>(Arrays.asList(firstCube,secondCube));

        //then
        assertEquals(expectedQuery, cubeRepository.sort(idComporator));
    }







    
}
