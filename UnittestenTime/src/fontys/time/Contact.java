/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Rick van Duijnhoven
 */
public class Contact {
    
    /**
     * Name of contact.
     */
    
    private String name;
    
    /**
     * List of appointments
     */
    
    private List<Appointment> appointments;
    
    /**
     * Constructor which creates a new contact with the given name.
     * Also creates an appointment list for this person.
     * @param name of contact.
     */
    
    public Contact(String name)
    {
        if (name == null || name.equals(""))
        {
            throw new IllegalArgumentException("Name cannot be nothing");
        }
        this.name = name;
        appointments = new ArrayList<>();
    }
    
    /**
     * Method to return the name
     * @return the name of the contact.
     */
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Add a new appointment. Check for:
     * Appointment cannot overlap with another.
     * End time must be earlier than begin time.
     * @param a is a given appointment.
     * @return true or false, depending on if appointment was added or not.
     */
    
    public boolean addApointment(Appointment a)
    {
        Iterator<Appointment> ap = this.appointments();
        while(ap.hasNext())
        {
            Appointment t = ap.next();
            if(t.equals(a))
                return false;
            
            ITimeSpan time = t.getTimeSpan();
            ITimeSpan duration = a.getTimeSpan();
            
            //Given time falls inside time of another appointment
            if(duration.getBeginTime().difference(time.getBeginTime()) <= 0
                    && duration.getEndTime().difference(time.getEndTime()) >= 0)
                return false;
            
            //Given begin time is in another appointment.
            if(duration.getBeginTime().difference(time.getBeginTime()) >= 0
                    && duration.getBeginTime().difference(time.getBeginTime()) < 0)
                return false;
            
            //Given end time is in another appointment.
            if(duration.getEndTime().difference(time.getBeginTime()) > 0
                    && duration.getEndTime().difference(time.getEndTime()) < 0)
                return false;
        }
        appointments.add(a);
        return true;
    }
    
    /**
     * Remove an appointment.
     * @param a is the given appointment.
     */
    
    public void removeAppointment(Appointment a)
    {
        if (a == null)
            throw new IllegalArgumentException("Appointment cannot be null.");
        appointments.remove(a);
    }
    /**
     * Get all appointments through an iterator.
     * @return an iterator of appointments.
     */
    
    public Iterator<Appointment> appointments()
    {
        return appointments.iterator();
    }
}
