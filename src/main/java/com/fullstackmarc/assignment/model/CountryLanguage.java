package com.fullstackmarc.assignment.model;

import com.fullstackmarc.assignment.converters.TrueFalseEnumConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CountryLanguage implements Serializable {
    private CountryLanguagePK id;
    private Double percentage;
    private Country country;
    private TrueFalseEnum isOfficial;

    @EmbeddedId
    public CountryLanguagePK getId() {
        return id;
    }

    public void setId(CountryLanguagePK id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Percentage", nullable = false)
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "IsOfficial")
    @Convert(converter = TrueFalseEnumConverter.class)
    public TrueFalseEnum getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(TrueFalseEnum isOfficial) {
        this.isOfficial = isOfficial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryLanguage that = (CountryLanguage) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryLanguage() {
        this.isOfficial = TrueFalseEnum.FALSE;
        this.percentage = 0.0;
    }
}
