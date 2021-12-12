package com.epam.repository.specification;

import com.epam.entity.CubeIdetifiable;

public interface Specification {

    boolean specified(CubeIdetifiable cube);

}