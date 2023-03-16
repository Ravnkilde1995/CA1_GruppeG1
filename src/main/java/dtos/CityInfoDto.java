package dtos;

import java.io.Serializable;
import java.util.Objects;

public class CityInfoDto implements Serializable {
    private final Integer id;
    private final String city;
    private final Integer zipCode;

    public CityInfoDto(Integer id, String city, Integer zipCode) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfoDto entity = (CityInfoDto) o;
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
                "id = " + id + ", " +
                "city = " + city + ", " +
                "zipCode = " + zipCode + ")";
    }
}
