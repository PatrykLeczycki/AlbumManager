package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "artist")
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

    @NotBlank
    private int age;

    private String sex;

    @Column()
    private String country;

}