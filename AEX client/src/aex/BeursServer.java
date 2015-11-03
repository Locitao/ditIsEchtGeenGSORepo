/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import aex.IEffectenBeurs;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author juleskreutzer
 */
public class BeursServer {
    private Registry reg;
    private BasicPublisher basicPublisher;
    private MockEffectenbeurs beurs;
    
    // Create a new constructor because "this" can't be used in basicPublisher.inform()
    private BeursServer() throws RemoteException
    {
        reg = LocateRegistry.createRegistry(1099);
        beurs = new MockEffectenbeurs();
        reg.rebind("beurs", beurs);
        
        basicPublisher = new BasicPublisher(new String[]{
            "koersen"
        });
        
        basicPublisher.inform(this, "koersen", null, beurs.getKoersen());
    }
    /**
     * @param args
     * @throws RemoteException Throws RemoteException when something went wrong
     */
    public static void main(String[] args) throws RemoteException
    {
        try{
            // Create a new registry with the default port, 1099
//            reg = LocateRegistry.createRegistry(1099);
//            reg.bind("beurs", beurs);
            new BeursServer();
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
    }
}
