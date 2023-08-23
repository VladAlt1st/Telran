package db;

import entity.Product;
import exception.NoSuchCategoryException;
import exception.NoSuchProductException;

import java.util.*;
import java.util.stream.Collectors;


public class ProductStorage {
    private final List<Product> productList;
    private Set<String> categorySet;

    public ProductStorage(List<Product> productList) {
        checkProductListIsNullOrEmpty(productList);
        this.productList = productList;
    }

    // всех производителей товаров
    public List<String> getAllUniqueFactory() {
        return productList.stream()
                .map(Product::getFactory)
                .distinct()
                .toList();
    }

    // самый дорогой продукт в категории
    public Product getMaxPriceProduct(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(NoSuchProductException::new);
    }

    // какого товара больше всего на складе в деньгах
    public Product getMaxInMoneyProduct() {
        return productList.stream()
                .max(Comparator.comparingDouble(product -> product.getPrice() * product.getQuantity()))
                .orElseThrow(NoSuchProductException::new);
    }

    // какого товара меньше всего на складе в деньгах по категории
    public Product getMinInMoneyProduct(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .min(Comparator.comparingDouble(product -> product.getPrice() * product.getQuantity()))
                .orElseThrow(NoSuchProductException::new);
    }

    // количество видов акционного товара по категории
    public long countAdvProducts(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category) && product.isAdv())
                .count();
    }

    // сгруппировать по упакованным и нет
    public Map<Boolean, List<Product>> groupByIsPacked() {
        return productList.stream()
                .collect(Collectors.partitioningBy(Product::isPacked));
    }

    // у какого товара самая высокая маржа в категории
    public Product getMaxMarginProduct(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .max(Comparator.comparingDouble(Product::getMargin))
                .orElseThrow(NoSuchProductException::new);
    }

    // средняя маржа по категории
    public double getAvgMargin(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .mapToDouble(Product::getMargin)
                .average()
                .orElseThrow(NoSuchCategoryException::new);
    }

    // первые три товара в категории, которые участвуют в акции и у которых самая низкая маржа
    public List<Product> getThreeMinMarginProductsWithAdv(String category) {
        checkCategoryValidity(category);
        return productList.stream()
                .filter(product -> product.getCategory().equals(category) && product.isAdv())
                .sorted(Comparator.comparingDouble(Product::getMargin))
                .limit(3)
                .toList();
    }

    // поместить в TreeMap отсортировав в ай ди. #37 - это ай ди.
    public SortedMap<Integer, Product> getSortedMapById() {
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        for (Product product : productList) {
            productMap.put(product.getId(), product);
        }
        return productMap;
    }

    //*  самый дешевый товар которого меньше всего на складе осталось в кг или штуках в зависимости от IS PACKED
    public Product getMinInMoneyProduct() {
        return productList.stream()
                .min(Comparator.comparingDouble(product -> product.getPrice() * product.getQuantity()))
                .orElseThrow(NoSuchProductException::new);
    }

    public void checkCategoryValidity(String category) {
        if (categorySet == null) {
            this.categorySet = getAllCategory();
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("category is null or blank");
        }
        if (!categorySet.contains(category)) {
            throw new NoSuchCategoryException();
        }
    }

    private Set<String> getAllCategory() {
        return productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    private void checkProductListIsNullOrEmpty(List<Product> productList) {
        if (productList == null || productList.isEmpty()) {
            throw new IllegalArgumentException("product list is null or empty");
        }
    }

    @Override
    public String toString() {
        return productList.toString();
    }
}