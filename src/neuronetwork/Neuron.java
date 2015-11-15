/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronetwork;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John H. Goettsche
 */
public class Neuron {
    private List<Synapse> back = new ArrayList();
    private List<Synapse> forward = new ArrayList();
    private double signal, adjust;
    
    public void registerBackSynapse(Synapse s) {
        back.add(s);
    }
    
    public void removeBackSynapse(Synapse s) {
        back.remove(s);
    }
    
    public void registerForwardSynapse(Synapse s) {
        forward.add(s);
    }
    
    public void removeForwardSynapse(Synapse s) {
        forward.remove(s);
    }
    
    public void getSignal(double sig) {
        signal += sig;
    }
    
    public void clearSignal() {
        signal = 0;
    }
    
    public void sendSignals() {
        for(int i = 0; i < forward.size(); i++) {
            forward.get(i).notifyNeuron(signal);
        }
    }
    
    public void adjustWeights() {
        double sum = 0;
        for(int i = 0; i < back.size(); i++) {
            sum += back.get(i).getWeight();
        }
        for(int i = 0; i < back.size(); i++) {
            back.get(i).setWeight(back.get(i).getWeight() / sum);
        }
    }
}


//notes
