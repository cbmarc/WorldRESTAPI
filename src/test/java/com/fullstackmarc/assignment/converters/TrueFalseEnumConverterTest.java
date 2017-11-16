package com.fullstackmarc.assignment.converters;

import com.fullstackmarc.assignment.model.TrueFalseEnum;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TrueFalseEnumConverterTest {

    @Test
    public void testGetColumn() throws Exception {
        TrueFalseEnumConverter converter = new TrueFalseEnumConverter();
        String column = converter.convertToDatabaseColumn(TrueFalseEnum.FALSE);
        Assert.assertThat(column, Matchers.equalTo("F"));

        column = converter.convertToDatabaseColumn(TrueFalseEnum.TRUE);
        Assert.assertThat(column, Matchers.equalTo("T"));
    }

    @Test
    public void testGetFromColumn() throws Exception {
        TrueFalseEnumConverter converter = new TrueFalseEnumConverter();
        String column = "F";
        TrueFalseEnum trueFalseEnum = converter.convertToEntityAttribute(column);
        Assert.assertThat(trueFalseEnum, Matchers.equalTo(TrueFalseEnum.FALSE));
    }
}
