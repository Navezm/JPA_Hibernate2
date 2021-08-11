package be.technobel.formation.iris.hibernate.model.dto;

import be.technobel.formation.iris.hibernate.model.embedded.Edition;
import be.technobel.formation.iris.hibernate.model.enums.Categories;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MangaDTO {
    private Long id;
    private String title;
    private Categories category;
    private Edition edition;
    private int bookAge;
    private LocalDate releaseDate;
}
