package com.fullstackmarc.assignment.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstackmarc.assignment.model.City;
import com.fullstackmarc.assignment.model.EntityTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_CLASS)
public class CityTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldReturnCities() throws Exception {
        mockMvc.perform(get(URLConstants.CITIES)).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._embedded.cities").exists());
    }

    @Test
    public void shouldReturnOneCity() throws Exception {
        City city = addCityWithAssertion();

        mockMvc.perform(get(URLConstants.CITIES + "/" + city.getId())).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(city.getId()));
    }

    @Test
    public void shouldModifyExistingCity() throws Exception {
        City city = addCityWithAssertion();

        mockMvc.perform(patch(URLConstants.CITIES + "/" + city.getId())
                .content("{\"population\":2}"))
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get(URLConstants.CITIES + "/" + city.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.population").exists())
                .andExpect(jsonPath("$.population").value(2));
    }

    @Test
    public void shouldAddCity() throws Exception {
        addCityWithAssertion();
    }

    @Test
    public void shouldDeleteCity() throws Exception {
        City city = addCityWithAssertion();

        mockMvc.perform(delete(URLConstants.CITIES + "/" + city.getId()))
                .andExpect(status().isNoContent());
    }

    private City addCityWithAssertion() throws Exception {
        City city = EntityTestUtils.getCity();
        String countryJson = mapper.writeValueAsString(city);
        mockMvc.perform(post(URLConstants.CITIES).content(countryJson)).andExpect(status().isCreated());
        return city;
    }
}
