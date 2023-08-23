package entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Product implements Comparable<Product> {

    @EqualsAndHashCode.Include
    private final int id;

    private final String category;

    private final String name;

    private final String factory;

    private final int quantity;

    private final boolean isPacked;

    private final boolean isAdv;

    private final double price;

    private final double margin;

    private final boolean isDebt;

    @Override
    public int compareTo(Product o) {
        return this.getId() - o.getId();
    }
}