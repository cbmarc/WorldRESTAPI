package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.CountryLanguage;
import com.fullstackmarc.assignment.model.EntityTestUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryLanguageRepositoryTest extends AbstractCrudRepositoryTest<CountryLanguage, CountryLanguageRepository> {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    private CountryLanguage countryLanguage;

    @Override
    protected CountryLanguage getEntity() {
        return countryLanguage;
    }

    @Override
    protected CountryLanguageRepository getRepository() {
        return countryLanguageRepository;
    }

    @Before
    public void setUp() throws Exception {
        this.countryLanguage = EntityTestUtils.getCountryLanguage();
        this.entityManager.persist(countryLanguage.getCountry());
    }
}
