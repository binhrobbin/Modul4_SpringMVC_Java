package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Note;

public interface INoteRepository extends JpaRepository<Note,Integer> {
    Note findByCode(int code);
}
