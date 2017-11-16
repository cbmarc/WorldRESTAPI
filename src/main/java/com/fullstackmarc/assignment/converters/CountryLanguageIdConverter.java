package com.fullstackmarc.assignment.converters;

import com.fullstackmarc.assignment.model.CountryLanguage;
import com.fullstackmarc.assignment.model.CountryLanguagePK;
import com.fullstackmarc.assignment.repositories.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CountryLanguageIdConverter implements BackendIdConverter {

    @Autowired
    private CountryLanguageRepository repository;

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if(id == null) {
            return null;
        }

        return repository.findOne(CountryLanguagePK.fromString(id));
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if(id == null) {
            return null;
        }
        return id.toString();
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return CountryLanguage.class.isAssignableFrom(delimiter);
    }

}
