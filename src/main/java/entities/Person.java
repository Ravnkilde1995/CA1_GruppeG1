package entities;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson", nullable = false)
    private Integer id;

  /* @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPerson", nullable = false)
    private Address address;*/

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastName;

    //husk at sætte adresse ind i constructoren
    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //this.address = address;
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

    /*public Address getAddress() {
        return address;
    }*/

    /*public void setAddress(Address address) {
        this.address = address;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person(Address address, String email, String firstName, String lastName) {
        //this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }
}