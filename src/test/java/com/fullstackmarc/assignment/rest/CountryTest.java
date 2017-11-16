package com.fullstackmarc.assignment.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackmarc.assignment.model.Country;
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
public class CountryTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldReturnCountries() throws Exception {
        mockMvc.perform(get(URLConstants.COUNTRIES)).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._embedded.countries").exists());
    }

    @Test
    public void shouldReturnOneCountry() throws Exception {
        Country country = addCountryWithAssertion();

        mockMvc.perform(get(URLConstants.COUNTRIES + "/" + country.getCode())).andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.code").value(country.getCode()));
    }

    @Test
    public void shouldModifyExistingCountry() throws Exception {
        Country country = addCountryWithAssertion();

        mockMvc.perform(patch(URLConstants.COUNTRIES + "/" + country.getCode())
                .content("{\"population\":2}"))
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get(URLConstants.COUNTRIES + "/" + country.getCode()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.population").exists())
                .andExpect(jsonPath("$.population").value(2));
    }

    @Test
    public void shouldAddCountry() throws Exception {
        addCountryWithAssertion();
    }

    @Test
    public void shouldDeleteCountry() throws Exception {
        Country country = addCountryWithAssertion();

        mockMvc.perform(delete(URLConstants.COUNTRIES + "/" + country.getCode()))
                .andExpect(status().isNoContent());
    }

    private Country addCountryWithAssertion() throws Exception {
        Country country = EntityTestUtils.getCountry();
        String countryJson = mapper.writeValueAsString(country);
        mockMvc.perform(post(URLConstants.COUNTRIES).content(countryJson)).andExpect(status().isCreated());
        return country;
    }
}
