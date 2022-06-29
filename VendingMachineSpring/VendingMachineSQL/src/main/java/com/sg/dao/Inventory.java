package com.sg.dao;

import java.math.BigDecimal;

public interface Inventory {
    void AddNewItemProduct (String name, BigDecimal price, Integer count) ;
    void ModifyItemProduct(int index, String name, BigDecimal price, Integer count) ;
    void RemoveItemProduct(int index) ;

    void RemoveItemCount (int index, Integer count) ;

}
