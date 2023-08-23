package parser.impl;

import entity.Product;
import exception.CustomFileNotFoundException;
import exception.EmptyReportFileException;
import exception.InvalidReportFormatException;
import parser.IReportParser;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtReportParser implements IReportParser {
    private static final String REPORT_FORMAT = "(\\[[\\w\\s().'-]+#\\d+]){9}";

    @Override
    public List<Product> parseReport(String filePath) {
        checkFilePathIsNullOrBlank(filePath);

        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String reportLine;

            while ((reportLine = reader.readLine()) != null) {
                if ("".equals(reportLine)) {
                    continue;
                }
                products.add(parseReportLine(reportLine));
            }
        } catch (IOException e) {
            throw new CustomFileNotFoundException(e.getMessage());
        }
        checkReportFileIsEmpty(products);
        return products;
    }

    private Product parseReportLine(String reportLine) {
        checkReportLineFormat(reportLine);
        String[] data = getLineData(reportLine);
        return new Product(
                Integer.parseInt(data[0]),
                data[1].replace("(CATEGORY)", ""),
                data[2],
                data[3],
                Integer.parseInt(data[4]),
                Boolean.parseBoolean(data[5]),
                Boolean.parseBoolean(data[6]),
                Double.parseDouble(data[7]),
                Double.parseDouble(data[8]),
                Boolean.parseBoolean(data[9])
        );
    }

    private String[] getLineData(String reportLine) {
        Pattern pattern = Pattern.compile("\\[(.*?)#(\\d+)]");
        Matcher matcher = pattern.matcher(reportLine);

        String[] data = new String[10];
        int index = 1;

        while (matcher.find()) {
            if (index == 1) {
                data[0] = matcher.group(2);
            }
            data[index++] = matcher.group(1);
        }
        return data;
    }

    private void checkFilePathIsNullOrBlank(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("file path is null or blank");
        }
    }

    private void checkReportLineFormat(String reportLine) {
        if (!reportLine.matches(REPORT_FORMAT)) {
            throw new InvalidReportFormatException();
        }
    }

    private void checkReportFileIsEmpty(List<Product> products) {
        if (products.isEmpty()) {
            throw new EmptyReportFileException();
        }
    }
}