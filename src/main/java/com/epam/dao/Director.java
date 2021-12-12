package com.epam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.epam.entity.Cube;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {

    private CubeCreator cubeCreator;
    private CubeValidator cubeValidator;
    private DataReader dataReader;
    private static final Logger logger = LogManager.getLogger(Director.class);

    public Director(DataReader dataReader,CubeValidator cubeValidator,CubeCreator cubeCreator){
        this.dataReader = dataReader;
        this.cubeValidator = cubeValidator;
        this.cubeCreator = cubeCreator;

    }

    public List<Cube> read(String fileName) throws DataExeption  {
        List<Cube> cubes = new ArrayList<>();

        try {
            for(String item :dataReader.read(fileName)){
                if(cubeValidator.isCube(item)){
                    try {
                        Cube currentCube =  cubeCreator.create(item).get();
                        cubes.add(currentCube);
                    } catch (NoSuchElementException e) { logger.info("creation failed"); }
                    
                }
            }
            logger.info("successful creation");
          
        } catch (DataExeption e) {
            logger.error("DataExeption",e);
            throw new DataExeption();
        }
        
        return cubes;
       
    }

    
}
