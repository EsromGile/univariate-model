package linearRegression;
import java.io.File;
import java.io.FileWriter;

public class MyWriter {
    private File file;
    private FileWriter writer;

    public MyWriter(String path) {
        file = new File(path);
        try {
            writer = new FileWriter(file);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void write(String str) {
        try{
            writer.write(str);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public MyWriter close() {
        try {
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
