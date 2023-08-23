import entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import parser.IReportParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductStorageFactoryTest {
    @Mock
    private IReportParser reportParser;
    @Mock
    private List<Product> mockedList;

    @Test
    void testProductStorageFactoryInitializationInvokeParseReport() {
        String filePath = "somePath";
        Mockito.when(reportParser.parseReport(filePath)).thenReturn(mockedList);
        new ProductStorageFactory(filePath, reportParser);
        Mockito.verify(reportParser, Mockito.only()).parseReport(filePath);
    }

    @Test
    void testProductStorageFactoryTrowsExceptionWhenReportParserIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new ProductStorageFactory("somePath", null));
    }
}