package db;

import entity.Product;
import exception.NoSuchCategoryException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import parser.impl.TxtReportParser;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductStorageTest {
    private final List<Product> testProducts = new TxtReportParser().parseReport("src/test/resources/productStorageTestReport.txt");
    @Spy
    private ProductStorage productStorage = new ProductStorage(testProducts);

    @ParameterizedTest
    @NullAndEmptySource
    void testProductStorageInitializationWithEmptyOrNullList(List<Product> list) {
        assertThrows(IllegalArgumentException.class, () -> new ProductStorage(list));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", " \n "})
    void testCheckCategoryValidityTrowsExceptionWhenCategoryIsNullOrBlank(String category) {
        assertThrows(IllegalArgumentException.class, () -> productStorage.checkCategoryValidity(category));
    }

    @ParameterizedTest
    @ValueSource(strings = {"CATS", "DOGS", "FISH"})
    void testCheckCategoryValidityTrowsExceptionWhenCategoryDoesNotExist(String category) {
        assertThrows(NoSuchCategoryException.class, () -> productStorage.checkCategoryValidity(category));
    }

    @Test
    void testGetAllUniqueFactory() {
        List<String> expected = List.of("A", "B", "C");
        List<String> actual = productStorage.getAllUniqueFactory();

        assertEquals(expected, actual);
    }

    @Test
    void testGetMaxPriceProduct() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<Product> expected = List.of(testProducts.get(3), testProducts.get(7), testProducts.get(5));

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.getMaxPriceProduct(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void testGetMaxInMoneyProduct() {
        Product expected = testProducts.get(7);
        assertEquals(expected, productStorage.getMaxInMoneyProduct());
    }

    @Test
    void getMinInMoneyProduct() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<Product> expected = List.of(testProducts.get(0), testProducts.get(1), testProducts.get(2));

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.getMinInMoneyProduct(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void countAdvProducts() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<Long> expected = List.of(0L, 2L, 2L);

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.countAdvProducts(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void groupByIsPacked() {
        Map<Boolean, List<Product>> expected = Map.of(
                true, List.of(testProducts.get(1), testProducts.get(2), testProducts.get(3), testProducts.get(4),
                        testProducts.get(5), testProducts.get(7)),
                false, List.of(testProducts.get(0),testProducts.get(6))
        );
        assertEquals(expected, productStorage.groupByIsPacked());
    }

    @Test
    void getMaxMarginProduct() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<Product> expected = List.of(testProducts.get(6), testProducts.get(1), testProducts.get(5));

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.getMaxMarginProduct(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void getAvgMargin() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<Double> expected = List.of(15.5, 13.333333333333334, 20.25);

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.getAvgMargin(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void getThreeMinMarginProductsWithAdv() {
        List<String> category = List.of("FOOD", "DRINKS", "SNACKS");
        List<List<Product>> expected = List.of(
                List.of(),
                List.of(testProducts.get(7), testProducts.get(4)),
                List.of(testProducts.get(2), testProducts.get(5))
        );

        assertDoesNotThrow(() -> {
            for (int i = 0; i < category.size(); i++) {
                assertEquals(expected.get(i), productStorage.getThreeMinMarginProductsWithAdv(category.get(i)));
                Mockito.verify(productStorage).checkCategoryValidity(category.get(i));
            }
        });
    }

    @Test
    void getSortedMapById() {
        Map<Integer, Product> expected = Map.of(
              1, testProducts.get(0), 2, testProducts.get(1), 3, testProducts.get(2),
                4, testProducts.get(3), 5, testProducts.get(4), 6, testProducts.get(5),
              7, testProducts.get(6), 8, testProducts.get(7)
        );
        assertEquals(expected, productStorage.getSortedMapById());
    }

    @Test
    void testGetMinInMoneyProduct() {
        Product expected = testProducts.get(0);
        assertEquals(expected, productStorage.getMinInMoneyProduct());
    }
}