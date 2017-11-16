package com.fullstackmarc.assignment.adapters;

import com.fullstackmarc.assignment.model.City;
import com.fullstackmarc.assignment.model.Country;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RepositoryAdapter extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(City.class);
    }

}
