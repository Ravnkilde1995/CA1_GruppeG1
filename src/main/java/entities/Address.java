package entities;

import dtos.AddressDTO;
import org.eclipse.persistence.jpa.config.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddress", nullable = false)
    private Integer id;

    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Column(name = "streetNumber", nullable = false)
    private Integer streetNumber;

    @Column(name = "floor", nullable = false, length = 45)
    private String floor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCityInfo", referencedColumnName = "idCityInfo")
    private Cityinfo idCityInfo;

    public Address(String street, Integer streetNumber, String floor) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
    }

    public Cityinfo getIdCityInfo() {
        return idCityInfo;
    }

    public Address (AddressDTO addressDTO) {
        this.id = addressDTO.getId();
        this.street = addressDTO.getStreet();
        this.streetNumber = addressDTO.getStreetNumber();
        this.floor = addressDTO.getFloor();
        this.idCityInfo = new Cityinfo(addressDTO.getIdCityInfo());
    }

    public Address() {

    }

    public void setIdCityInfo(Cityinfo idCityInfo) {
        this.idCityInfo = idCityInfo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}