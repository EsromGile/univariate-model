package sets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import linearRegression.LinearFunction;

public class MySet {
    protected int numberOfInputs;
    protected double multiplier;
    protected LinearFunction function;
    protected Map<Double, Double> set = new HashMap<>();

    public MySet(LinearFunction function) {
        this.function = function;
        this.numberOfInputs = 100;
        this.multiplier = 1;
    }

    public void printSet() {
        for (Map.Entry<Double, Double> entry : set.entrySet()) 
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
    public Set<Double> keySet() {
        return set.keySet();
    }
    public Set<Map.Entry<Double, Double>> entrySet() {
        return set.entrySet();
    }
    public String targetToString() {
        return function.toString();
    }
    public int length(){ 
        return set.size(); 
    }
    public MySet setNumberOfInputs(int inputs) {
        this.numberOfInputs = inputs;
        return this;
    }
    public MySet setMultiplier(double multiplier) {
        this.multiplier = multiplier;
        return this;
    }
    public MySet generate() {
        for (int i = 0; i < numberOfInputs; i++) {
            set.put((double) i * multiplier, (double) function.at(i) * multiplier);
        }
        return this;
    }
}
