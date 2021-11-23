package by.itacademy.javaenterprise.seledsova.dao.impl;

import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = LoggerFactory.getLogger(PassportDaoImpl.class);
    private EntityManager entityManager;

    public PersonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Person savePerson(Person person) {
        if (person == null) throw new IllegalArgumentException();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage(), e);
        }
        return person;
    }


    @Override
    public Person findPersonById(long id) {
        Person person = new Person();
        try {
            person = entityManager.find(Person.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return person;
    }

    @Override
    public void updatePerson(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Person.class, person.getId());
            entityManager.merge(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void deletePerson(Long id) {
        try {
            entityManager.getTransaction().begin();
            Person person = entityManager.find(Person.class, id);
            entityManager.remove(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage(), e);
        }
    }
}

