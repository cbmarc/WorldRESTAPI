package com.fullstackmarc.assignment.converters;

import com.fullstackmarc.assignment.model.TrueFalseEnum;

import javax.persistence.AttributeConverter;

public class TrueFalseEnumConverter implements AttributeConverter<TrueFalseEnum, String> {
    @Override
    public String convertToDatabaseColumn(TrueFalseEnum trueFalseEnum) {
        return trueFalseEnum.getValue();
    }

    @Override
    public TrueFalseEnum convertToEntityAttribute(String s) {
        return TrueFalseEnum.getByValue(s);
    }
}
