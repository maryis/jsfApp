package service;

import common.JPA;
import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonService {
    private PersonService(){}
    private static PersonService personService = new PersonService();

    public static PersonService getInstance() {
        return personService;
    }
    public void save(Person person)
    {
        EntityManager manager = JPA.getEntityManager();
        EntityTransaction transaction  =manager.getTransaction();
        transaction.begin();

        manager.persist(person);

        transaction.commit();
        manager.close();
    }
    public void update(Person person)
    {
        EntityManager manager = JPA.getEntityManager();
        EntityTransaction transaction  =manager.getTransaction();
        transaction.begin();

        manager.merge(person);

        transaction.commit();
        manager.close();
    }
    public void delete(Person person)
    {
        EntityManager manager = JPA.getEntityManager();
        EntityTransaction transaction  =manager.getTransaction();
        transaction.begin();

        person = manager.merge(person);
        manager.remove(person);

        transaction.commit();
        manager.close();
    }
    public List<Person> findAll()
    {
        EntityManager manager = JPA.getEntityManager();
        Query query = manager.createQuery("select entity from person entity");
        List<Person> personList = query.getResultList();
        manager.close();
        return personList;
    }
}
