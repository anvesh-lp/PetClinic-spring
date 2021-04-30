package com.Anvesh.petclinicspring.bootstrap;

import com.Anvesh.petclinicspring.model.Owner;
import com.Anvesh.petclinicspring.model.Vet;
import com.Anvesh.petclinicspring.services.maps.OwnerServiceMap;
import com.Anvesh.petclinicspring.services.maps.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// To load Data When spring is loaded
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerService;
    private final VetServiceMap vetService;

    //Using spring context to intitalize the variables
    public DataLoader(OwnerServiceMap ownerService, VetServiceMap vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

   /* public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }*/

    @Override
    public void run(String... args) {

        //Boiler plate code hard coded
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Anvesh");
        owner1.setSecondname("Kunuguntla");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Anvesh");
        owner2.setSecondname("Kunuguntla");

        //Saving to Map
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Owners Loaded.....");

        Vet vet1 = new Vet();
        vet1.setFirstname("dr.Anvesh");
        vet1.setSecondname("Kunuguntla");
        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setFirstname("dr.Anvesh");
        vet2.setSecondname("Kunuguntla");
        vet2.setId(2L);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Vets Loaded.........");

    }
}
