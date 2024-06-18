package vn.codegym.dto;

import lombok.Data;
import vn.codegym.entity.Phone;

import java.util.Set;

@Data
public class StudentDto {
    private int id;
    private String name;
    private int gender;
    private Set<Phone> phoneSet;
}
