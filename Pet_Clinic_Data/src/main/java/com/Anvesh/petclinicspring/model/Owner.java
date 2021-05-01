package com.Anvesh.petclinicspring.model;

import java.util.Set;

public class Owner extends Person {
    private Set<Pet> pets;
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
