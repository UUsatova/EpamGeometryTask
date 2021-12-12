package com.epam.entity;

public final class Point {

    private double x;
    private double y;
    private double z;
    
    public Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object point) {
        if(this == point) {
            return true;
        }
        if(this == null || point.getClass() != getClass() ) {
            return false;
        }
        Point chekPoint = (Point)point;
        return Double.compare(chekPoint.x, x) == 0 && Double.compare(chekPoint.y, y) == 0 && Double.compare(chekPoint.z, z) == 0;
    
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";

    }
}
