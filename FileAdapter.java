import java.util.ArrayList;
import java.util.List;

//make FileAdapter interface to read many files
interface FileAdapter {
    List<String> readData(String filePath);
}

//Concrete adapters for specific files
class TxtFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        // reading a txt
        System.out.println("Reading data from a .txt file: " + filePath);
        // make it read the data
        List<String> data = new ArrayList<>();
        data.add("Txt data line 1");
        data.add("Txt data line 2");
        return data;
    }
}

class CsvFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        //Implement reading the data from a csv file
        System.out.println("Reading data from a .csv file: " + filePath);
        // make it read the data
        List<String> data = new ArrayList<>();
        data.add("Csv data line 1");
        data.add("Csv data line 2");
        return data;
    }
}

class JsonFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) {
        // Implement reading data from a json file
        System.out.println("Reading data from a .json file: " + filePath);
        // make it read the data
        List<String> data = new ArrayList<>();
        data.add("Json data line 1");
        data.add("Json data line 2");
        return data;
    }
}

// Data Aggregator
class DataAggregator {
    private List<String> aggregatedData = new ArrayList<>();

    public void aggregateData(FileAdapter adapter, String filePath) {
        //Use the given adapter to read AND agregate data
        List<String> data = adapter.readData(filePath);
        aggregatedData.addAll(data);
    }

    public List<String> getAggregatedData() {
        return aggregatedData;
    }
}
