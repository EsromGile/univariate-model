package linearRegression;
import java.text.DecimalFormat;

public class LinearFunction {

    private double w0;
    private double w1;
    private DecimalFormat formatter;

    public LinearFunction(double w0, double w1) {
        formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(4);
        this.w0 = w0;
        this.w1 = w1;
    }

    public double at(double x) {
        return w0 + (x * w1);
    }

    public String toString() {
        String w0_return = formatter.format((Double) w0);
        String w1_return = formatter.format((Double) w1);
        return "h(x) = " + w1_return + "x + " + w0_return + "\n";
    }
    
    public double getW0() { return w0; }
    public double getW1() { return w1; }
    
    public void setPrecision(int precision) {
        formatter.setMaximumFractionDigits(precision);
    }

    public void setWeights(double weight0, double weight1) {
        this.w0 = weight0;
        this.w1 = weight1;
    }
}
