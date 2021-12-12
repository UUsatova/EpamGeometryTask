package com.epam.dao;

public class CubeValidator {

    private static final String CUBE_PARAMETRS_REGEX = "(-?\\d+\\.\\d+\\s+){12}";

    public boolean isCube(String lineWhithParametrs){ 
        return lineWhithParametrs.matches(CUBE_PARAMETRS_REGEX);

    }
    
}
