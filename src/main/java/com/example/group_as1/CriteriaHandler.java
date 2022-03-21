package com.example.group_as1;

import entities.GeographicareaEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CriteriaHandler {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private CriteriaBuilder criteriaBuilder;

    public CriteriaHandler() throws ClassNotFoundException {
        // Create EntityManager objects for JPA functionality
        emf = Persistence.createEntityManagerFactory("CCDBManager");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
        criteriaBuilder = em.getCriteriaBuilder();
    }

    public List<GeographicareaEntity> GetTop10GeographicAreas() {
        List<GeographicareaEntity> top10 = new ArrayList<>();

//        Use Multiselect to get the GeographicAreas
        CriteriaQuery<GeographicareaEntity> criteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> area = criteriaQuery.from(GeographicareaEntity.class);
        criteriaQuery.multiselect(area.get("code"), area.get("level"), area.get("name"));
        CriteriaQuery<GeographicareaEntity> multi_select = criteriaQuery.select(area);
        TypedQuery<GeographicareaEntity> q1 = em.createQuery(multi_select).setMaxResults(10);
        top10 = q1.getResultList();

        return top10;
    }
}
