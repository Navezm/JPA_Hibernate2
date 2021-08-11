package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.embedded.Weapon;
import be.technobel.formation.iris.hibernate.model.entity.Author;
import be.technobel.formation.iris.hibernate.model.entity.Information;
import be.technobel.formation.iris.hibernate.model.entity.Manga;
import be.technobel.formation.iris.hibernate.model.entity.Character;
import be.technobel.formation.iris.hibernate.model.enums.Categories;
import be.technobel.formation.iris.hibernate.model.enums.Role;
import be.technobel.formation.iris.hibernate.repository.AuthorRepository;
import be.technobel.formation.iris.hibernate.repository.CharacterRepository;
import be.technobel.formation.iris.hibernate.repository.InformationRepository;
import be.technobel.formation.iris.hibernate.repository.MangaRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

        MangaRepository mangaRepository = serviceLocator.getRepository(MangaRepository.class);
        CharacterRepository characterRepository = serviceLocator.getRepository(CharacterRepository.class);
        InformationRepository informationRepository = serviceLocator.getRepository(InformationRepository.class);
        AuthorRepository authorRepository = serviceLocator.getRepository(AuthorRepository.class);

//        mangaRepository.insert(new Manga("One Piece", Categories.HEROIC, null));
//        mangaRepository.insert(new Manga("Fairy Tail", Categories.HEROIC, null));

//        mangaRepository.findAll().forEach(System.out::println);
//        System.out.println(mangaRepository.findOneById(3L));
//        System.out.println(mangaRepository.findAllByCategory(Categories.HEROIC));

//        mangaRepository.update(2L, new Manga("Soul Eater", Categories.HEROIC, "STI", LocalDate.of(1999, 3,4)));
//        System.out.println(mangaRepository.findOneById(2L));


//        characterRepository.insert(new Character("Law", Role.PRINCIPAL, new Weapon("Sword", "Metal", false)));
//        characterRepository.insert(new Character("Sinbad", Role.PRINCIPAL, new Weapon("Sword", "Metal", true)));
//        System.out.println(characterRepository.findOneById(16L));



//        informationRepository.insert(new Information(180, 34, LocalDate.of(1996,6,21)));

//        characterRepository.addInformation(1L, informationRepository.findOneById(1L));
//        characterRepository.findAll().forEach(System.out::println);
//        characterRepository.remove(18L);
//        mangaRepository.findOneById(3L).setCharacterSet();

//        characterRepository.addManga(2L, mangaRepository.findOneById(1L));
//
//
//        characterRepository.findAll().forEach(System.out::println);


//        authorRepository.insert(new Author("SIU", "Youhou"));
//        authorRepository.insert(new Author("Oda", "Yahou"));
//        authorRepository.addManga(2L, mangaRepository.findOneById(2L));
//        authorRepository.addManga(2L, mangaRepository.findOneById(1L));
//        authorRepository.addManga(1L, mangaRepository.findOneById(1L));

        mangaRepository.findAll().forEach(System.out::println);

        authorRepository.findAll().forEach(System.out::println);
    }
}
