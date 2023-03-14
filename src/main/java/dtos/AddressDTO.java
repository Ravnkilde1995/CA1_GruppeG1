package dtos;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO implements Serializable {
    private final Integer id;
    //private final CityInfoDTO cityInfo;
    private final String street;
    private final String streetNumber;
    private final String floor;

    public AddressDTO(Integer id, String street, String streetNumber, String floor) {
        this.id = id;
        //this.cityInfo = cityInfo;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    /*public CityInfoDTO getCityInfo() {
        return cityInfo;
    }*/

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO entity = (AddressDTO) o;
        return Objects.equals(this.id, entity.id) &&
               // Objects.equals(this.cityInfo, entity.cityInfo) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.streetNumber, entity.streetNumber) &&
                Objects.equals(this.floor, entity.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  street, streetNumber, floor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cityInfo = " + ", " +
                "street = " + street + ", " +
                "streetNumber = " + streetNumber + ", " +
                "floor = " + floor + ")";
    }
}
