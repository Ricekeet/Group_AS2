package com.example.group_as1;

import entities.AgeEntity;
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
        CriteriaQuery<TotalincomeEntity> criteriaQuery = criteriaBuilder.createQuery(TotalincomeEntity.class);
        Root<TotalincomeEntity> totalincome = criteriaQuery.from(TotalincomeEntity.class);
        criteriaQuery.select(totalincome);
        Predicate predicate1 = criteriaBuilder.between(totalincome.get("id"),10,20);
        CriteriaQuery<TotalincomeEntity> totalincomecriteria = criteriaQuery.where(predicate1);
        TypedQuery<TotalincomeEntity> totalincomequery = em.createQuery(totalincomecriteria);
        incomes = totalincomequery.getResultList();

        return incomes;
    }

    public List<GeographicareaEntity> GetGeoGraphicAreasByLevel() {
        List<GeographicareaEntity> areas = new ArrayList<>();
        CriteriaQuery<GeographicareaEntity> criteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> area = criteriaQuery.from(GeographicareaEntity.class);

        criteriaQuery.select(area).groupBy(area.get("level"));
        CriteriaQuery<GeographicareaEntity> bylevel = criteriaQuery.select(area);
        TypedQuery<GeographicareaEntity> q1 = em.createQuery(bylevel);
        areas = q1.getResultList();
        return areas;
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

        CriteriaQuery<HouseholdEntity> householdCriteria = criteriaQuery.where(predicate1,predicate2,predicate3,predicate4,predicate5);
        TypedQuery<HouseholdEntity> householdQuery = em.createQuery(householdCriteria);
        query = householdQuery.getResultList();
        int count = query.size();
        return count;
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
}
