package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); list.addCity(new City("Estevan", "SK")); assertEquals(list.getCount(),listSize + 1);
    }


    @Test
    void testHasCities(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void testDelete() throws Exception {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        list.delete(city);
        assertFalse(list.hasCity(city));
        assertThrows(Exception.class, () -> {
            list.delete(city);
        } );
    }
    @Test
    void testCount() {
        list = new CustomList(null,new ArrayList<>());
        assertEquals(0,list.countCities());
        City city = new City("Charlottetown", "Prince Edward Island");
        list.add(city);
        assertEquals(1,list.countCities());
    }
}
