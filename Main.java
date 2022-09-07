import linearRegression.*;
import sets.*;

class Main {
    public static void main(String args[]) {
        LinearFunction target = new LinearFunction(2, 7);
        LinearFunction hypothesis = new LinearFunction(1, 4);
        int precision = 4;

        var trainingSet = new MySet(target)
                .setMultiplier(1.5)
                .setNumberOfInputs(100)
                .generate();
        var training = new Training(hypothesis, trainingSet);
        training.setEpochs(1000000)
                .setAlpha(1e-5)
                .setError(1e-100)
                .setOutputFile("output.txt")
                .setPrecision(precision)
                .run();

        var testingSet = new MySet(target)
                .setMultiplier(5)
                .setNumberOfInputs(150)
                .generate();
        var testing = new Testing(hypothesis, testingSet);
        testing.setOutputFile("result-output.txt")
               .setPrecision(precision)
               .run();
    }
}