package com.fullstackmarc.assignment.model;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ContinentTest {

    @Test
    public void testEnum() throws Exception {
        String description = Continent.AFRICA.getDescription();
        Assert.assertThat(Continent.getContinentByDescription(description), Matchers.is(Continent.AFRICA));
    }
}
