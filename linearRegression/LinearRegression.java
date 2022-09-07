package linearRegression;

import java.text.DecimalFormat;

import sets.*;

public abstract class LinearRegression {

    protected MySet set;
    protected MyWriter writer;
    protected LinearFunction hypothesis;
    protected DecimalFormat formatter;

    public LinearRegression(LinearFunction h, MySet s) {
        set = s;
        hypothesis = h;
        formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(4);
    }

    public abstract LinearRegression run();
    public LinearRegression setPrecision(int precision) {
        formatter.setMaximumFractionDigits(precision);
        hypothesis.setPrecision(precision);
        return this;
    }
    public LinearRegression setOutputFile(String path) {
        writer = new MyWriter(path);
        return this;
    }
}