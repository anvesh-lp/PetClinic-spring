package com.Anvesh.petclinicspring.bootstrap;

import com.Anvesh.petclinicspring.model.*;
import com.Anvesh.petclinicspring.services.PetTypeService;
import com.Anvesh.petclinicspring.services.SpecialityService;
import com.Anvesh.petclinicspring.services.maps.OwnerServiceMap;
import com.Anvesh.petclinicspring.services.maps.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// To load Data When spring is loaded
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerService;
    private final VetServiceMap vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    //Using spring context to intitalize the variables
    public DataLoader(OwnerServiceMap ownerService, VetServiceMap vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) {

        loadData();

    }

    private void loadData() {
        Speciality surgeon = new Speciality();
        surgeon.setDescription("surgeon");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");

        Speciality savedSurgeon = specialityService.save(surgeon);
        Speciality savedDenyitstry = specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Contact contact1 = new Contact("India", "Redlakunta", "9999999");

        //Boiler plate code hard coded
        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstname("Anvesh");
        owner1.setSecondname("Kunuguntla");
        owner1.setContact(contact1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstname("Anvesh");
        owner2.setSecondname("Kunuguntla");
        owner2.setContact(contact1);

        //Saving to Map
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Owners Loaded.....");

        Vet vet1 = new Vet();
        vet1.setFirstname("dr.Anvesh");
        vet1.setSecondname("Kunuguntla");
//        vet1.getSpecialities().add(savedDenyitstry);

//        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setFirstname("dr.Anvesh");
        vet2.setSecondname("Kunuguntla");
//        vet2.getSpecialities().add(savedSurgeon);
//        vet2.setId(2L);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Vets Loaded.........");
        System.out.println(petTypeService.findAll());
    }
}
