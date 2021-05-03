package com.Anvesh.petclinicspring.services.maps;

import com.Anvesh.petclinicspring.model.Speciality;
import com.Anvesh.petclinicspring.services.CrudRepository;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements CrudRepository<Speciality, Long> {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);

    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
