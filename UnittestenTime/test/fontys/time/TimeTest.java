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
    @Test(expected=IllegalArgumentException.class)
    public void testCompareTo() {
        assertEquals("Should be the same object in terms of content", 0, defaultTime.compareTo(defaultTime));
        assertEquals("Objects should be different in terms of content", 1, defaultTime.plus(2));
        assertEquals("Objects should be the same in terms of content", 0, defaultTime.plus(2).compareTo(defaultTime.plus(2)));
        
        try
        {
            FakeTime fake = new FakeTime();
            defaultTime.compareTo(fake);
            fail("No check if fake is a Time object");
        }
        catch (IllegalArgumentException ex){ }
        
        defaultTime.compareTo(null);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testDifference() {
        Time t = (Time) defaultTime.plus(500);
        int difference = defaultTime.difference(t);
        assertEquals("Amount of negative minutes should be the same", -500, difference);
        
        t = (Time) defaultTime.plus(-500);
        difference = defaultTime.difference(t);
        assertEquals("Minutes should be the same now", 500, difference);
        
        try
        {
            FakeTime fake = new FakeTime();
            defaultTime.difference(fake);
            fail("No check if it's a time object");
        }
        catch (IllegalArgumentException ex) {}
        
        defaultTime.difference(null);
    }
    
    /**
     * Static class to compare instances, with instanceOf
     */
    private static class FakeTime implements ITime {
        public FakeTime() {
        }

        @Override
        public int getYear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getMonth() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getDay() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getHours() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getMinutes() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DayInWeek getDayInWeek() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ITime plus(int minutes) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int difference(ITime time) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int compareTo(ITime o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
