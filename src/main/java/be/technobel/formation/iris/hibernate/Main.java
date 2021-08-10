package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.Categories;
import be.technobel.formation.iris.hibernate.model.entity.Manga;
import be.technobel.formation.iris.hibernate.repository.MangaRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

        MangaRepository mangaRepository = serviceLocator.getRepository(MangaRepository.class);
        mangaRepository.insert(new Manga("Bleach", Categories.SHONEN, "SOT", LocalDate.of(2005, 6, 13)));

    }
}
