package com.fullstackmarc.assignment.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private static Map<String, Continent> continentMap = Collections.unmodifiableMap(initializeMapping());
    private String description;

    Continent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Continent getContinentByDescription(String description) {
        return continentMap.get(description);
    }

    private static Map<String, Continent> initializeMapping() {
        Map<String, Continent> continentMap = new HashMap<>();
        for (Continent continent : Continent.values()) {
            continentMap.put(continent.description, continent);
        }
        return continentMap;
    }
}
