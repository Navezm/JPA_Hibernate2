package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.Categories;
import be.technobel.formation.iris.hibernate.model.Role;
import be.technobel.formation.iris.hibernate.model.Weapon;
import be.technobel.formation.iris.hibernate.model.entity.Character;
import be.technobel.formation.iris.hibernate.model.entity.Manga;
import be.technobel.formation.iris.hibernate.repository.CharacterRepository;
import be.technobel.formation.iris.hibernate.repository.MangaRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

        MangaRepository mangaRepository = serviceLocator.getRepository(MangaRepository.class);
//        mangaRepository.insert(new Manga("One Piece", Categories.HEROIC, "Oda", null));

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

        mangaRepository.addCharacter(3L, characterRepository.findOneById(1L));

        mangaRepository.findAll().forEach(System.out::println);

        characterRepository.findAll().forEach(System.out::println);


    }
}
