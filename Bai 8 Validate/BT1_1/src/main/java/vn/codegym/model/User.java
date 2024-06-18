package vn.codegym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 5, max = 45, message = "vui lòng điền 5-45 kí tự")
    private String firstName;
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})")
    private String phoneNumber;
    @Min(value = 18)
    private String age;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
}
