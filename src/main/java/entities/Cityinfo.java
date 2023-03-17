package entities;

import dtos.CityinfoDto;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cityinfo")
public class Cityinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCityInfo", nullable = false)
    private Integer id;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Column(name = "zipCode", nullable = false)
    private Integer zipCode;

    @OneToMany(mappedBy = "idCityInfo")
    private Set<Address> addresses = new LinkedHashSet<>();

    public Cityinfo(CityinfoDto idCityInfo) {
        this.id = idCityInfo.getId();
        this.city = idCityInfo.getCity();
        this.zipCode = idCityInfo.getZipCode();
    }

    public Cityinfo() {

    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}