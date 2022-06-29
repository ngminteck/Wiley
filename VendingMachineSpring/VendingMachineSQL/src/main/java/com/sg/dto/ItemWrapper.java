package com.sg.dto;

public class ItemWrapper {

    private final Item item;
    private Integer stock;

    public ItemWrapper(Item item, Integer stock) {
        this.item = item;
        this.stock = stock;
    }

    public Item getItem() {
        return item;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ItemWrapper{" +
                "item=" + item +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemWrapper that = (ItemWrapper) o;

        return item.equals(that.item);
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}
