package com.epam.dao;

import java.util.Optional;
import java.util.StringTokenizer;

import com.epam.entity.Cube;
import com.epam.entity.Point;
import com.epam.logic.CubeCalculator;

public class CubeCreator {
    public static final String SPLITTER = " ";  // проверка на несколько пробелов

    public Optional<Cube> create(String lineWithCubeParametrs){
        double[] allPointsCoorditate = new double[12];
        StringTokenizer stringTokenizer = new StringTokenizer(lineWithCubeParametrs,SPLITTER);

        int i = 0;
        while(stringTokenizer.hasMoreTokens()){
                String currentCoordinatePoint = stringTokenizer.nextToken();
                allPointsCoorditate[i] = Double.parseDouble(currentCoordinatePoint);
                i++;

        }
        Point firstVertex  = new Point(allPointsCoorditate[0], allPointsCoorditate[1], allPointsCoorditate[2]);
        Point secondVertex = new Point(allPointsCoorditate[3], allPointsCoorditate[4], allPointsCoorditate[5]);
        Point therdVertex  = new Point(allPointsCoorditate[6], allPointsCoorditate[7], allPointsCoorditate[8]);
        Point fourthVertex = new Point(allPointsCoorditate[9], allPointsCoorditate[10], allPointsCoorditate[11]);

        CubeCalculator cubeCalculator = new CubeCalculator();
        if(cubeCalculator.isCube(firstVertex, secondVertex, therdVertex, fourthVertex)){
        Cube cube = new Cube(firstVertex, secondVertex, therdVertex, fourthVertex);
        return Optional.of(cube);
        }
        else{
            return Optional.empty();
        }
    }
    
}
