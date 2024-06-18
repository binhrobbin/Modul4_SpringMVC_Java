package vn.codegym.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int code;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Note() {
    }

    public Note(int code, Book book) {
        this.code = code;
        this.book = book;
    }
    public Note( Book book) {
        this.book = book;
    }
}
