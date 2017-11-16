package com.fullstackmarc.assignment.repositories;

import com.fullstackmarc.assignment.model.City;
import com.fullstackmarc.assignment.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cities")
public interface CityRepository extends CrudRepository<City, Integer> {
}
