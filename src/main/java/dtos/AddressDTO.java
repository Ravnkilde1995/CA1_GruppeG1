package dtos;

import entities.Address;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO implements Serializable {
    private  Integer id;
    private  String street;
    private  Integer streetNumber;
    private  String floor;
    private  CityinfoDto idCityInfo;

    public AddressDTO(Integer id, String street, Integer streetNumber, String floor, CityinfoDto idCityInfo) {
        this.id = id;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
        this.idCityInfo = idCityInfo;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
        this.floor = address.getFloor();
        this.idCityInfo = new CityinfoDto(address.getIdCityInfo());
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


    public CityinfoDto getIdCityInfo() {
        return idCityInfo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setIdCityInfo(CityinfoDto idCityInfo) {
        this.idCityInfo = idCityInfo;
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
