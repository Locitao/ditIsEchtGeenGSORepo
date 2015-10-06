/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author juleskreutzer
 */
class MockEffectenbeurs implements IEffectenBeurs {

    private List<IFonds> ifondsen;
    public MockEffectenbeurs() {
        ifondsen = new ArrayList<>();
        
        /**
         * Generate IFonds objects
         */
        generate();
    }

    private void generate()
    {
        String[] namen = {"Shell", "KLM", "DAX"};
        for(int i = 0; i <= 3; i++)
        {
            double d = ThreadLocalRandom.current().nextInt(1,101);
            Koers k = new Koers(namen[i], d); 
            ifondsen.add(k);
        }
           
        }

    @Override
    public List<IFonds> getKoersen() {
        return this.ifondsen;
    }
        
    }

    
    
    class Koers implements IFonds{
        private String name;
        private Double value;
        
        public Koers(String name, Double value)
        {
            this.name = name;
            this.value = value;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public double getKoers() {
            return this.value;
        }
        
        
       
}


