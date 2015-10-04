/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rick van Duijnhoven
 * @author Jules - Improved Unit Tests
 */
public class ContactTest {
    
    private Contact contact;
    Appointment app;
    Appointment app2;
    
    @Before
    public void setUp()
    {
        contact = new Contact("Rick");
        app = new Appointment("Test", new TimeSpan(new Time(2015,01,01,1,0), new Time(2015,01,01,2,0)));
        app2 = new Appointment("Test 2", new TimeSpan(new Time(2016,01,01,1,0), new Time(2016,01,01,2,0)));
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
    }

    /**
     * Test of addApointment method, of class Contact.
     */
    @Test
    public void testAddApointment() {
        boolean setAppointment = false;
        Appointment appA = new Appointment("App 1", new TimeSpan2(new Time(2015, 04, 19, 0, 0), new Time(2015, 04, 19, 1, 0)));
        Appointment appB = new Appointment("App 2", new TimeSpan2(new Time(2015, 04, 19, 0, 0), new Time(2015, 04, 19, 1, 0)));
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointment() {
        System.out.println("removeAppointment");
        Appointment a = app;
        Contact instance = contact;
        instance.addAppointment(a);
        instance.removeAppointment(a);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of appointments method, of class Contact.
     */
    @Test
    public void testAppointments() {
        System.out.println("appointments");
        Contact instance = contact;
        instance.addAppointment(app);
        instance.addAppointment(app2);
        ArrayList<Appointment> apps = new ArrayList<Appointment>();
        apps.add(app);
        apps.add(app2);
        ArrayList<Appointment> expResult = apps;
        Iterator<Appointment> result = instance.appointments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
