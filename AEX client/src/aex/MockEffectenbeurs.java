/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author juleskreutzer
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenBeurs, Serializable {
    private List<IFonds> ifondsen;
    private Timer timer;
    private Random random;

 
    public MockEffectenbeurs(List<IFonds>  fonds) throws RemoteException {
        ifondsen = fonds;
        this.timer = new Timer();
        this.random = new Random();
        timerStart();
    }
    
    /**
     * Create a new registery
     * @param number port number which the registry uses
     * @return instance of registry
     */
    private Registry createRegistry(int number)
    {
        try{
            Registry reg = LocateRegistry.createRegistry(number);
            return reg;
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        return null;
    }
    
    public MockEffectenbeurs() throws RemoteException
    {
        List<IFonds> fondsen = new ArrayList<>();
        fondsen.add(new Fonds("Rick", 420));
        fondsen.add(new Fonds("Jules", 180));
        fondsen.add(new Fonds("Test fonds", 120));
        
        this.ifondsen = fondsen;
        this.timer = new Timer();
        this.random = new Random();
        timerStart();
    }

    /**
     * Every 2.5 seconds, refreshes all courses with a new value.
     */
    private void timerStart()
    {
        this.timer.schedule(new TimerTask()
                {
                    @Override
                    public void run() {
                        for(IFonds f : ifondsen)
                            ((Fonds) f).setKoers(random.nextDouble() + random.nextInt(25));
                    }
                }, 0, 2500);
    }
    
    public void stopTimer()
    {
        this.timer.cancel();
    }
    
    @Override
    public List<IFonds> getKoersen() {
        return Collections.unmodifiableList(ifondsen);
    }
    
    
       
}