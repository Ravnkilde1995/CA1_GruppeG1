package dtos;

import java.io.Serializable;
import java.util.Objects;

public class CityInfoDTO implements Serializable {
    private final int id;
    private final String city;
    private final int zipCode;

    public CityInfoDTO(int id, String city, int zipCode) {
        this.id = id;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfoDTO entity = (CityInfoDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.zipCode, entity.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, zipCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")" +
                "city = " + city + ")" +
                "zipCode = " + zipCode + ")";
    }
}
