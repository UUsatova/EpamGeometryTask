package com.epam.servicesTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.sql.rowset.serial.SerialArray;

import com.epam.entity.CubeIdetifiable;
import com.epam.entity.Point;
import com.epam.service.CubeParametrs;
import com.epam.service.CubeStore;

import org.junit.Test;


public class CubeStoreAndCubeIdentifiableTest {

    public static final double EPS = 0.000001;

    @Test
    public void notifyObserversAndUpdateTestShouldChangeCubeParametrsWhenCubeChanging(){

        //given
        CubeStore cubeStore = CubeStore.getInstance();
        CubeIdetifiable cube = new CubeIdetifiable(1,  new Point(0.0,0.0,0.0), new Point(1.0,0.0,0.0), new Point(0.0,1.0,0.0), new Point(0.0,0.0,1.0));
        cube.attach(cubeStore);
        cubeStore.update(cube);

        Map<Integer, CubeParametrs>  listOfCubesAndItsparameters = cubeStore.getListOfCubesAndItsparameters();
        CubeParametrs parametrsOfOurCub =  listOfCubesAndItsparameters.get(1);
        // when
        double volume = parametrsOfOurCub.getVolume();
        double surfaceArea = parametrsOfOurCub.getSurfaceArea();
       // then
        assertEquals(1,volume, EPS );
        assertEquals(6,surfaceArea, EPS );

        //given
        cube.setSecondVertex(new Point(2.0,0.0,0.0));
        cube.setTherdVertex(new Point(0.0,2.0,0.0));
        cube.setFourthVertex(new Point(0.0,0.0,2.0));

        //when
        parametrsOfOurCub =  listOfCubesAndItsparameters.get(1);
        volume = parametrsOfOurCub.getVolume();
        surfaceArea = parametrsOfOurCub.getSurfaceArea();

        //then
        assertEquals(8,volume, EPS );
        assertEquals(24,surfaceArea, EPS );



    }
    
}
