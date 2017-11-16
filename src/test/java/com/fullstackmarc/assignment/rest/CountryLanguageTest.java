package com.fullstackmarc.assignment.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackmarc.assignment.model.Country;
import com.fullstackmarc.assignment.model.CountryLanguage;
import com.fullstackmarc.assignment.model.EntityTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CountryLanguageTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldReturnLanguages() throws Exception {
        mockMvc.perform(get(URLConstants.COUNTRY_LANGUAGES)).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._embedded.countryLanguages").exists());
    }

    @Test
    public void shouldReturnOneLanguages() throws Exception {
        CountryLanguage lang = addLanguageWithAssertion();

        mockMvc.perform(get(URLConstants.COUNTRY_LANGUAGES + "/" + lang.getId())).andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.countryCode").exists())
                .andExpect(jsonPath("$.countryCode").value(lang.getCountryCode()));
    }

    @Test
    public void shouldModifyExistingLanguage() throws Exception {
        CountryLanguage lang = addLanguageWithAssertion();

        mockMvc.perform(patch(URLConstants.COUNTRY_LANGUAGES + "/" + lang.getId())
                .content("{\"percentage\":50.00}"))
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get(URLConstants.COUNTRY_LANGUAGES + "/" + lang.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.percentage").exists())
                .andExpect(jsonPath("$.percentage").value(50.00));
    }

    @Test
    public void shouldAddLanguage() throws Exception {
        addLanguageWithAssertion();
    }



    @Test
    public void shouldDeleteLanguage() throws Exception {
        CountryLanguage lang = addLanguageWithAssertion();

        mockMvc.perform(delete(URLConstants.COUNTRY_LANGUAGES + "/" + lang.getId()))
                .andExpect(status().isNoContent());
    }

    private CountryLanguage addLanguageWithAssertion() throws Exception {
        createCountry();
        CountryLanguage lang = EntityTestUtils.getCountryLanguage();
        String json = mapper.writeValueAsString(lang);
        mockMvc.perform(post(URLConstants.COUNTRY_LANGUAGES).content(json))
                .andExpect(status().isCreated());
        return lang;
    }

    private void createCountry() throws Exception {
        String countryJson = mapper.writeValueAsString(EntityTestUtils.getCountry());
        mockMvc.perform(post(URLConstants.COUNTRIES).content(countryJson)).andExpect(status().isCreated());
    }
}
