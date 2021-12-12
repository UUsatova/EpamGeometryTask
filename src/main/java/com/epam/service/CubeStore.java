package com.epam.service;

import java.util.HashMap;
import java.util.Map;

import com.epam.entity.CubeIdetifiable;
import com.epam.logic.CubeCalculator;


public class CubeStore implements Observer {

    private static CubeStore instance;
    private final Map<Integer, CubeParametrs>  listOfCubesAndItsparameters  = new HashMap<>();
    private final CubeCalculator cubeCalculator = new CubeCalculator();
    
    private CubeStore(){}

    @Override
    public void update(CubeIdetifiable cube) {
         double volume = cubeCalculator.calculateVolume(cube);
         double surfaceArea = cubeCalculator.calculateSurfaceArea(cube);
         listOfCubesAndItsparameters.put(cube.getId(), new CubeParametrs(volume, surfaceArea));
        
    }

    public Map<Integer, CubeParametrs> getListOfCubesAndItsparameters() {
        return listOfCubesAndItsparameters;
    }

    public static CubeStore getInstance(){
        if(instance == null ){
            instance = new CubeStore();
        }
        return instance;
    }
    
}
