package vn.codegym.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String author;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<Note> noteList;

    public Book() {
    }
}
