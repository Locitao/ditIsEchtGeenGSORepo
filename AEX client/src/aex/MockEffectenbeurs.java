/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author juleskreutzer
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements RemotePublisher {
    private List<IFonds> ifondsen;
    private Timer timer;
    private Random random;
    private BasicPublisher basicPublisher;

 
//    public MockEffectenbeurs(List<IFonds>  fonds) throws RemoteException {
//        ifondsen = fonds;
//        this.timer = new Timer();
//        this.random = new Random();
//        timerStart();
//        
////        basicPublisher = new BasicPublisher(new String[] {
////            "koersen"
////        });
//    }
    
    public MockEffectenbeurs() throws RemoteException
    {
        List<IFonds> fondsen = new ArrayList<>();
        fondsen.add(new Fonds("Rick", 420));
        fondsen.add(new Fonds("Jules", 180));
        fondsen.add(new Fonds("Test fonds", 120));
        
        basicPublisher = new BasicPublisher(new String[] {"koersen"});
        this.ifondsen = fondsen;
        this.timer = new Timer();
        this.random = new Random();
        timerStart();
    }

    /**
     * Every 2.5 seconds, refreshes all courses with a new value.
     */
    public void timerStart()
    {
        this.timer.schedule(new TimerTask()
                {
                    @Override
                    public void run() {
                        ifondsen.stream().forEach((f) -> {
                            ((Fonds) f).setKoers(random.nextDouble() + random.nextInt(25));
                        });
                        basicPublisher.inform(this, "koersen", null, getKoersen());
                    }
                }, 0, 2500);
        
    }
    
    public void stopTimer()
    {
        this.timer.cancel();
    }
    
    public List<IFonds> getKoersen() {
        return Collections.unmodifiableList(ifondsen);
    }
//
//    @Override
//    public void addListener(RemotePropertyListener listener, String property) throws RemoteException {
//        basicPublisher.addListener(listener, property);
//    }
//
//    @Override
//    public void removeListener(RemotePropertyListener listener, String property) throws RemoteException {
//        basicPublisher.removeListener(listener, property);
//    }

    @Override
    public void addListener(RemotePropertyListener listener, String property) throws RemoteException {
        basicPublisher.addListener(listener,property);
    }

    @Override
    public void removeListener(RemotePropertyListener listener, String property) throws RemoteException {
        basicPublisher.removeListener(listener, property);
    }
    
}