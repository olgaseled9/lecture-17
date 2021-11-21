package by.itacademy.javaenterprise.seledsova;

import by.itacademy.javaenterprise.seledsova.dao.PassportDao;
import by.itacademy.javaenterprise.seledsova.dao.PersonDao;
import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        personDao.findPersonById(5);
        PassportDao passportDao = new PassportDaoImpl();
        passportDao.findPassportById(6);
    }
}