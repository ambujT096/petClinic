package com.spring.petclinicdata.services;

import com.spring.petclinicdata.model.Owner;

import java.util.Set;

public interface OwnerService extends  CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
