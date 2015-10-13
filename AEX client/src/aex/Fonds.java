package aex;

import java.io.Serializable;


public class Fonds implements IFonds, Serializable {
    private String name;
    private double koers;
    
    public Fonds(String name, double koers)
    {
        this.name = name;
        this.koers = koers;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public double getKoers()
    {
        return koers;
    }
    
    public void setKoers(double koers)
    {
        this.koers = koers;
    }
}