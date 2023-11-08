import java.util.List;

public class Main {
    public static void main(String[] args) {
        //instances of file parsing strategies
        FileParsingStrategy txtParsingStrategy = new TxtFileParsingStrategy();
        FileParsingStrategy csvParsingStrategy = new CsvFileParsingStrategy();
        FileParsingStrategy jsonParsingStrategy = new JsonFileParsingStrategy();

        //data aggregator here
        DataAggregator aggregator = new DataAggregator();

        // Aggregate data from many files using the strat pattern

        aggregator.aggregateData(txtParsingStrategy, "test1.txt");
        aggregator.aggregateData(csvParsingStrategy, "test2.csv");
        aggregator.aggregateData(jsonParsingStrategy, "test3.json");

        // Get aggregated data
        List<String> aggregatedData = aggregator.getAggregatedData();

        // Print the gained data for checking
        System.out.println("Aggregated Data:");
        for (String line : aggregatedData) {
            System.out.println(line);
        }

        String secretKey = "BIGSHOT";

        DataDecorator encryptionDecorator = new EncryptionDecorator(secretKey);
        aggregatedData = encryptionDecorator.decorateData(aggregatedData);

        DataDecorator encodingDecorator = new EncodingDecorator();
        aggregatedData = encodingDecorator.decorateData(aggregatedData);

        // Create OutputWriter / show the final data
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.writeData(aggregatedData);
    }
}
