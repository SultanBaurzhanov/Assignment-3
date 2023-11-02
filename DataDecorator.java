import java.util.List;

//interface for data decorators
interface DataDecorator {
    List<String> decorateData(List<String> data);
}

//Concrete decorators
class EncryptionDecorator implements DataDecorator {
    @Override
    public List<String> decorateData(List<String> data) {
        // Add encryption logic here
        return data; // Placeholder, implement encryption
    }
}

class EncodingDecorator implements DataDecorator {
    @Override
    public List<String> decorateData(List<String> data) {
        // Add character encoding logic here
        return data; // Placeholder, implement encoding
    }
}

//Client code to apply decorators
DataAggregator aggregator = new DataAggregator();

//Assuming you have already aggregated data from files
List<String> aggregatedData = aggregator.getAggregatedData();

//Apply decorators based on user choice
if (userChoosesEncryption) {
    DataDecorator encryptionDecorator = new EncryptionDecorator();
    aggregatedData = encryptionDecorator.decorateData(aggregatedData);
}

if (userChoosesEncoding) {
    DataDecorator encodingDecorator = new EncodingDecorator();
    aggregatedData = encodingDecorator.decorateData(aggregatedData);
}

//Now the aggregated data has been decorated as per user's choice
