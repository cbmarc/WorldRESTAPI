package com.fullstackmarc.assignment.model;

import javax.persistence.*;

@Entity
@IdClass(CountrylanguagePK.class)
public class CountryLanguage {
    private String countryCode;
    private String language;
    private Double percentage;
    private Country country;

    @Id
    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Id
    @Column(name = "Language")
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

        if (countryCode != null ? !countryCode.equals(that.getCountryCode()) : that.getCountryCode() != null) return false;
        if (language != null ? !language.equals(that.getLanguage()) : that.getLanguage() != null) return false;
        if (percentage != null ? !percentage.equals(that.getPercentage()) : that.getPercentage() != null) return false;

        return true;
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
