import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create instances of adapters
        FileAdapter txtAdapter = new TxtFileAdapter();
        FileAdapter csvAdapter = new CsvFileAdapter();
        FileAdapter jsonAdapter = new JsonFileAdapter();

        //Create a data aggregator
        DataAggregator aggregator = new DataAggregator();

        //Agregate data from many files
        aggregator.aggregateData(txtAdapter, "test1.txt");
        aggregator.aggregateData(csvAdapter, "test2.csv");
        aggregator.aggregateData(jsonAdapter, "test3.json");

        //Get agregated data
        List<String> aggregatedData = aggregator.getAggregatedData();

        //Print the agregated data for checking
        System.out.println("Aggregated Data:");
        for (String line : aggregatedData) {
            System.out.println(line);
        }

        String secretKey = "Your16ByteKey123";

        DataDecorator encryptionDecorator = new EncryptionDecorator(secretKey);
        aggregatedData = encryptionDecorator.decorateData(aggregatedData);

        DataDecorator encodingDecorator = new EncodingDecorator();
        aggregatedData = encodingDecorator.decorateData(aggregatedData);

        //Create OutputWriter and show the final data
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.writeData(aggregatedData);
    }
}
