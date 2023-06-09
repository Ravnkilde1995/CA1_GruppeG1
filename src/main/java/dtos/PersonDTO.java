package dtos;

import entities.Person;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {
    private  Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private int idAddress;

    public PersonDTO(Integer id, String email, String firstName, String lastName, Integer phoneNumber, int idAddress) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idAddress = idAddress;
    }

    public PersonDTO(Person p) {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO entity = (PersonDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.idAddress, entity.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, phoneNumber, idAddress);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "idAddress = " + idAddress + ")";
    }

}
