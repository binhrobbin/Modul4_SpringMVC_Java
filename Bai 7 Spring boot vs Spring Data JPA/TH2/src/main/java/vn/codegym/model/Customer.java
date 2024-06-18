package vn.codegym.model;


import jakarta.persistence.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Entity
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"age","field.required","ko để trống");
        Customer c = (Customer) target;
        if (c.getAge() < 0) {
            errors.rejectValue("age", "negativeValue","(vô lý)");
        } else if (c.getAge() > 110) {
            errors.rejectValue("age", "too.darn.old", "(quá già)");
        }
        if (c.getFirstName() == null || "".equals(c.getFirstName())){
            errors.rejectValue("firstName","error.name.blank","(Không được để trống)");
        }
        if (c.getLastName() == null || "".equals(c.getLastName())){
            errors.rejectValue("lastName","error.name.blank","(Không được để trống)");
        }
    }
}
