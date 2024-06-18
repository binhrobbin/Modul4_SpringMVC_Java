package vn.codegym.bt2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.bt2.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    List<Song> findAll();
    void save(Song song);
    void remove(int id);
    Optional <Song> findByID(int id);
}
