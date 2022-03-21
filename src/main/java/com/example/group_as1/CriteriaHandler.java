package com.example.group_as1;

import entities.AgeEntity;
import entities.GeographicareaEntity;
import entities.TotalincomeEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

    public List<AgeEntity> GetTop20AgeByDesc() {
        List<AgeEntity> ages = new ArrayList<>();

        CriteriaQuery<AgeEntity> criteriaQuery = criteriaBuilder.createQuery(AgeEntity.class);
        Root<AgeEntity> age = criteriaQuery.from(AgeEntity.class);

        criteriaQuery.select(age);
        criteriaQuery.orderBy(criteriaBuilder.desc(age.get("ageId")));
        CriteriaQuery<AgeEntity> orderby = criteriaQuery.select(age);

        TypedQuery<AgeEntity> q1 = em.createQuery(orderby).setMaxResults(20);
        ages = q1.getResultList();

        return ages;
    }

    public GeographicareaEntity GetPeterborough() {
        GeographicareaEntity area;

        CriteriaQuery<GeographicareaEntity> criteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> geoArea = criteriaQuery.from(GeographicareaEntity.class);

        Predicate p1 = criteriaBuilder.equal(geoArea.get("name"), "Peterborough");
        criteriaQuery.where(p1);
        CriteriaQuery<GeographicareaEntity> whereClause = criteriaQuery.select(geoArea);
        TypedQuery<GeographicareaEntity> q = em.createQuery(whereClause);

        area = q.getSingleResult();
        return area;
    }

    public List<TotalincomeEntity> GetTotalIncomesBetween10and20() {
        List<TotalincomeEntity> incomes = new ArrayList<>();


        return incomes;
    }

    public List<GeographicareaEntity> GetGeoGraphicAreasByLevel() {
        List<GeographicareaEntity> areas = new ArrayList<>();


        return areas;
    }
}
