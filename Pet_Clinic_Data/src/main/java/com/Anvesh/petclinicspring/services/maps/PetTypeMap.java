package com.Anvesh.petclinicspring.services.maps;

import com.Anvesh.petclinicspring.model.PetType;
import com.Anvesh.petclinicspring.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetTypeMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
