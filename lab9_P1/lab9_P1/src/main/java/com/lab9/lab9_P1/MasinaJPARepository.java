package com.lab9.lab9_P1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MasinaJPARepository {
    @PersistenceContext
    private EntityManager em;

    public List<Masina> findAll()
    {
        TypedQuery<Masina> query = em.createQuery("select m from Masina m", Masina.class);
        return query.getResultList();
    }
    public Masina findById(String id)
    {
        return em.find(Masina.class, id);
    }
    public void deleteById(String id)
    {
        em.remove(em.find(Masina.class, id));
    }
    public Masina insert(Masina masina)
    {
        return em.merge(masina);
    }
    public Masina update(Masina masina)
    {
        return em.merge(masina);
    }

}
