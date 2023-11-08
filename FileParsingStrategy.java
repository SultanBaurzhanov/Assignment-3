import java.util.ArrayList;
import java.util.List;

interface FileParsingStrategy {
    List<String> parseFile(String filePath);
}

//concrete strategies for 3 file types
class TxtFileParsingStrategy implements FileParsingStrategy {
    @Override
    public List<String> parseFile(String filePath) {
        System.out.println("Parsing data from a .txt file: " + filePath);
        //read data
        List<String> data = new ArrayList<>();
        data.add("Txt data line 1");
        data.add("Txt data line 2");
        return data;
    }
}

class CsvFileParsingStrategy implements FileParsingStrategy {
    @Override
    public List<String> parseFile(String filePath) {
        System.out.println("Parsing data from a .csv file: " + filePath);
        List<String> data = new ArrayList<>();
        data.add("Csv data line 1");
        data.add("Csv data line 2");
        return data;
    }
}

class JsonFileParsingStrategy implements FileParsingStrategy {
    @Override
    public List<String> parseFile(String filePath) {
        System.out.println("Parsing data from a .json file: " + filePath);
        List<String> data = new ArrayList<>();
        data.add("Json data line 1");
        data.add("Json data line 2");
        return data;
    }
}

// DataAggregator
class DataAggregator {
    private List<String> aggregatedData = new ArrayList<>();

    public void aggregateData(FileParsingStrategy strategy, String filePath) {
        //parse and aggregate data with strat pattern
        List<String> data = strategy.parseFile(filePath);
        aggregatedData.addAll(data);
    }

    public List<String> getAggregatedData() {
        return aggregatedData;
    }
}

