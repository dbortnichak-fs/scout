package com.djb.scout.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserEntityTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createMissingUserNameUser() throws Exception {
        User mockMissingPasswordUser = new User();
        mockMissingPasswordUser.setPassword("password");

        this.thrown.expect(ConstraintViolationException.class);
        this.testEntityManager.persistAndFlush(mockMissingPasswordUser);
    }

    @Test
    public void createMissingPasswordUser() throws Exception {
        User mockMissingPasswordUser = new User();
        mockMissingPasswordUser.setUserName("otto_user");

        this.thrown.expect(ConstraintViolationException.class);
        this.testEntityManager.persistAndFlush(mockMissingPasswordUser);
    }
}
