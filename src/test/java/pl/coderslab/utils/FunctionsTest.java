package pl.coderslab.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static pl.coderslab.utils.Functions.getCountries;

public class FunctionsTest {

    @Test
    public void WhenGetCountriesCountriesNotEmpty() {
        List<String> countries = getCountries();
        assertTrue(countries.size() > 0);
    }
}