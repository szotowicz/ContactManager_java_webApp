
package model;

import javax.persistence.*;

/**
 *
 * @author Mikołaj
 */
@Entity
@Table
public class Person {
    @Id
    @Column
    private int idContact;
    @Column
    private String emailOwner;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String category;
    @Column
    private String subcategory;
    @Column
    private String phoneNumber;
    @Column
    private String birthDate;

    public Person(){}
    
    public Person(int idContact, String emailOwner, String name, String lastName, String email, String category, String subcategory, String phoneNumber, String birthDate) {
        this.idContact = idContact;
        this.emailOwner = emailOwner;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.category = category;
        this.subcategory = subcategory;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmailOwner() {
        return emailOwner;
    }

    public void setEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

}
