package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDeleteCity() {
        CustomList cityList = new CustomList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);

        //test to see if removes
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));

        //test to see if exception thrown
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CustomList cityList = new CustomList();

        //tests no cities in list
        assertEquals(0, cityList.countCities());

        cityList.addCity(new City("Calgary", "AB"));
        //test 1 city
        assertEquals(1, cityList.countCities());

        //test 2 cities
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(2, cityList.countCities());

        //test after 1 deletion
        cityList.deleteCity(new City("Calgary", "AB"));
        assertEquals(1, cityList.countCities());

        //test after complete deletion
        cityList.deleteCity(city);
        assertEquals(0, cityList.countCities());
    }

}
