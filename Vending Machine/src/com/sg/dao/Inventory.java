package com.sg.dao;

import com.sg.dto.Item;
import javafx.util.Pair;

import java.math.BigDecimal;

public interface Inventory {

    void AddNewItemProduct (Item item);
    void AddNewItemProduct (Item item, Integer count);
    void RemoveItemProduct(Item item);
    void AddItemCount (Item item, Integer count);
    void RemoveItemCount (Item item, Integer count);

}
