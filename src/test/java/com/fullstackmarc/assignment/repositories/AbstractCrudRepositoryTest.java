package com.fullstackmarc.assignment.repositories;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class AbstractCrudRepositoryTest<T, R extends CrudRepository> {

    @Autowired
    protected TestEntityManager entityManager;

    protected abstract T getEntity();
    protected abstract R getRepository();

    @Test
    public void testFindAll() throws Exception {
        this.entityManager.persist(getEntity());
        Iterable entities = getRepository().findAll();
        Assert.assertThat("No conuntries retrieved.", entities.spliterator().estimateSize(), Matchers.greaterThan(0l));
    }

}
