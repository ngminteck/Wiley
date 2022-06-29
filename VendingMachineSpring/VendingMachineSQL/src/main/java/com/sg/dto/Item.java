package com.sg.dto;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal cost;

    public Item(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!name.equals(item.name)) return false;
        return cost.equals(item.cost);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + cost.hashCode();
        return result;
    }
}
