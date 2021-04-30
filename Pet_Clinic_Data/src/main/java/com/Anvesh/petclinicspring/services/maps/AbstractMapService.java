package com.Anvesh.petclinicspring.services.maps;

import com.Anvesh.petclinicspring.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object == null) {
            throw new RuntimeException("Object Cannot be NULL");
        }
        if (object.getId() == null) {
            object.setId(nextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //Generates next id for the object automatically similar to autogenerate of id in a database

    Long nextId() {
        if (map.keySet().isEmpty()) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
