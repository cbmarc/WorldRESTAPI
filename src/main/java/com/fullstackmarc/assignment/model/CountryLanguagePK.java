package com.fullstackmarc.assignment.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class CountryLanguagePK implements Serializable {
    private String countryCode;
    private String language;

    public static CountryLanguagePK fromString(String s) {
        String[] ids = s.split("-");
        return new CountryLanguagePK(ids[0], ids[1]);
    }

    public CountryLanguagePK() {
    }

    public CountryLanguagePK(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "Language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return countryCode + "-" + language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryLanguagePK that = (CountryLanguagePK) o;

        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
