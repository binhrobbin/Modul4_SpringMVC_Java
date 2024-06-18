package vn.codegym.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.model.Province;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
}
