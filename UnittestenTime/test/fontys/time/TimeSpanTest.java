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
 * NOT YET FINISHED
 */
public class TimeSpanTest {
    Time t1 = new Time(2014, 10, 10, 20, 20);
    Time t2 = new Time(2015, 5, 5, 5, 10);
    TimeSpan tsTest = new TimeSpan(t1, t2);

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
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        Time badTime = new Time(2016, 10, 10, 25, 25);
        try
        {
            TimeSpan ts = tsTest;
            ts.setBeginTime(badTime);
            fail("Should have thrown an exception.");
        } catch(Exception ex) {}
        
        Time goodTime = new Time(2015, 10, 13, 5, 5);
        TimeSpan ts = tsTest;
        ts.setBeginTime(goodTime);
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = null;
        TimeSpan instance = null;
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
