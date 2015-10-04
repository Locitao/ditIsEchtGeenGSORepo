/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author juleskreutzer
 */
public class AppointmentTest {
    
    Appointment app;
    Contact contact;
    Contact contact2;
    Appointment appWithContact;
    Time t1, t2;
    TimeSpan ts;
    
    
    
    @Before
    public void setUp() {
        t1 = new Time(2014,01,01,1,1);
        t2 = new Time(2015,01,01,1,1);
        ts = new TimeSpan(t1, t2);
        app = new Appointment("Test", ts);
        contact = new Contact("Jules");
        contact2 = new Contact("Rick");
        appWithContact = app;
        appWithContact.addContact(contact);
    }
    
    

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        assertThat("Should be equal to ts", ts, is(app.getTimeSpan()));        
    }

    /**
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Appointment instance = app;
        String expResult = "Test";
        String result = instance.getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of invited method, of class Appointment.
     */
    @Test
    public void testInvited() {
        System.out.println("invited");
        Appointment instance = app;
        app.addContact(contact);
        app.addContact(contact2);
        int size = 0;
        Iterator<Contact> result = instance.invited();
        while(result.hasNext()) {
            result.next();
            size++;
        }
        assertEquals("Should be 2", 2, size);

        
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        Contact c = contact2;
        Appointment instance = app;
        boolean expResult = true;
        boolean result = instance.addContact(c);
        assertEquals(expResult, result);
       
        boolean expResultFalse = false;
        boolean resultFalse = instance.addContact(c);
        assertEquals(expResultFalse, resultFalse);
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact c = contact;
        Appointment instance = appWithContact;
        
        instance.removeContact(c);
    }
    
}
