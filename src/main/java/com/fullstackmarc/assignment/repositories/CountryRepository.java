package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "countries")
public interface CountryRepository extends CrudRepository<Country, String> {
}
