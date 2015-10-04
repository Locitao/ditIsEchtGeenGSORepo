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
        try {
            tsTest.changeLengthWith(0);
            Assert.fail("Should have thrown an exception");

        } catch (Exception e) {

        }
        Time t1Test = t1;
        t1Test.plus(60);
        TimeSpan2 tsTest2 = tsTest;
        tsTest2.setEndTime(t2.plus(60));
        tsTest.changeLengthWith(60);
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTest2, tsTest);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        Time testTime1Test = new Time(2015, 9, 27, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTestExtra = new TimeSpan2(testTime2Test, testTime1Test);
        assertEquals("Should be false", false, tsTest.isPartOf(tsTestExtra));
        
        Time testTime1Test2 = new Time(2014, 10, 29, 19, 20);
        Time testTime2Test2 = new Time(1900, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest2 = new TimeSpan2(testTime2Test2, testTime1Test2);
        assertEquals("must be false", false, tsTest.isPartOf(tsTimeSpanTest2));
        
        Time testTime1Test3 = new Time(2015, 10, 29, 19, 20);
        Time testTime2Test3 = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest3 = new TimeSpan2(testTime2Test3,testTime1Test3);
        assertEquals("Moet false zijn", false, tsTest.isPartOf(tsTimeSpanTest3));
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        Time testTime1Test = new Time(2015, 8, 29, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest = new TimeSpan2(t1,t2);
        assertEquals("Ze moeten gelijk aan elkaar zijn", tsTimeSpanTest.getBeginTime(), tsTest.unionWith(tsTimeSpanTest).getBeginTime());
        
        testTime1Test = new Time(2015, 9, 13, 19, 20);
        testTime2Test = new Time(2015, 8, 27, 19, 20);
        tsTimeSpanTest = new TimeSpan2(t1, t2);
        assertEquals("Moet gelijk zijn ", tsTimeSpanTest.getBeginTime().getDay(), tsTest.unionWith(tsTimeSpanTest).getBeginTime().getDay());
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        Time testTime1Test = new Time(2015, 8, 29, 19, 20);
        Time testTime2Test = new Time(2015, 8, 27, 19, 20);
        TimeSpan2 tsTimeSpanTest = new TimeSpan2(testTime2Test, testTime1Test);
        assertEquals("Must be the same", tsTimeSpanTest.getBeginTime().getDay(), tsTest.intersectionWith(tsTimeSpanTest).getBeginTime().getDay());
        
        
        testTime1Test = new Time(2019, 8, 29, 19, 20);
        testTime2Test = new Time(2012, 8, 27, 19, 20);
        tsTimeSpanTest = tsTest;
        tsTimeSpanTest.setBeginTime(testTime2Test);
        tsTimeSpanTest.setEndTime(testTime1Test);
        
        assertEquals("Should be null", null , tsTest.intersectionWith(tsTimeSpanTest));
    }
    
}
