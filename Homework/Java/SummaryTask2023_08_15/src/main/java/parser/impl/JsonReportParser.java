package parser.impl;

import entity.Product;
import exception.CustomFileNotFoundException;
import exception.EmptyReportFileException;
import org.json.JSONArray;
import org.json.JSONObject;
import parser.IReportParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReportParser implements IReportParser {
    @Override
    public List<Product> parseReport(String filePath) {
        checkFilePathIsNullOrBlank(filePath);

        String report = readJsonFromFile(filePath);
        checkReportIsBlank(report);

        JSONArray jsonArray = new JSONArray(report);
        checkJsonFileIsEmpty(jsonArray);

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            products.add(parseJsonObject(jsonArray.getJSONObject(i)));
        }
        return products;
    }

    private Product parseJsonObject(JSONObject jo) {
        return new Product(
             Integer.parseInt(jo.getString("CATEGORY").split("#")[1]),
             jo.getString("CATEGORY").split("#")[0],
             jo.getString("NAME").split("#")[0],
             jo.getString("FACTORY").split("#")[0],
             jo.getInt("QUANTITY"),
             jo.getBoolean("ISPACKED"),
             jo.getBoolean("ISADV"),
             jo.getDouble("PRICE"),
             jo.getDouble("MARGIN"),
             jo.getBoolean("ISDEBT")
        );
    }

    private String readJsonFromFile(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new CustomFileNotFoundException(e.getMessage());
        }
    }

    private void checkFilePathIsNullOrBlank(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("file path is null or blank");
        }
    }

    private void checkReportIsBlank(String report) {
        if (report.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkJsonFileIsEmpty(JSONArray array) {
        if (array.isEmpty()) {
            throw new EmptyReportFileException();
        }
    }
}