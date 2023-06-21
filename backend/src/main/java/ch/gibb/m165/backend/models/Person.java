package ch.gibb.m165.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Person {

    @Id
    @MongoId
    private String id;
    private String firstName;
    private String lastName;
    private int employmentLvl;
    private boolean isMale;


    public Person(String id, String firstName, String lastName, int employmentLvl, boolean isMale) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentLvl = employmentLvl;
        this.isMale = isMale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmploymentLvl() {
        return employmentLvl;
    }

    public void setEmploymentLvl(int employmentLvl) {
        this.employmentLvl = employmentLvl;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        this.isMale = male;
    }
}
