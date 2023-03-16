package dtos;

import entities.Hobby;
import entities.RenameMe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HobbyDTO implements Serializable {
    private long id;
    private String name;
    private String description;
    private String category;

//    public HobbyDTO(long id, String name, String description, String category) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.category = category;
//    }

    public HobbyDTO(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public static List<HobbyDTO> getDtos(List<Hobby> hobbies){
        List<HobbyDTO> hobbyDTOs = new ArrayList();
        hobbies.forEach(hobby->hobbyDTOs.add(new HobbyDTO(hobby)));
        return hobbyDTOs;
    }

    public HobbyDTO(Hobby h) {
//        if(h.getId() != null)
            this.id = h.getId();
            this.name = h.getName();
            this.description = h.getDescription();
            this.category = h.getCategory();
    }


    // Getters and Setters
    public long getId() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
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
                "name = " + name + ", " +
                "description = " + description + ", " +
                "category = " + category + ")";
    }
}
