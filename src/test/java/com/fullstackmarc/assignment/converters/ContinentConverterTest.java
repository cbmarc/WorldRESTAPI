package com.fullstackmarc.assignment.converters;

import com.fullstackmarc.assignment.model.Continent;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ContinentConverterTest {

    @Test
    public void testGetColumn() throws Exception {
        ContinentConverter converter = new ContinentConverter();
        String column = converter.convertToDatabaseColumn(Continent.ASIA);
        Assert.assertThat(column, Matchers.equalTo("Asia"));
    }

    @Test
    public void testGetFromColumn() throws Exception {
        ContinentConverter converter = new ContinentConverter();
        String column = "North America";
        Continent continent = converter.convertToEntityAttribute(column);
        Assert.assertThat(continent, Matchers.equalTo(Continent.NORTH_AMERICA));
    }
}
