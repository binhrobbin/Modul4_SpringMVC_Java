package vn.codegym.bt2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.bt2.model.Song;

public interface ISongRepository extends JpaRepository <Song,Integer> {

}
