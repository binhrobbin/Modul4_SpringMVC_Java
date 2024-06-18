package vn.codegym.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private  int gender;

//    @JsonManagedReference
//    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Phone> phoneSet;

    public Student() {
    }

    public Student(Integer id, String name, int gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
