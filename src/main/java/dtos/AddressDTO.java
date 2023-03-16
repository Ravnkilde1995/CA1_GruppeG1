package dtos;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO implements Serializable {
    private  Integer id;
    private  String street;
    private  Integer streetNumber;
    private  String floor;
    private  String city;
    private  String zipCode;
    private  int idCityInfo;


    public AddressDTO(Integer id, String street, Integer streetNumber, String floor, String city, String zipCode) {
        this.id = id;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getFloor() {
        return floor;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO entity = (AddressDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.streetNumber, entity.streetNumber) &&
                Objects.equals(this.floor, entity.floor) &&
                Objects.equals(this.idCityInfo, entity.idCityInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, streetNumber, floor, idCityInfo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "street = " + street + ", " +
                "streetNumber = " + streetNumber + ", " +
                "floor = " + floor + ", " +
                "idCityInfo = " + idCityInfo + ")";
    }
}
