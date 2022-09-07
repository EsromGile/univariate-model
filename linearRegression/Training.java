package linearRegression;

import java.text.DecimalFormat;
import java.util.Map;

import sets.*;

public class Training extends LinearRegression {

    private int epochs;
    private double alpha;
    private double error;

    public Training(LinearFunction h, MySet s) {
        super(h, s);
        epochs = 100;
        alpha = 0.01;
        error = 1e-25;
    }
    
    @Override
    public LinearRegression run() {
        writer.write("Initial hypothesis: " + hypothesis.toString());

        int m = set.length();

        if (writer == null)
            writer = new MyWriter("output.txt");

        for (int i = 0; i < epochs; i++) {

            double loss_sum = 0;
            double w0_sum = 0;
            double w1_sum = 0;

            for (Map.Entry<Double, Double> entry : set.entrySet()) {
                double x = entry.getKey();
                double y = entry.getValue();
                w0_sum += hypothesis.at(x) - y;
                w1_sum += (hypothesis.at(x) - y) * x;
                loss_sum += Math.pow(hypothesis.at(x) - y, 2);
            }

            double loss = 0.5 * loss_sum / m;
            if (loss < error) {
                DecimalFormat lossFormat = new DecimalFormat("0.00E00");
                String lossStr = lossFormat.format(loss);
                writer.write(
                    "Loss of " + lossStr + " fell below error boundry of " + error + " at epoch " + i + ".\n"
                );
                break;
            }

            double dw0 = w0_sum / m * alpha;
            double dw1 = w1_sum / m * alpha;

            double w0_new = hypothesis.getW0() - dw0;
            double w1_new = hypothesis.getW1() - dw1;

            writer.write(
                "epoch" + (i + 1) + " => w1: " + w1_new + ", w0: " + w0_new + "\n"
            );

            hypothesis.setWeights(w0_new, w1_new);
        }

        writer.write("Final hypothesis: " + hypothesis.toString());
        writer = writer.close();

        return this;
    }

    public Training setAlpha(double alpha) {
        this.alpha = alpha;
        return this;
    }
    public Training setEpochs(int epochs) {
        this.epochs = epochs;
        return this;
    }
    public Training setError(double error) {
        this.error = error;
        return this;
    }
}
