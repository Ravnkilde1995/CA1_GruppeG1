package entities;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCityInfo", nullable = false)
    private CityInfo idCityInfo;

    public CityInfo getIdCityInfo() {
        return idCityInfo;
    }

    public void setIdCityInfo(CityInfo idCityInfo) {
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