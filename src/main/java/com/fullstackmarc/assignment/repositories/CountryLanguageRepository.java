package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.CountryLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "countryLanguages")
public interface CountryLanguageRepository extends CrudRepository<CountryLanguage, String> {
}
