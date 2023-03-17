package dtos;

import entities.Address;
import entities.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDTO implements Serializable {
    private Long idPerson;
    private String email;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private Address idAddress;

    public PersonDTO(Long idPerson, String email, String firstName, String lastName, Integer phoneNumber, Address idAddress) {
        this.idPerson = idPerson;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idAddress = idAddress;
    }

    public PersonDTO(Person p) {
    }

    public static List<PersonDTO> getDtos(List<Person> persons) {
        List<PersonDTO> personDTOs = new ArrayList<>();
        persons.forEach((p) -> personDTOs.add(new PersonDTO(p)));
        return personDTOs;
    }

    public Long getId() {
        return idPerson;
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

    public Address getIdAddress() {
        return idAddress;
    }

    public void setId(Address id) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO entity = (PersonDTO) o;
        return Objects.equals(this.idPerson, entity.idPerson) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.idAddress, entity.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, email, firstName, lastName, phoneNumber, idAddress);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + idPerson + ", " +
                "email = " + email + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "idAddress = " + idAddress + ")";
    }

}
