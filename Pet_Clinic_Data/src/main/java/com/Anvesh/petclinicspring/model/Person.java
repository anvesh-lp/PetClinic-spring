package com.Anvesh.petclinicspring.model;

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public class Person extends BaseEntity {
    private String firstname;
    private String secondname;

    public Person(Long id, String firstName, String lastName) {
        this.firstname = firstName;
        this.secondname = lastName;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}
