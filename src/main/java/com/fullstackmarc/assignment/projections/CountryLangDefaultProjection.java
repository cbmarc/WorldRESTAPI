package com.fullstackmarc.assignment.projections;

import com.fullstackmarc.assignment.model.CountryLanguage;
import com.fullstackmarc.assignment.model.TrueFalseEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "countryLangDefault", types = {CountryLanguage.class})
public interface CountryLangDefaultProjection {
    @Value("#{target.countryCode}-#{target.language}")
    String getId();
    String getCountryCode();
    String getLanguage();
    Double getPercentage();
    TrueFalseEnum getIsOfficial();
}
