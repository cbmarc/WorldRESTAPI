package com.fullstackmarc.assignment.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackmarc.assignment.model.CountryLanguage;
import com.fullstackmarc.assignment.model.EntityTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    //TODO: Modify and find

    @Test
    public void shouldAddLanguage() throws Exception {
        createCountry();

        String json = mapper.writeValueAsString(EntityTestUtils.getCountryLanguage());
        mockMvc.perform(post(URLConstants.COUNTRY_LANGUAGES).content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteLanguage() throws Exception {
        createCountry();

        CountryLanguage lang = EntityTestUtils.getCountryLanguage();
        String json = mapper.writeValueAsString(lang);
        mockMvc.perform(post(URLConstants.COUNTRY_LANGUAGES).content(json))
                .andExpect(status().isCreated());

        mockMvc.perform(delete(URLConstants.COUNTRY_LANGUAGES + "/" + lang.getId()))
                .andExpect(status().isNoContent());
    }

    private void createCountry() throws Exception {
        String countryJson = mapper.writeValueAsString(EntityTestUtils.getCountry());
        mockMvc.perform(post(URLConstants.COUNTRIES).content(countryJson)).andExpect(status().isCreated());
    }
}
