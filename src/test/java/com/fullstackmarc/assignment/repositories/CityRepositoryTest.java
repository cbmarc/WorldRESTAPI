package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.City;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class CityRepositoryTest extends AbstractCrudRepositoryTest<City, CityRepository> {

    @Autowired
    private CityRepository cityRepository;

    private City city;

    @Override
    protected City getEntity() {
        return city;
    }

    @Override
    protected CityRepository getRepository() {
        return cityRepository;
    }

    @Before
    public void setUp() throws Exception {
        this.city = RepositoryTestUtils.getCity();
        this.entityManager.persist(city.getCountry());
    }
}
