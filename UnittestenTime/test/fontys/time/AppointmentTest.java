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
    
    
    
    @Before
    public void setUp() {
        app = new Appointment("Test", new TimeSpan(new Time(2015,01,01,1,0), new Time(2015,01,01,2,0)));
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
        System.out.println("getTimeSpan");
        Appointment instance = app;
        ITimeSpan expResult = new TimeSpan(new Time(2015,01,01,1,0), new Time(2015,01,01,2,0));
        ITimeSpan result = instance.getTimeSpan();
        assertThat(expResult, is(result));
        
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
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contact);
        contacts.add(contact2);
        Iterator<Contact> expResult = contacts.iterator();
        Iterator<Contact> result = instance.invited();
        assertThat(expResult, is(result));
        
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
    @Test(expected=NullPointerException.class)
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact c = contact;
        Appointment instance = appWithContact;
        
        instance.removeContact(c);
    }
    
}
