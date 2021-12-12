package com.epam.service;

import com.epam.entity.Cube;
import com.epam.entity.CubeIdetifiable;

public interface Observer {
    
    void update(CubeIdetifiable cube);
    
}
