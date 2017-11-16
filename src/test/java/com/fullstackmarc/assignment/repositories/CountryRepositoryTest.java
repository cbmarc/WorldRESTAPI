package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.Country;
import com.fullstackmarc.assignment.model.EntityTestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryRepositoryTest extends AbstractCrudRepositoryTest<Country, CountryRepository> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    protected Country getEntity() {
        return EntityTestUtils.getCountry();
    }

    @Override
    protected CountryRepository getRepository() {
        return countryRepository;
    }

}
