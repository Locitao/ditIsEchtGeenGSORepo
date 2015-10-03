/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rick van Duijnhoven
 * Some comments for methods were automatically generated when this class was created.
 */
public class TimeTest {
    
    private Time defaultTime;
    final int year = 1994, month = 10, day = 13;
    final int hours = 0, minutes = 59;
    
    @BeforeClass
    public void setUpClass() {
        defaultTime = new Time(year, month, day, hours, minutes);
    }
    

    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        DayInWeek thisWeek = this.defaultTime.getDayInWeek();
        assertNotNull("thisWeek can't be null", thisWeek);
        
        assertEquals("Should return WED", thisWeek, DayInWeek.WED);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        int year = this.defaultTime.getYear();
        assertEquals("Wrong year returned", this.year, year);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        int month = this.defaultTime.getMonth();
        assertEquals("Wrong month returned", this.month, month);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        int day = this.defaultTime.getDay();
        assertEquals("Wrong day returned.", this.day, day);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        int hours = this.defaultTime.getHours();
        assertEquals("Wrong hours returned", this.hours, hours);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        int minutes = this.defaultTime.getMinutes();
        assertEquals("Wrong amount of minutes returned.", this.minutes, minutes);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        int difference = 10;
        ITime t = defaultTime.plus(difference);
        assertNotNull("Can't be null with correct input", t);
        
        /**
         * Now calculate the actual difference
         */
        
        if(t.getHours() != defaultTime.getHours())
        {
            int expectedMinutes = difference - (60 - defaultTime.getMinutes());
            assertEquals("Expected difference is not the same as actual difference", expectedMinutes, t.getMinutes());
        }
        else
        {
            assertEquals("Expected difference is not the same as actual difference", defaultTime.getMinutes(), t.getMinutes());
        }
        
        t = defaultTime.plus(1440);
        assertFalse("Should be difference in days", defaultTime.getDay() == t.getDay());
        assertEquals("Hours should be the same", defaultTime.getHours(), t.getHours());
        assertEquals("Minutes should be the same", defaultTime.getMinutes(), t.getMinutes());
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = null;
        Time instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ITime time = null;
        Time instance = null;
        int expResult = 0;
        int result = instance.difference(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
