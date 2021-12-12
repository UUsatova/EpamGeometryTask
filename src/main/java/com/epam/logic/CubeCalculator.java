package com.epam.logic;

import com.epam.entity.Cube;
import com.epam.entity.Point;

public class CubeCalculator {

    private Point getVector(Point onePoint,Point secondPoint){
        return new Point(secondPoint.getX() - onePoint.getX(),
                        secondPoint.getY() - onePoint.getY(),
                        secondPoint.getZ() - onePoint.getZ());
    }

    private double multiplicateTwoVectors(Point firstVector,Point secondVector){
        return firstVector.getX() * secondVector.getX() + 
        firstVector.getY() * secondVector.getY() + 
        firstVector.getZ() * secondVector.getZ();
    
    }

    private double getVectorLength(Point vector){
        double slag1 = Math.pow(vector.getX(), 2);
        double slag2 = Math.pow(vector.getY(), 2);
        double slag3 = Math.pow(vector.getZ(), 2);
        return Math.sqrt(slag1 + slag2 + slag3);

    }

    public boolean isCube(Point firstVertex,Point secondVertex,Point therdVertex,Point fourthVertex ){
         Point firstVector = getVector(firstVertex, secondVertex);
         Point secondVector = getVector(firstVertex, therdVertex);
         Point therdVector = getVector(firstVertex, fourthVertex);
         double firstVectorLength = getVectorLength(firstVector);
         double secondVectorLength = getVectorLength(secondVector);
         double therdVectorLength = getVectorLength(therdVector);

         if(Double.compare(firstVectorLength, secondVectorLength) == 0 &&
            Double.compare(firstVectorLength, therdVectorLength) == 0 ){
            double innerProduct1 =  multiplicateTwoVectors(firstVector, secondVector);
            double innerProduct2 = multiplicateTwoVectors(firstVector, therdVector);
            double innerProduct3 =  multiplicateTwoVectors(secondVector, therdVector);

            if(Double.compare(innerProduct1, innerProduct2) == 0 &&
            Double.compare(innerProduct2, innerProduct3) == 0 ){
                return true;

            }

         }
        return false;
        
    }

    public double getfaceLength (Cube cube){
        return getVectorLength(getVector(cube.getFirstVertex(),cube.getSecondVertex()));

    }

    public double calculateSurfaceArea(Cube cube){
        return getfaceLength(cube) * getfaceLength(cube) * 6;

    }

    public double  calculateVolume (Cube cube){
        return Math.pow(getfaceLength(cube),3);

    }

    public boolean IsTheBaseOfTheCubeOnOneOfTheCoordinatePlanes(Cube cube){
        return false;

    }
    
    public double  ratioOfVolumesObtainedAsResultOfTheDissectionOfCubeByCoordinatePlane(){
        return 0;
        
    }

    
}
