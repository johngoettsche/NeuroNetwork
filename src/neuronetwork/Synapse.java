/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronetwork;

/**
 *
 * @author John H. Goettsche
 */
public class Synapse {    
    private Neuron source;
    private Neuron destination;
    private double weight;
    
    Synapse() {
        weight = 1.0;
    }
    
    public void notifyNeuron(double signal) {
        destination.getSignal(signal * weight);
    }
    
    public void setWeight(double w) {
        weight = w;
    }
    
    public double getWeight() {
        return weight;
    }
}

