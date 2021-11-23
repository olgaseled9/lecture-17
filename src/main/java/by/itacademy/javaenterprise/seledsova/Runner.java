package by.itacademy.javaenterprise.seledsova;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import by.itacademy.javaenterprise.seledsova.entity.Person;
import by.itacademy.javaenterprise.seledsova.util.FlywayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        FlywayUtil.cleanMigration();
        FlywayUtil.updateMigration();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PassportDao passportDao = new PassportDaoImpl(entityManager);
        Passport passport = passportDao.findPassportById(3L);
        logger.info(passport.toString());
        PersonDao personDao = new PersonDaoImpl(entityManager);
        Person person = personDao.findPersonById(3L);
        logger.info(person.toString());
        passportDao.deletePassport(3L);
        logger.info("person and passport are deleted");
        Person person1 = new Person(null, "Andrei", "Fedorov", " Fedorovich");
        personDao.savePerson(person1);
        Passport passport1 = new Passport(null, 121444, person1);
        passportDao.savePassport(passport1);
        entityManager.close();
    }
}
