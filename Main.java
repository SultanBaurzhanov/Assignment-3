import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instances of file parsing strategies
        FileParsingStrategy txtParsingStrategy = new TxtFileParsingStrategy();
        FileParsingStrategy csvParsingStrategy = new CsvFileParsingStrategy();
        FileParsingStrategy jsonParsingStrategy = new JsonFileParsingStrategy();

        // Create a data aggregator
        DataAggregator aggregator = new DataAggregator();

        // Aggregate data from many files using the selected strategy
        aggregator.aggregateData(txtParsingStrategy, "test1.txt");
        aggregator.aggregateData(csvParsingStrategy, "test2.csv");
        aggregator.aggregateData(jsonParsingStrategy, "test3.json");

        // Get aggregated data
        List<String> aggregatedData = aggregator.getAggregatedData();

        // Print the aggregated data for checking
        System.out.println("Aggregated Data:");
        for (String line : aggregatedData) {
            System.out.println(line);
        }

        String secretKey = "Your16ByteKey123";

        DataDecorator encryptionDecorator = new EncryptionDecorator(secretKey);
        aggregatedData = encryptionDecorator.decorateData(aggregatedData);

        DataDecorator encodingDecorator = new EncodingDecorator();
        aggregatedData = encodingDecorator.decorateData(aggregatedData);

        // Create OutputWriter and show the final data
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.writeData(aggregatedData);
    }
}
