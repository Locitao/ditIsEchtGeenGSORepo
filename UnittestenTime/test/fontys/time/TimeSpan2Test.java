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
 * @author Rick van Duijnhoven, copied from TimeSpanTest as per assignment.
 */
public class TimeSpan2Test {
    Time t1;
    Time t2;
    TimeSpan2 tsTest;
    
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
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
        tsTest = new TimeSpan2(t1, t2);
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
        
        TimeSpan2 ts = tsTest;
        ts.setBeginTime(badTime);
    }
    
    /**
     * Test the SetBeginTime method
     * Because the date is right, it should not return any error
     */
    @Test
    public void testSetBeginTimeGood() {
        Time goodTime = new Time(2015, 5, 5, 5, 4);
        
        TimeSpan2 ts = tsTest;
        ts.setBeginTime(goodTime);
        
        Assert.assertEquals(" tsTest must be before endTime", tsTest.getBeginTime().toString(), goodTime.toString());
    }
    
    /**
     * Test the SetEndTime method
     * First we try to set a wrong endtime and we expect that an exeption is thrown.
     * After that we Try to set the endTime with a correct time.
     * 
     * The unit test will pass when an exception is thrown first, and then no exception is thrown.
     */
    @Test
    public void testSetEndTime() {
        Time badTime = new Time(2010, 12, 4, 18, 20);
        try {
            TimeSpan2 tsTestEndTime = tsTest;
            tsTestEndTime.setEndTime(badTime);
            exception.expect(IllegalArgumentException.class);
        } catch (Exception e) {

        }
        Time newTimeCorrect = new Time(2015, 1, 1, 12, 01);
        TimeSpan2 tsTestEndTime = tsTest;
        tsTestEndTime.setEndTime(newTimeCorrect);
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
        TimeSpan2 instance = tsTest;
        instance.move(minutes);
        
        
    }
    
    /**
     * Test the method move, the parameter for move may be negative.
     * First we test the move method with a positive param,
     * second we test the move method with a negative param.
     * 
     * Both should pass
     */
    @Test
    public void testMoveGood() {
        int minutes = 5;
        TimeSpan2 instance = tsTest;
        try{
            instance.move(minutes);
        }
        catch(Exception e){
            
        }
        
        int minutesNegative = -5;
        TimeSpan2 instance2 = tsTest;
        try{
            instance.move(minutesNegative);
        }
        catch(Exception ex)
        {
            
        }
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
        ITimeSpan timeSpanTrue = tsTest;
        ITime time1True = new Time(2014, 10, 10, 20, 15);
        ITime time2True = new Time(2015, 5, 5, 5, 15);
        TimeSpan2 instance = new TimeSpan2(time1True, time2True);
        boolean expResultTrue = true;
        boolean resultTrue = instance.isPartOf(timeSpanTrue);
        assertEquals(expResultTrue, resultTrue);
        
        ITimeSpan timeSpanFalse = tsTest;
        ITime time1False = new Time(2014, 10, 10, 20, 20);
        ITime time2False = new Time(2015, 5, 5, 5, 10);
        TimeSpan2 instance2 = new TimeSpan2(time1False, time2False);
        boolean expResultFalse = false;
        boolean resultFalse = instance.isPartOf(timeSpanFalse);
        assertEquals(expResultFalse, resultFalse);
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = tsTest;
        ITime time1 = new Time(2014, 10, 10, 20, 25);
        ITime time2 = new Time(2015, 5, 5, 5, 4);
        TimeSpan2 instance = new TimeSpan2(time1, time2);
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
        ITimeSpan timeSpan = tsTest;
        TimeSpan2 instance = tsTest;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
    }
    
}
