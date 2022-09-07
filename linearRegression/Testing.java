package linearRegression;

import java.util.Map;

import sets.MySet;

public class Testing extends LinearRegression {
    
    public Testing(LinearFunction h, MySet s) {
        super(h, s);
    }

    @Override
    public LinearRegression run() {
        int m = set.length();
        double dsum = 0;

        if (writer == null)
            writer = new MyWriter("test-output.txt");

        for (Map.Entry<Double, Double> entry : set.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            dsum += hypothesis.at(x) - y;
        }

        String error = formatter.format(100.0 - Math.abs(dsum) / m);

        writer.write("Hypothesis Function: " + hypothesis.toString());
        writer.write("Target Function: " + set.targetToString());
        writer.write("Model handled test set with " + error + "% accuracy.\n");
        writer = writer.close();
        
        return this;
    }
}
