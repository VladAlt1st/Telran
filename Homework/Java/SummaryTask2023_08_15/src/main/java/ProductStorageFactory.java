import db.ProductStorage;
import parser.IReportParser;

public class ProductStorageFactory {
    private final ProductStorage productStorage;

    public ProductStorageFactory(String filePath, IReportParser reportParser) {
        checkParserIsNull(reportParser);
        productStorage = new ProductStorage(reportParser.parseReport(filePath));
    }

    public ProductStorage getProductStorage() {
        return productStorage;
    }

    private void checkParserIsNull(IReportParser reportParser) {
        if (reportParser == null) {
            throw new IllegalArgumentException("parser is null");
        }
    }
}