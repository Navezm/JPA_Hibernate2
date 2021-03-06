package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.Character;
import be.technobel.formation.iris.hibernate.model.entity.Information;
import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CharacterRepository extends AbstractRepository<Long, Character> {
    public CharacterRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Character> findAll() {
        TypedQuery<Character> characterTypedQuery = em.createQuery("SELECT c FROM character c", Character.class);
        return characterTypedQuery.getResultList();
    }

    @Override
    public Character findOneById(Long id) {
        TypedQuery<Character> characterTypedQuery = em.createQuery("SELECT c FROM character c WHERE c.id = :id", Character.class);
        characterTypedQuery.setParameter("id", id);
        return characterTypedQuery.getSingleResult();
    }

    @Override
    public void insert(Character obj) {
        if (obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Character obj) throws IllegalAccessException {
        Character toUpdate = findOneById(id);
        if (toUpdate != null) {
            merge(toUpdate, obj);
        }
    }

    @Override
    public void remove(Long id) {
        Character toRemove = findOneById(id);
        if (toRemove != null) {
            getTransaction().begin();
            em.remove(toRemove);
            getTransaction().commit();
        }
    }

    public void addManga(Long id, Manga manga) {
        Character toUpdate = findOneById(id);
        if (toUpdate != null) {
            getTransaction().begin();
            toUpdate.setManga(manga);
            manga.setCharacterSet(toUpdate);
            em.merge(toUpdate);
            getTransaction().commit();
        }
    }

    public void addInformation(Long id, Information information) {
        Character toUpdate = findOneById(id);
        if (toUpdate != null) {
            getTransaction().begin();
            toUpdate.setInformation(information);
            em.merge(toUpdate);
            getTransaction().commit();
        }
    }
}
