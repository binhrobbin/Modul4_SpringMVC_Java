package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteRepository extends JpaRepository<Note,Integer> {
    Optional<Note> findByCode(int code);
}
