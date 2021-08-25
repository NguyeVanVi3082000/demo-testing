package com.example.demotesting.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// Testing with Spring ExtendWith and @DataJPATest


@SpringBootTest
class BookRepoTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private BookRepo bookRepo;

    @Test
    void injectedComponentAreNotNull() {
        assertNotNull(dataSource);
        assertNotNull(entityManager);
        assertNotNull(bookRepo);


    }
}