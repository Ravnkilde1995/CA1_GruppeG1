package dtos;

import entities.Address;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO implements Serializable {
    private final Integer id;
    private final String street;
    private final Integer streetNumber;
    private final String floor;
    private final Address idCityInfo;

    public AddressDTO(Integer id, String street, Integer streetNumber, String floor, Address idCityInfo) {
        this.id = id;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
        this.idCityInfo = idCityInfo;
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

    public Address getIdCityInfo() {
        return idCityInfo;
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
