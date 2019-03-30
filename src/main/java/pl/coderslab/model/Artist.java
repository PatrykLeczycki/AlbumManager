package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "artist")
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String pseudonym;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Column(nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull
    private String sex;

    @NotNull
    private String nationality;

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}