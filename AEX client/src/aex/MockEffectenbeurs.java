/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author juleskreutzer
 */
public class MockEffectenbeurs implements IEffectenBeurs {

    private List<IFonds> ifondsen;
    private Timer timer;
    private Random random;

    public MockEffectenbeurs(List<IFonds>  fonds) {
        ifondsen = fonds;
        this.timer = new Timer();
        this.random = new Random();
        timerStart();
    }
    
    public MockEffectenbeurs()
    {
        List<IFonds> fondsen = new ArrayList<>();
        fondsen.add(new Fonds("Rick", 420));
        fondsen.add(new Fonds("Jules", 180));
        fondsen.add(new Fonds("testFondsPleaseIgnore", 120));
        
        this.ifondsen = fondsen;
        this.timer = new Timer();
        this.random = new Random();
        timerStart();
    }

    /**
     * Every 2.5 seconds, refreshes all courses with a new value.
     */
    private void timerStart()
    {
        this.timer.schedule(new TimerTask()
                {
                    @Override
                    public void run() {
                        for(IFonds f : ifondsen)
                            ((Fonds) f).setKoers(random.nextDouble() + random.nextInt(25));
                    }
                }, 0, 2500);
    }
    
    public void stopTimer()
    {
        this.timer.cancel();
    }
    
//    private void generate()
//    {
//        String[] namen = {"Shell", "KLM", "DAX"};
//        for(int i = 0; i <= 3; i++)
//        {
//            double d = ThreadLocalRandom.current().nextInt(1,101);
//            Koers k = new Koers(namen[i], d); 
//            ifondsen.add(k);
//        }
//           
//        }

    @Override
    public List<IFonds> getKoersen() {
        return Collections.unmodifiableList(ifondsen);
    }
       
}

    
    
//    class Koers implements IFonds{
//        private String name;
//        private Double value;
//        
//        public Koers(String name, Double value)
//        {
//            this.name = name;
//            this.value = value;
//        }
//
//        @Override
//        public String getName() {
//            return this.name;
//        }
//
//        @Override
//        public double getKoers() {
//            return this.value;
//        }
//        
//        
       



