/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author juleskreutzer
 */
public class BeursServer {
    private Registry reg;
    private MockEffectenbeurs beurs;
    
    private BeursServer() throws RemoteException
    {
        reg = LocateRegistry.createRegistry(1099);
        beurs = new MockEffectenbeurs();
        reg.rebind("beurs", beurs);
    }
    /**
     * @param args
     * @throws RemoteException Throws RemoteException when something went wrong
     */
    public static void main(String[] args) throws RemoteException
    {
        BeursServer server = null;
        try
        {
            server = new BeursServer();
            server.start();
            Scanner s = new Scanner(System.in);
            System.out.println("Hit q to stop! :D");
            while(!s.nextLine().equals("q"))
            {
                System.out.println("I said q, not that, smartass");
            }
            server.stop();
        }
        catch (RemoteException ex)
        {
            System.out.println(ex);
        }
       
    }
    
    public void start()
    {
        System.out.println("Starting server.");
        ((MockEffectenbeurs) beurs).timerStart();
    }
    
    public void stop()
    {
        ((MockEffectenbeurs) beurs).stopTimer();
    }
}
