package com.epam.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.epam.entity.CubeIdetifiable;
import com.epam.repository.specification.Specification;

public interface CubeRepository {

    void add(CubeIdetifiable cube);

    void addAll(Map<Integer, CubeIdetifiable> cube);

    void delete(CubeIdetifiable cube);

    void update(CubeIdetifiable cube);

    List<CubeIdetifiable> query(Specification specification);

    List<CubeIdetifiable> sort(Comparator<CubeIdetifiable> comparator);

    
}
