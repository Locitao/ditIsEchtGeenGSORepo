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
 * @author Rick van Duijnhoven, basic setup
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
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveAppointment() {
        contact.removeAppointment(app);
        contact.removeAppointment(app);
    }

    /**
     * Test of appointments method, of class Contact.
     */
    @Test
    public void testAppointments() {
        Appointment a = new Appointment("Afspraak 1", new TimeSpan(new Time(2015, 05, 19, 0, 0), new Time(2015,05,19,0,30)));
        Appointment b = new Appointment("Afspraak 2", new TimeSpan(new Time(2015, 05, 19, 1, 0), new Time(2015,05,19,1,30)));
        Appointment c = new Appointment("Afspraak 3", new TimeSpan(new Time(2015, 05, 19, 2, 0), new Time(2015,05,19,2,30)));
        Appointment d = new Appointment("Afspraak 4", new TimeSpan(new Time(2015, 05, 19, 3, 0), new Time(2015,05,19,3,30)));
        contact.addAppointment(a);
        contact.addAppointment(b);
        contact.addAppointment(c);
        contact.addAppointment(d);
        

        Iterator<Appointment> apps = contact.appointments();
        while(apps.hasNext()) {
            if(!(apps.next() instanceof Appointment)) {
                fail("Should be an appointment");
                return;
            }
        }
    }
    
}
