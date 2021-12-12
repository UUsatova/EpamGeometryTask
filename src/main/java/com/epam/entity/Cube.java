package com.epam.entity;

public  class Cube {

    private Point firstVertex;
    private Point secondVertex;
    private Point therdVertex;
    private Point fourthVertex;

    public Cube(Point firstVertex,Point secondVertex,Point therdVertex,Point fourthVertex){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.therdVertex = therdVertex;
        this.fourthVertex = fourthVertex;

    }

    public Point getFirstVertex() {
        return firstVertex;
    }

    public Point getSecondVertex() {
        return secondVertex;
    }

    public Point getTherdVertex() {
        return therdVertex;
    }

    public Point getFourthVertex() {
        return fourthVertex;
    }

    public void setFirstVertex(Point firstVertex) {
        this.firstVertex = firstVertex;
    }
    public void setSecondVertex(Point secondVertex) {
        this.secondVertex = secondVertex;
    }

    public void setTherdVertex(Point therdVertex) {
        this.therdVertex = therdVertex;
    }

    public void setFourthVertex(Point fourthVertex) {
        this.fourthVertex = fourthVertex;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(this == null || obj.getClass() != getClass() ) {
            return false;
        }
        Cube checkCube = (Cube)obj;
        Point checkCubeFirstVertex = checkCube.firstVertex;
        Point checkCubeSecondVertex = checkCube.secondVertex;
        Point checkCubeTherdVertex = checkCube.therdVertex;
        Point checkCubeFourthVertex = checkCube.fourthVertex;
        
        return firstVertex.equals(checkCubeFirstVertex) && 
               secondVertex.equals(checkCubeSecondVertex)&& 
               therdVertex.equals(checkCubeTherdVertex)&&
               fourthVertex.equals(checkCubeFourthVertex);
    }

    @Override
    public String toString() {

        return "[" + firstVertex + " " + secondVertex + " " + therdVertex + " " + fourthVertex + "]";
    }
        
}
