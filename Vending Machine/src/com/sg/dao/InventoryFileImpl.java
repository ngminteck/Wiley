package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;

// Inventory have a lot of type, like digital , coupon or the item itself
// payment have a lot mode can be cash payment or card payment etc
public class InventoryFileImpl implements Inventory {

    // At vending machine item choice maybe duplicate due to limit of space
   private ArrayList<Pair<Item,Integer>> items = new ArrayList<>();


   public ArrayList<Pair<Item, Integer>> getItems() {
      return items;
   }

   public void setItems(ArrayList<Pair<Item, Integer>> items) {
      this.items = items;
   }

   @Override
   public void AddNewItemProduct(Item item) {

   }

   @Override
   public void AddNewItemProduct(Item item, Integer count) {

   }

   @Override
   public void RemoveItemProduct(Item item) {

   }

   @Override
   public void AddItemCount(Item item, Integer count) {

   }

   @Override
   public void RemoveItemCount(Item item, Integer count) {

   }

   public void PreAddItemReplaceIfExisted(Item item, Integer count)
   {
      items.add(new Pair<>(item,count));
   }




}
