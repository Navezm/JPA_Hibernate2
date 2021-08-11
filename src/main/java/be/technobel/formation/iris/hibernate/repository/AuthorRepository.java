package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.Author;
import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepository extends AbstractRepository<Long, Author> {

    public AuthorRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> typedQuery = em.createQuery("SELECT a FROM Author a", Author.class);
        return typedQuery.getResultList();
    }

    @Override
    public Author findOneById(Long id) {
        TypedQuery<Author> typedQuery = em.createQuery("SELECT a FROM Author a WHERE a.id = :id", Author.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void insert(Author obj) {
        if (obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Author obj) throws IllegalAccessException {

    }

    @Override
    public void remove(Long id) {

    }

    public void addManga(Long id, Manga manga) {
        Author toUpdate = findOneById(id);
        if (toUpdate != null) {
            getTransaction().begin();
            toUpdate.addManga(manga);
            em.merge(toUpdate);
            getTransaction().commit();
        }
    }
}
