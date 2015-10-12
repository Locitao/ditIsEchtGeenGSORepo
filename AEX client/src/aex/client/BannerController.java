/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import aex.IEffectenBeurs;
import aex.IFonds;
import aex.MockEffectenbeurs;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
/**
 *
 * @author juleskreutzer
 */
public class BannerController {
    private AEXBanner banner;
    private IEffectenBeurs effectenbeurs;
    private Timer pollingTimer;

    public BannerController(AEXBanner banner) {

        this.banner = banner;
        this.effectenbeurs = new MockEffectenbeurs();

        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        pollingTimer.schedule(new UpdateTasks(this.banner, this.effectenbeurs), 0, 2000);
    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
        // TODO
    }
    
    /**
     * Static class to use in a timertask in this class
     */
    static class UpdateTasks extends TimerTask
    {
        AEXBanner banner;
        IEffectenBeurs beurs;
        
        public UpdateTasks(AEXBanner banner, IEffectenBeurs beurs)
        {
            this.banner = banner;
            this.beurs = beurs;
        }
        
        @Override
        public void run()
        {
            StringBuilder builder = new StringBuilder();
            
            for (IFonds f : beurs.getKoersen())
            {
                builder.append(String.format("%s %02.2f \t", f.getName(), f.getKoers()));
            }
            
            Platform.runLater(() -> {
                banner.setKoersen(builder.toString().trim());
            });
        }
    }

}
