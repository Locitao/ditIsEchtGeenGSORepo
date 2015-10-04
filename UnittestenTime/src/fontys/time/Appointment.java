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
 * @author Jules Kreutzer
 * @author Rick van Duijnhoven added some empty methods to program Contact.java
 */
public class Appointment {
    /**
     * Duration of appointment.
     */
    private ITimeSpan duration;
    
    /**
     * Subject of appointment.
     */
    private String subject;
    
    /**
     * List of contacts invited to appointment.
     */
    private List<Contact> invitedPeople;
    /**
     * 
     * @param subject of the appointment.
     * @param timeSpan Duration of the appointment.
     */
    
    public Appointment(String subject, ITimeSpan timeSpan)
    {
        if (subject == null || timeSpan == null)
            throw new IllegalArgumentException("Neither subject nor timeSpan can be null");
        
        this.invitedPeople = new ArrayList<>();
        this.duration = timeSpan;
        this.subject = subject;
    }
    
    /**
     * 
     * @return the duration of the appointment. 
     */
    public ITimeSpan getTimeSpan()
    {
        return duration;
    }
    
    /**
     * 
     * @return the subject of the appointment.
     */
    public String getSubject()
    {
        return subject;
    }
    /**
     * 
     * @return Iterator of all contacts of appointment.
     */
    public Iterator<Contact> invited()
    {
        return invitedPeople.iterator();
    }
    /**
     * Adds a new contact to invitees
     * @param c is the contact to be added.
     * @return true if succeeded; false if not.
     */
    public boolean addContact(Contact c)
    {
        if (!c.addAppointment(this))
            return false;
        
        invitedPeople.add(c);
        return true;
    }
    /**
     * Removes the given contact from invitees
     * @param c the given contact.
     */
    public void removeContact(Contact c)
    {
        if(invitedPeople.contains(c))
            invitedPeople.remove(c);
    }
}
