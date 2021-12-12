package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.service.CubeParametrs;
import com.epam.service.CubeStore;
import com.epam.service.Observable;
import com.epam.service.Observer;

public class CubeIdetifiable extends Cube implements Observable {

    private final Integer id;
    List<Observer> observers = new ArrayList<>();

    public CubeIdetifiable(Integer id,Point firstVertex, Point secondVertex, Point therdVertex, Point fourthVertex) {
        super(firstVertex, secondVertex, therdVertex, fourthVertex);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setFirstVertex(Point firstVertex) {
        super.setFirstVertex(firstVertex);
        notifyObservers();
    }

    @Override
    public void setSecondVertex(Point secondVertex) {
        super.setSecondVertex(secondVertex);
        notifyObservers();
    }

    @Override
    public void setTherdVertex(Point therdVertex) {
        super.setTherdVertex(therdVertex);
        notifyObservers();
    }

    @Override
    public void setFourthVertex(Point fourthVertex) {
        super.setFourthVertex(fourthVertex);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        
    }

    @Override
    public void notifyObservers() {
        for(Observer item : observers){
            item.update(this);
        }
        
    }

   
}
