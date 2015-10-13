/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import aex.client.AEXBanner;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author juleskreutzer
 */
public class UpdateTask extends TimerTask {
    private AEXBanner banner;
    private IEffectenBeurs beurs;
    private List<IFonds> fonsen;
    private Registry registry;
    public UpdateTask(AEXBanner banner, IEffectenBeurs beurs)
    {
        this.banner = banner;
        this.beurs = beurs;
    }

    @Override
    public void run()
    {
        try{
            // get the registry based on url (localhost) and port (1099 (Default port))
            registry = LocateRegistry.getRegistry("localhost", 1099);
            beurs = (IEffectenBeurs)registry.lookup("beurs");
        }
        catch(RemoteException ex)
        {
            System.out.print(ex.toString());
        }
        catch(Exception ex)
        {
            System.out.print(ex.toString());
        }
        
        String koersen = "";

        try {
            for (IFonds f : beurs.getKoersen())
            {
                koersen += f.getName() + " " + f.getKoers();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UpdateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        banner.setKoersen(koersen);
    }
}
