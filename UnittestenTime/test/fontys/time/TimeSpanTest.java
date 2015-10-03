/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Rick van Duijnhoven - Created first unit tests
 * @author Jules Kreutzer - Completed unit tests, specifications
 */
public class TimeSpanTest {
    Time t1 = new Time(2014, 10, 10, 20, 20);
    Time t2 = new Time(2015, 5, 5, 5, 10);
    TimeSpan tsTest = new TimeSpan(t1, t2);
    
    /**
     * exception can be used to expect an exception
     * usage:
     * exception.expect(ClassName.class);
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        assertEquals("Should equal t1", t1, tsTest.getBeginTime());
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        assertEquals("Should equal t2", t2, tsTest.getEndTime());
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength(){
        assertEquals("Difference in time isn't correct", t2.difference(t1), tsTest.length());
    }

    /**
     * Test the SetBeginThime Method
     * This will return an IllegalArgumentException because when creating the badTime instance is created, 25 is used for the hour parameter
     * 
     * Expected: IllegalArgument Exception as it will be thrown in the Time constructor
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetBeginTimeBad() {
        Time badTime = new Time(2016, 10, 10, 25, 25);
        
        TimeSpan ts = tsTest;
        ts.setBeginTime(badTime);
    }
    
    /**
     * Test the SetBeginTime method
     * Because the date is right, it should not return any error
     */
    @Test
    public void testSetBeginTimeGood() {
        Time goodTime = new Time(2016, 10, 13, 5, 5);
        
        TimeSpan ts = tsTest;
        ts.setBeginTime(goodTime);
        
        Assert.assertEquals(tsTest.getBeginTime(), goodTime);
    }

    /**
     * Test the SetEndTime method
     * This test should return an IllegalArgumentException because the endtime is before the begin time
     */
    @Test
    public void testSetEndTimeBad() {
        System.out.println("setEndTime");
        ITime endTime = new Time(2013, 1, 1, 1, 1);
        TimeSpan instance = tsTest;
        instance.setEndTime(endTime);
        
    }
    
    /**
     * Test the SetEndTime method
     * This test should pass because the end time is after the begin time
     */
    @Test
    public void testSetEndTimeGood() {
        ITime endTime = new Time(2017, 1, 1, 1, 1);
        TimeSpan instance = tsTest;
        instance.setEndTime(endTime);
        
        Assert.assertEquals(endTime.toString(), tsTest.getEndTime().toString());
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 0;
        TimeSpan instance = null;
        instance.move(minutes);
        // TODO review the generated test code and remove the default call to fail.
        exception.expect(NullPointerException.class);
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 0;
        TimeSpan instance = null;
        instance.changeLengthWith(minutes);
        exception.expect(NullPointerException.class);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        exception.expect(NullPointerException.class);
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        exception.expect(NullPointerException.class);
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        exception.expect(NullPointerException.class);    }
    
}
