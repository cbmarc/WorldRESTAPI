package com.fullstackmarc.assignment.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum TrueFalseEnum {
    TRUE("T"),
    FALSE("F");

    private static Map<String, TrueFalseEnum> valueMap = Collections.unmodifiableMap(initializeMapping());

    private String value;

    public String getValue() {
        return value;
    }

    TrueFalseEnum(String value) {
        this.value = value;
    }

    public static TrueFalseEnum getByValue(String value) {
        return valueMap.get(value);
    }

    private static Map<String, TrueFalseEnum> initializeMapping() {
        Map<String, TrueFalseEnum> trueFalseMap = new HashMap<>();
        for (TrueFalseEnum trueFalseEnum : TrueFalseEnum.values()) {
            trueFalseMap.put(trueFalseEnum.value, trueFalseEnum);
        }
        return trueFalseMap;
    }
}
