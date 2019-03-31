package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetOwner {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;

    @ManyToMany()
    private Set<Pet> pets = new HashSet<>();

    public PetOwner() {

    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
