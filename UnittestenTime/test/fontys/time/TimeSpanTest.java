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
 * @author Rick van Duijnhoven - Generated first unit tests
 * @author Jules Kreutzer - Completed unit tests, specifications
 */
public class TimeSpanTest {
    Time t1;
    Time t2;
    TimeSpan tsTest;
    
    /**
     * Use this SetUp method to construct objects what are used in the unit test.
     * This way, all unit test start with the same object.
     * 
     * Make sure to use a field outside the SetUp method to assign the value, otherwise, it will not be recognized in tests.
     */
    @Before
    public void SetUp()
    {
        t1 = new Time(2014, 10, 10, 20, 20);
        t2 = new Time(2015, 5, 5, 5, 10);
        tsTest = new TimeSpan(t1, t2);
    }
    
    /**
     * Test if the method GetBeginTime returns the right ITime.
     */
    @Test
    public void testGetBeginTime() {
        assertEquals("Should equal t1", t1, tsTest.getBeginTime());
    }

    /**
     * Test if the method GetEndTime returns the right ITime.
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
        
        Assert.assertEquals(" tsTest must be before endTime", tsTest.getBeginTime().toString(), goodTime.toString());
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
        ITime endTime = new Time(2222, 1, 1, 1, 1);
        TimeSpan instance = tsTest;
        instance.setEndTime(endTime);
        
        Assert.assertTrue(tsTest.getEndTime().equals(endTime));
    }

    /**
     * Test the method move, the parameter for move may be negative.
     * 
     * Because minutes is 0 (zero) in this unit test, we except the IllegalArgumentException.class
     * We can't move 0 minutes...
     */
    @Test(expected=IllegalArgumentException.class)
    public void testMoveBad() {
        System.out.println("move");
        int minutes = 0;
        TimeSpan instance = tsTest;
        instance.move(minutes);
        
        
    }
    
    /**
     * Test the method move, the parameter for move may be negative.
     */
    @Test
    public void testMoveGood() {
        int minutes = 5;
        TimeSpan instance = tsTest;
        instance.move(minutes);
        Time bt = new Time(2014, 10, 10, 20, 25);
        Time et = new Time(2015, 5, 5, 5, 15);
        Assert.assertSame(instance.getBeginTime().toString(), bt.toString());
        Assert.assertSame(instance.getEndTime(), et);
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
    }
    
}
