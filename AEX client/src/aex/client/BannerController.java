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
import aex.UpdateTask;
import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import static java.util.Collections.list;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
/**
 *
 * @author juleskreutzer
 */
public class BannerController extends UnicastRemoteObject implements RemotePropertyListener {
    private AEXBanner banner;
    private IEffectenBeurs effectenbeurs;
    private Timer pollingTimer;

    public BannerController(AEXBanner banner) throws RemoteException {

        this.banner = banner;
        this.effectenbeurs = new MockEffectenbeurs();

        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        pollingTimer.schedule(new UpdateTask(this.banner, this.effectenbeurs), 0, 2000);
    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
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
