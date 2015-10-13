/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexserver;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author juleskreutzer
 */
public class AEXServer extends UnicastRemoteObject implements IEffectenBeurs {

    private boolean createRegistry = false;
    private int portNumber = 1099;
    private String bindingName = "AEX";
    private Registry registry = null;
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) throws RemoteException {
        // Create registry
        this.registry = createRegistry(this.portNumber);
        // Make AEX available by binding it to registry
        bindAEXBanner();
    }
    
    /**
     * Create a new registry instance
     * @param portNumber - Registry will listen to the given portnumber
     * @return Registry instance
     * @throws RemoteException 
     */
    private Registry createRegistry(int portNumber) throws RemoteException
    {
        try{
            return LocateRegistry.createRegistry(this.portNumber);
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        return null;
    }
    
    private void bindAEXBanner() throws RemoteException
    {
        try{
            IEffectenBeurs beurs = new IEffectenBeurs() {

                @Override
                public List<IFonds> getKoersen() throws RemoteException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            registry.rebind(bindingName, this);
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
    }

    @Override
    public List<IFonds> getKoersen() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
