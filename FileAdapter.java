import java.util.List;

//interface for many file types
interface FileAdapter {
    List<String> readData(String filePath);
}

//concrete adapters for many file types
//Dias these adapters will work with csv, txt, json files, that'll be enough
//gpt: "implement the Adapter and Decorator design patterns for your assignment. Please note that this is a basic example, and in a real-world scenario, you would need to implement a more comprehensive solution."
//remove all the sus comments that might look like gpt but not these ones on top like "//interface for many file types"
class TxtFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        // Read data from a .txt file
        // Implement the actual logic here
        return null;
    }
}

class CsvFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        // Read data from a .csv file
        // Implement the actual logic here
        return null;
    }
}

class JsonFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        // Read data from a .json file
        // Implement the actual logic here
        return null;
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
