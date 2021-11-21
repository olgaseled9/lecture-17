package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.dao.impl.PersonDaoImpl;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PersonDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private PersonDao personDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        personDao = new PersonDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindPassportByIdTest() {
        Passport passport = new Passport();
        Long id = 1L;
        passport.setPassportId(id);
        Class<Passport> anyObject = Mockito.any();
        Long eqValue = Mockito.eq(id);
        when(entityManagerMock.find(anyObject, eqValue)).thenReturn(passport);
        assertEquals(id, personDao.findPersonById(id).getId());
    }

    @Test
    void shouldSavePassportWithEntityNullTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            personDao.savePerson(null);
        });
    }

    @Test
    void shouldFindPassportWithWrongIdTest() {
        Long id = -1L;
        assertNull(personDao.findPersonById(id));
    }
}
