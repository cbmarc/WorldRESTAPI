package com.fullstackmarc.assignment.model;

public class EntityTestUtils {

    public static Country getCountry() {
        Country country = new Country();
        country.setCode("JPN");
        country.setName("Japan");
        country.setContinent(Continent.ASIA);
        country.setRegion("Eastern Asia");
        country.setSurfaceArea(377829.00);
        country.setIndepYear(-660);
        country.setPopulation(126714000);
        country.setLifeExpectancy(80.7);
        country.setGnp(3787042.00);
        country.setGnpOld(4192638.00);
        country.setLocalName("Nihon/Nippon");
        country.setGovernmentForm("Constitutional Monarchy");
        country.setHeadOfState("Akihito");
        country.setCapital(1532);
        country.setCode2("JP");
        return country;
    }

    public static City getCity() {
        City city = new City();
        city.setId(1594);
        city.setName("Akita");
        city.setCountry(getCountry());
        city.setDistrict("Akita");
        city.setPopulation(314440);
        return city;
    }

    public static CountryLanguage getCountryLanguage() {
        CountryLanguage lang = new CountryLanguage();
        Country country = getCountry();
        lang.setCountry(getCountry());
        lang.setId(new CountryLanguagePK(country.getCode(), "Japanese"));
        lang.setPercentage(99.1);
        return lang;
    }
}
