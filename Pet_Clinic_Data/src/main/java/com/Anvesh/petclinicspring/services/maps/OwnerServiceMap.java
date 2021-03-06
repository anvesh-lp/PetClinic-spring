package com.Anvesh.petclinicspring.services.maps;
import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findBySecondname(String lastName) {
        return super.findAll().stream()
                .filter(owner -> owner.getSecondname().equals(lastName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Owner> findbyLastnameLike(String secondname) {
//        todo implement later
        return null;
    }
}
