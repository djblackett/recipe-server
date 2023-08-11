package com.djblackett.recipesserver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class Recipe {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String category;

    @UpdateTimestamp
    private LocalDateTime date;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @ElementCollection
    @Size(min = 1)
    private List<String> ingredients;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<String> directions;
}
