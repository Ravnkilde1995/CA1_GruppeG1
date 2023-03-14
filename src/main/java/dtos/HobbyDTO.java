package dtos;

import java.io.Serializable;
import java.util.Objects;

public class HobbyDTO implements Serializable {
    private final Integer id;
    private final String name;
    private final String description;
    private final String category;

    public HobbyDTO(Integer id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HobbyDTO entity = (HobbyDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.category, entity.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "category = " + category + ")";
    }
}
