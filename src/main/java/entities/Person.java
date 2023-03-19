package entities;

import javax.persistence.*;

/*
delete data inserted by test method in PersonFacadeTest, input on line 13.

name = "Person.deleteAllRows", query = "DELETE from Person
*/


@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerson", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Column(name = "phoneNumber", nullable = false)
    private Integer phoneNumber;

    @Column(name = "idAddress", nullable = false)
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAddress", nullable = false)
    private int idAddress;

    /*public Person(String email, String firstName, String lastName,  Address idAddress) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.phoneNumber = phoneNumber;
        this.idAddress = idAddress;
    }*/

    //Constructor without Adress

    public Person(String email, String firstName, String lastName, int phoneNumber, int idAddress) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idAddress = idAddress;
    }

    public Person() {

    }


    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}