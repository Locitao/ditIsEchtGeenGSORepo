/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import aex.IEffectenBeurs;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author juleskreutzer
 */
public class BeursServer {
    private static Registry reg;
    
    
    /**
     * First we try to create a new Registry, than we bind the "Beurs" so clients can make a call to it
     * @param args
     * @throws RemoteException Throws RemoteException when something went wrong
     */
    public static void main(String[] args) throws RemoteException
    {
        try{
            // Create a new registry with the default port, 1099
            reg = LocateRegistry.createRegistry(1099);
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        
        try{
            IEffectenBeurs beurs = (IEffectenBeurs) new MockEffectenbeurs();
            reg.rebind("Beurs", beurs);
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        
        
    }
    
}
