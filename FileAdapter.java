import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.List;

//interface for many file types
interface FileAdapter {
    List<String> readData(String filePath) throws IOException;
}

//concrete adapters for many file types
class TxtFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .txt file
        return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
    }
}

class CsvFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .csv file
        return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
    }
}

class JsonFileAdapter implements FileAdapter {
   @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .json file
        return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
    }
}

//Data aggregation
class DataAggregator {
    private List<String> aggregatedData;

    public void aggregateData(FileAdapter adapter, String filePath) {
        // Use the provided adapter to read and aggregate data
        aggregatedData = adapter.readData(filePath);
    }

    public List<String> getAggregatedData() {
        return aggregatedData;
    }
}
