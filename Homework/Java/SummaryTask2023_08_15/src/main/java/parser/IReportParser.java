package parser;

import entity.Product;

import java.util.List;

public interface IReportParser {
    List<Product> parseReport(String filePath);
}