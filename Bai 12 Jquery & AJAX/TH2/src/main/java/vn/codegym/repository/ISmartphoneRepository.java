package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Smartphone;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
