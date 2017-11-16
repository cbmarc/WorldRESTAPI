package com.fullstackmarc.assignment.converters;

import com.fullstackmarc.assignment.model.Continent;

import javax.persistence.AttributeConverter;

public class ContinentConverter implements AttributeConverter<Continent, String> {
    @Override
    public String convertToDatabaseColumn(Continent continent) {
        return continent.getDescription();
    }

    @Override
    public Continent convertToEntityAttribute(String s) {
        return Continent.getContinentByDescription(s);
    }
}
