package com.spring.petclinicdata.services;

import com.spring.petclinicdata.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{
    Pet save(Pet pet);
}
