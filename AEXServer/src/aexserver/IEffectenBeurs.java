/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juleskreutzer
 */
public interface IEffectenBeurs extends Remote {
    public List<IFonds> getKoersen() throws RemoteException;
    
}
