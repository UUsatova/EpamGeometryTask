package com.epam.repository.specification.impl;

import com.epam.entity.CubeIdetifiable;
import com.epam.repository.specification.Specification;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(Integer id){
        this.id = id;
    }

    @Override
    public boolean specified(CubeIdetifiable cube) {
        
        return cube.getId().equals(id);
    }


    
}
