package com.Anvesh.petclinicspring.model;

public class Person extends BaseEntity {
    private String firstname;
    private String secondname;

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
