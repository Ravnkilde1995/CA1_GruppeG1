package dtos;

import entities.Cityinfo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class CityinfoDto implements Serializable {
    private  Integer id;
    private  String city;
    private  Integer zipCode;
    private  Set<AddressDTO> addresses;

    public CityinfoDto(Integer id, String city, Integer zipCode, Set<AddressDTO> addresses) {
        this.id = id;
        this.city = city;
        this.zipCode = zipCode;
        this.addresses = addresses;
    }

    public CityinfoDto(Cityinfo idCityInfo) {
        this.id = idCityInfo.getId();
        this.city = idCityInfo.getCity();
        this.zipCode = idCityInfo.getZipCode();
        this.addresses = null;
    }

    public CityinfoDto(String city, int zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityinfoDto entity = (CityinfoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.zipCode, entity.zipCode) &&
                Objects.equals(this.addresses, entity.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, zipCode, addresses);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "city = " + city + ", " +
                "zipCode = " + zipCode + ", " +
                "addresses = " + addresses + ")";
    }
}
