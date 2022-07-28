package com.spring.petclinicweb.bootstrap;

import com.spring.petclinicdata.model.*;
import com.spring.petclinicdata.services.OwnerService;
import com.spring.petclinicdata.services.PetTypeService;
import com.spring.petclinicdata.services.SpecialityService;
import com.spring.petclinicdata.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ComponentScan(basePackages = {"com.spring.petclinicdata"})
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private PetTypeService petTypeService;
//    private final PetService petService;
    private SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    public void run(String... args) throws Exception{

        loadData();
    }

    private void loadData() {
        System.out.println("Owners loaded....");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCat = petTypeService.save(cat);
        System.out.println("PetType loaded....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");

        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
//persisting data to get ID for the speciality
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedRadiology= specialityService.save(radiology);
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");
        owner1.setAddress("123L, askngt");
        owner1.setCity("GKP");
        owner1.setTelephone("1234567890");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setbDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Hideous");
        owner2.setLastName("Karimba");
        owner2.setAddress("97L, asdsd");
        owner2.setCity("GKP");
        owner2.setTelephone("0987654321");
        Pet karimsPet = new Pet();
        karimsPet.setName("biscuit");
        karimsPet.setPetType(savedCat);
        karimsPet.setbDay(LocalDate.now());
        karimsPet.setOwner(owner2);
        owner2.getPets().add(karimsPet);


        ownerService.save(owner2);

        System.out.println("Loaded loaders....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Rahul");
        vet1.setLastName("Dravid");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vikas");
        vet2.setLastName("Dubey");
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);
    }
}
