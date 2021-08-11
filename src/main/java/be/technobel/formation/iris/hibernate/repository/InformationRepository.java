package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.Information;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class InformationRepository extends AbstractRepository<Long, Information> {

    public InformationRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Information> findAll() {
        return null;
    }

    @Override
    public Information findOneById(Long id) {
        TypedQuery<Information> typedQuery = em.createQuery("SELECT i FROM Information i WHERE id = :id", Information.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void insert(Information obj) {
        if (obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Information obj) throws IllegalAccessException {

    }

    @Override
    public void remove(Long id) {

    }
}
