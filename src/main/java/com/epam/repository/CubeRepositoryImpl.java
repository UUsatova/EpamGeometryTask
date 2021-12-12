package com.epam.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.entity.CubeIdetifiable;
import com.epam.repository.specification.Specification;

public class CubeRepositoryImpl implements CubeRepository {
    private Map<Integer, CubeIdetifiable> store = new HashMap<>();

    @Override
    public void add(CubeIdetifiable cube) {
        store.put(cube.getId(), cube);
        
    }

    @Override
    public void addAll(Map<Integer, CubeIdetifiable> cube) {
        store.putAll(cube);
        
    }

    @Override
    public void delete(CubeIdetifiable cube) {
        store.remove(cube.getId());
        
    }

    @Override
    public void update(CubeIdetifiable cube) {
        store.replace(cube.getId(), cube);
        
    }

    @Override
    public List<CubeIdetifiable> query(Specification specification) {
        List<CubeIdetifiable> cubes = new ArrayList<>();
        for (CubeIdetifiable item : store.values()) {
            if (specification.specified(item)) {
                cubes.add(item);
            }
        }
        return cubes;
        
    }

    @Override
    public List<CubeIdetifiable> sort(final Comparator<CubeIdetifiable> comparator) {
        List<CubeIdetifiable> result = new ArrayList<>(store.values());
        result.sort(comparator);
        return result;
    }
    
}
