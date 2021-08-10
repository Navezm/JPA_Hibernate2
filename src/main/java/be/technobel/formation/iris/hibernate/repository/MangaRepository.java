package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class MangaRepository extends AbstractRepository<Long, Manga> {

    public MangaRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Manga> findAll() {
        return null;
    }

    @Override
    public Manga findOneById(Long id) {
        return null;
    }

    @Override
    public void insert(Manga obj) {
        if (obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Manga obj) throws IllegalAccessException {

    }

    @Override
    public void remove(Long id) {

    }
}
