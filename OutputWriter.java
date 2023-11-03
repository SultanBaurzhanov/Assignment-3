import java.util.List;

public class OutputWriter {
    public void writeData(List<String> data) {
        System.out.println("Outputting data:");
        for (String line : data) {
            System.out.println(line);
        }
    }

}

