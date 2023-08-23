package parser.impl;

import entity.Product;
import exception.CustomFileNotFoundException;
import exception.EmptyReportFileException;
import exception.InvalidReportFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.IReportParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TxtReportParserTest {
    private final IReportParser reportParser = new TxtReportParser();

    @ParameterizedTest
    @ValueSource(strings = {
            "D:/Telran/Homework/Java/SummaryTask2023_08_15/src/test/resources/validReport.txt",
            "src/test/resources/validReport.txt"
    })
    void testParseReportWithValidFilePathAndReportFormat(String filePath) {
        assertDoesNotThrow(() -> {
            List<Integer> expected = List.of(1, 3, 5, 11, 123);
            List<Product> actual = reportParser.parseReport(filePath);

            for (int i = 0; i < actual.size(); i++) {
                assertEquals(expected.get(i), actual.get(i).getId());
            }

            assertEquals("FOOD", actual.get(0).getCategory());
            assertEquals("Pasta", actual.get(0).getName());
            assertEquals("Barilla", actual.get(0).getFactory());
            assertEquals(150, actual.get(0).getQuantity());
            assertTrue(actual.get(0).isPacked());
            assertFalse(actual.get(0).isAdv());
            assertEquals( 1.49, actual.get(0).getPrice());
            assertEquals(15.0, actual.get(0).getMargin());
            assertFalse(actual.get(0).isDebt());
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void testParseReportThrowsExceptionWhenFilePathIsNullOrBlank(String filePath) {
        assertThrows(IllegalArgumentException.class, () -> reportParser.parseReport(filePath));
    }

    @Test
    void testParseReportThrowsExceptionWhenFileNotFound() {
        assertThrows(CustomFileNotFoundException.class, () -> reportParser.parseReport("somePath"));
    }

    @Test
    void testParseReportThrowsExceptionWhenReportIsEmpty() {
        assertThrows(EmptyReportFileException.class, () -> reportParser.parseReport("src/test/resources/emptyReport.txt"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "src/test/resources/invalidReport.txt",
            "src/test/resources/validReport.json"
    })
    void testParseReportThrowsExceptionWhenReportFormatIsInvalid(String filePath) {
        assertThrows(InvalidReportFormatException.class, () -> reportParser.parseReport(filePath));
    }
}