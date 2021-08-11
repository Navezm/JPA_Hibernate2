package be.technobel.formation.iris.hibernate.mapper;

import be.technobel.formation.iris.hibernate.model.dto.MangaDTO;
import be.technobel.formation.iris.hibernate.model.entity.Manga;

public class Mapper {

    public static MangaDTO toMangaDTO(Manga manga) {
        return MangaDTO.builder()
                .id(manga.getId())
                .title(manga.getTitle())
                .bookAge(manga.getBookAge())
                .category(manga.getCategory())
                .edition(manga.getEdition())
                .releaseDate(manga.getReleaseDate())
                .build();
    }

}
