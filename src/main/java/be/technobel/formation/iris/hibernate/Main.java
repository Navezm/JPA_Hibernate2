package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.repository.CharacterRepository;
import be.technobel.formation.iris.hibernate.repository.MangaRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

        MangaRepository mangaRepository = serviceLocator.getRepository(MangaRepository.class);
//        mangaRepository.insert(new Manga("One Piece", Categories.HEROIC, "Oda", null));
//        mangaRepository.insert(new Manga("One", Categories.HEROIC, "Oda", null));

//        mangaRepository.findAll().forEach(System.out::println);
//        System.out.println(mangaRepository.findOneById(3L));
//        System.out.println(mangaRepository.findAllByCategory(Categories.HEROIC));

//        mangaRepository.update(2L, new Manga("Soul Eater", Categories.HEROIC, "STI", LocalDate.of(1999, 3,4)));
//        System.out.println(mangaRepository.findOneById(2L));

        CharacterRepository characterRepository = serviceLocator.getRepository(CharacterRepository.class);

//        characterRepository.insert(new Character("Law", Role.PRINCIPAL, new Weapon("Sword", "Metal", false)));
//        characterRepository.insert(new Character("Sinbad", Role.PRINCIPAL, new Weapon("Sword", "Metal", true)));
//        System.out.println(characterRepository.findOneById(16L));

//        characterRepository.findAll().forEach(System.out::println);
//        characterRepository.remove(18L);
//        mangaRepository.findOneById(3L).setCharacterSet();

//        characterRepository.addManga(1L, mangaRepository.findOneById(1L));
//
        mangaRepository.findAll().forEach(System.out::println);
//
        characterRepository.findAll().forEach(System.out::println);

    }
}
