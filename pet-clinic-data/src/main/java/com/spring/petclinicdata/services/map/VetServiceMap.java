package com.spring.petclinicdata.services.map;

import com.spring.petclinicdata.model.Speciality;
import com.spring.petclinicdata.model.Vet;
import com.spring.petclinicdata.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityMapService specialityMapService;

    public VetServiceMap(SpecialityMapService specialityMapService) {
        this.specialityMapService = specialityMapService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach( speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityMapService.save(speciality);
                    speciality.setId(savedSpeciality.getId());

                    //speciality.setId(specialityMapService.save(speciality).getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
