package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.Country;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryRepositoryTest extends AbstractCrudRepositoryTest<Country, CountryRepository> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    protected Country getEntity() {
        return RepositoryTestUtils.getCountry();
    }

    @Override
    protected CountryRepository getRepository() {
        return countryRepository;
    }

}
