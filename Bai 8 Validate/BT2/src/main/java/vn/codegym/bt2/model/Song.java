package vn.codegym.bt2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank (message = "{error.name.blank}")
    @Size (min = 1, max = 800)
    @Pattern(regexp = "^[a-zA-Z_0-9\\s]+$", message = "{error.name.regex}")
    private String songTitle;
    @NotBlank (message = "{error.name.blank}")
    @Size (min = 1, max = 300)
    @Pattern(regexp = "^[a-zA-Z_0-9\\s]+$", message = "{error.name.regex}")
    private String songwriter;
    @NotBlank (message = "{error.name.blank}")
    @Size (min = 1, max = 1000)
    @Pattern(regexp = "^[a-zA-Z_0-9\\s,]+$", message = "{error.name.regex2}")
    private String musicGenre;

    public Song() {
    }
}
