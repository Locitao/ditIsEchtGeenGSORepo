/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import aex.IEffectenBeurs;
import aex.IFonds;
import aex.MockEffectenbeurs;
import aex.RemotePropertyListener;
import aex.RemotePublisher;
//import aex.UpdateTask;
import java.beans.PropertyChangeEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import static java.util.Collections.list;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
/**
 *
 * @author juleskreutzer
 */
public class BannerController implements RemotePropertyListener {
    private AEXBanner banner;
    private Registry reg;

    public BannerController(AEXBanner banner) throws RemoteException {

        this.banner = banner;
        this.reg = LocateRegistry.getRegistry(1099);
        
        try {
            ((RemotePublisher) reg.lookup("beurs")).addListener(this, "koersen");
        } catch (NotBoundException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Start polling timer: update banner every two seconds
        // pollingTimer = new Timer();
        // pollingTimer.schedule(new UpdateTask(this.banner, this.effectenbeurs), 0, 2000);
    }

    // Stop banner controller
    public void stop() {
  //      pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
        // TODO
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException {
        switch(evt.getPropertyName())
        {
            case "koersen":
                UpdateKoers((List<IFonds>) evt.getNewValue());
                break;
            default:
                System.out.print("PropertyName is not recognized!");
        }
    }
    
    private void UpdateKoers(List<IFonds> fondsen) throws RemoteException
    {
        String koersen = "";
        for(IFonds fonds : fondsen)
        {
            koersen += " " + fonds.getName() + " " + String.format("%1$-7s", fonds.getKoers());
        }
        
        banner.setKoersen(koersen);
    }
}
