package com.example.group_as1;

import entities.GeographicareaEntity;
import entities.HouseholdEntity;
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


    public List<GeographicareaEntity> returnID10(){
        List<GeographicareaEntity> id10 = new ArrayList<>();
        //Get Criteria Builder
        CriteriaQuery<GeographicareaEntity> criteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> area = criteriaQuery.from(GeographicareaEntity.class);
        criteriaQuery.select(area);
        //Get ID 10
        Predicate predicate1 = criteriaBuilder.equal(area.get("geographicAreaId"), "10");
        criteriaQuery.where(predicate1);

        //Set List
        CriteriaQuery<GeographicareaEntity> part2Question = criteriaQuery.select(area);
        TypedQuery<GeographicareaEntity> part2Query = em.createQuery(part2Question);
        id10 = part2Query.getResultList();

        return id10;
    }

    public List<GeographicareaEntity> returnLevel2(){
        List<GeographicareaEntity> level2 = new ArrayList<>();

        //Get Criteria Builder
        CriteriaQuery<GeographicareaEntity> criteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> area = criteriaQuery.from(GeographicareaEntity.class);
        criteriaQuery.select(area);

        //Get level 2
        Predicate predicate2 = criteriaBuilder.equal(area.get("level"), "2");
        criteriaQuery.where(predicate2);
        CriteriaQuery<GeographicareaEntity> part3Question = criteriaQuery.select(area);
        TypedQuery<GeographicareaEntity> part3Query = em.createQuery(part3Question);

        //Set List
        level2 = part3Query.getResultList();

        return level2;
    }

    public List<TotalincomeEntity> createQueryfindAllIncome(){
        List<TotalincomeEntity> income = new ArrayList<>();

        //Query
        TypedQuery<TotalincomeEntity> part4Question = em.createNamedQuery("findallIncome", TotalincomeEntity.class).setMaxResults(10);

        //Set List
        income = part4Question.getResultList();
        return income;
    }

    public Integer createQueryQuestion5(){
        List<HouseholdEntity> query = new ArrayList<>();
        CriteriaQuery<HouseholdEntity> criteriaQuery = criteriaBuilder.createQuery(HouseholdEntity.class);
        Root<HouseholdEntity> household = criteriaQuery.from(HouseholdEntity.class);
        criteriaQuery.select(household);

        Predicate predicate1 = criteriaBuilder.equal(household.get("householdType"), "4");
        Predicate predicate2 = criteriaBuilder.equal(household.get("householdSize"), "3");
        Predicate predicate3 = criteriaBuilder.equal(household.get("householdEarners"), "3");
        Predicate predicate4 = criteriaBuilder.equal(household.get("totalIncome"), "15");
        Predicate predicate5 = criteriaBuilder.equal(household.get("censusYear"), "1");
        criteriaQuery.where(predicate1);
        criteriaQuery.where(predicate2);
        criteriaQuery.where(predicate3);
        criteriaQuery.where(predicate4);
        criteriaQuery.where(predicate5);

        CriteriaQuery<HouseholdEntity> householdCriteria = criteriaQuery.select(household);
        TypedQuery<HouseholdEntity> householdQuery = em.createQuery(householdCriteria);
        query = householdQuery.getResultList();
        int count = query.size();
        return count;
    }

}
