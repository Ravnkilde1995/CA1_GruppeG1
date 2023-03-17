package entities;

import javax.persistence.*;

@Entity
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCityInfo", nullable = false)
    private int id;

    @Column(name = "city", nullable = false, length = 60)
    private String city;

    @Column(name = "zipCode", nullable = false, length = 4)
    private int zipCode;

    public CityInfo(int id, String city,int zipCode ) {
        this.id = id;
        this.city = city;
        this.zipCode= zipCode;
    }

    public CityInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}