/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rick van Duijnhoven
 */
public class ContactTest {
    
    private Contact contact;
    
    @Before
    public void setUp()
    {
        contact = new Contact("Rick");
    }
    
    /**
     * Test constructor, when null or empty should return IllegalArgumentException.
     */

    @Test
    public void testConstructor()
    {
        Contact con = new Contact("Loci");
        assertNotNull("con can't be null", con);
        assertEquals("Name must be the same", "Loci", con.getName());
        
        try
        {
            con = new Contact("");
            fail("Name can't be empty");
        } catch (IllegalArgumentException ex) {}
        
        try
        {
            con = new Contact(null);
            fail("Name can't be null");
        } catch (IllegalArgumentException ex) {}
    }
    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        assertEquals("name should be the same", "Rick", contact.getName());
        assertFalse("Names should not be the same", contact.getName().equals("Rick"));
    }

    /**
     * Test of addApointment method, of class Contact.
     */
    @Test
    public void testAddApointment() {
        boolean setAppointment = false;
        Appointment appA = new Appointment("App 1", new TimeSpan2(new Time(2015, 04, 19, 0, 0), 60));
        Appointment appB = new Appointment("App 2", new TimeSpan2(new Time(2015, 04, 19, 0, 0), 60));
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointment() {
        System.out.println("removeAppointment");
        Appointment a = null;
        Contact instance = null;
        instance.removeAppointment(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of appointments method, of class Contact.
     */
    @Test
    public void testAppointments() {
        System.out.println("appointments");
        Contact instance = null;
        Iterator<Appointment> expResult = null;
        Iterator<Appointment> result = instance.appointments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
