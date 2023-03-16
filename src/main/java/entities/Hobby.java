package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Hobby")
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHobby", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @Column(name = "category", nullable = false, length = 45)
    private String category;

    // Hobby constructor
    public Hobby(long id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }
    // Hobby constructor
    public Hobby(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }
    public Hobby() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}