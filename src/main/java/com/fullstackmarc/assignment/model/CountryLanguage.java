package com.fullstackmarc.assignment.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CountryLanguage implements Serializable {
    private CountryLanguagePK id;
    private String countryCode;
    private String language;
    private Double percentage;
    private Country country;

    @EmbeddedId
    public CountryLanguagePK getId() {
        return id;
    }

    public void setId(CountryLanguagePK id) {
        this.id = id;
        this.countryCode = id.getCountryCode();
        this.language = id.getLanguage();
    }

    @Column(name = "CountryCode", insertable = false, updatable = false)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "Language", insertable = false, updatable = false)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "Percentage")
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryLanguage that = (CountryLanguage) o;

        if (!id.equals(that.id)) return false;
        if (!countryCode.equals(that.countryCode)) return false;
        if (!language.equals(that.language)) return false;
        if (!percentage.equals(that.percentage)) return false;
        return country.equals(that.country);
    }

    @Override
    public int hashCode() {
        int result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
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
}
