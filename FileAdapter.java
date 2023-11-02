import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Interface for many file types
interface FileAdapter {
    List<String> readData(String filePath) throws IOException;
}

// Concrete adapters for many file types
class TxtFileAdapter implements FileAdapter {
   @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .txt file
        try {
            return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception for proper error handling
        }
    }
}

class CsvFileAdapter implements FileAdapter {
    @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .csv file
        try {
            return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception for proper error handling
        }
    }
}

class JsonFileAdapter implements FileAdapter {
   @Override
    public List<String> readData(String filePath) throws IOException {
        // Read data from a .json file
        try {
            return Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception for proper error handling
        }
    }
}

// Data aggregation
class DataAggregator {
    private List<String> aggregatedData;

    public void aggregateData(FileAdapter adapter, String filePath) throws IOException {
        try {
            // Use the provided adapter to read and aggregate data
            aggregatedData = adapter.readData(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception for proper error handling
        }
    }

    public List<String> getAggregatedData() {
        return aggregatedData;
    }
}

// Main application logic
// public class Main {
//     public static void main(String[] args) {
//         // Sample usage with error handling and user choices
//         DataAggregator aggregator = new DataAggregator();

//         try {
//             // User's choices
//             boolean userChoosesEncryption = true;
//             boolean userChoosesEncoding = true;

//             // Example usage with TxtFileAdapter for a .txt file
//             FileAdapter txtAdapter = new TxtFileAdapter();
//             aggregator.aggregateData(txtAdapter, "sample.txt");

//             List<String> aggregatedData = aggregator.getAggregatedData();

//             // Apply decorators based on user choice
//             if (userChoosesEncryption) {
//                 DataDecorator encryptionDecorator = new EncryptionDecorator();
//                 aggregatedData = encryptionDecorator.decorateData(aggregatedData);
//             }

//             if (userChoosesEncoding) {
//                 String encoding = "UTF-16";
//                 DataDecorator encodingDecorator = new EncodingDecorator(encoding);
//                 aggregatedData = encodingDecorator.decorateData(aggregatedData);
//             }

//             // Process the aggregated and decorated data
//             for (String line : aggregatedData) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             // Handle file reading exceptions
//             System.err.println("An error occurred while reading data from files: " + e.getMessage());
//         }
//     }
// }
