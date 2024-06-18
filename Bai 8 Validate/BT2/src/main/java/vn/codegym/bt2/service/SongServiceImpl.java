package vn.codegym.bt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.bt2.model.Song;
import vn.codegym.bt2.repository.ISongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public Optional<Song> findByID(int id) {
        return songRepository.findById(id);
    }
}
