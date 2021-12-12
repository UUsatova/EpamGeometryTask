package com.epam.logic.comparators;

import java.util.Comparator;

import com.epam.entity.CubeIdetifiable;

public class IdComporator implements Comparator<CubeIdetifiable> {

    @Override
    public int compare(CubeIdetifiable arg0, CubeIdetifiable arg1) {
        return arg1.getId() - arg0.getId();
 
    }
    
}
