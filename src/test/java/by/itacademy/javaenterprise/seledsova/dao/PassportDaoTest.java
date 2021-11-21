package by.itacademy.javaenterprise.seledsova.dao;

import by.itacademy.javaenterprise.seledsova.dao.impl.PassportDaoImpl;
import by.itacademy.javaenterprise.seledsova.entity.Passport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PassportDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private PassportDao passportDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        passportDao = new PassportDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindPassportByIdTest() {
        Passport passport = new Passport();
        Long id = 1L;
        passport.setPassportId(id);
        Class<Passport> anyObject = Mockito.any();
        Long eqValue = Mockito.eq(id);
        when(entityManagerMock.find(anyObject, eqValue)).thenReturn(passport);
        assertEquals(id, passportDao.findPassportById(id).getPassportId());
    }

    @Test
    void shouldSavePassportWithEntityNullTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            passportDao.savePassport(null);
        });
    }

    @Test
    void shouldFindPassportWithWrongIdTest() {
        Long id = -1L;
        assertNull(passportDao.findPassportById(id));
    }
}

