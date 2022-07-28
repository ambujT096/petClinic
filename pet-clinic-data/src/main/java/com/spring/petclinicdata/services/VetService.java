package com.spring.petclinicdata.services;

import com.spring.petclinicdata.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{

    Vet findByLastName(String lastName);

}
