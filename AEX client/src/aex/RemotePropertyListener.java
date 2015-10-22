/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.EventListener;
/**
 *
 * @author rick
 */
public interface RemotePropertyListener extends EventListener, Remote {
    void propertyChange(PropertyChangeEvent evt) throws RemoteException;
}