/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import aex.RemotePropertyListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author rick
 */
public interface RemotePublisher extends Remote {
    void addListener(RemotePropertyListener listener, String property) throws RemoteException;
    void removeListener(RemotePropertyListener listener, String property) throws RemoteException;
    
}
