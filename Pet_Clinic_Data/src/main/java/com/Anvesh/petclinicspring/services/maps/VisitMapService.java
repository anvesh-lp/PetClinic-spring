package com.Anvesh.petclinicspring.services.maps;

import com.Anvesh.petclinicspring.model.Visit;
import com.Anvesh.petclinicspring.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        throw new RuntimeException("save is not possible");
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
