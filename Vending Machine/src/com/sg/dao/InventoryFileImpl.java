package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;

import java.math.BigDecimal;
import java.util.ArrayList;

// Inventory have a lot of type, like digital , coupon or the item itself
// payment have a lot mode can be cash payment or card payment etc
public class InventoryFileImpl implements Inventory {

    // At vending machine item choice maybe duplicate due to limit of space
   private final ArrayList<ItemWrapper> items = new ArrayList<>();


   public ArrayList<ItemWrapper> getItems() {
      return items;
   }


   @Override
   public void AddNewItemProduct(String name, BigDecimal price, Integer count) {
      items.add(new ItemWrapper(new Item(name,price),count));
   }
   @Override
   public void ModifyItemProduct(int index, String name, BigDecimal price, Integer count)
   {
      items.get(index).getItem().setName(name);
      items.get(index).getItem().setCost(price);
      items.get(index).setStock(count);
   }

   @Override
   public void RemoveItemProduct(int index) {
      items.remove(index);
   }


   @Override
   public void RemoveItemCount(int index, Integer count) {
      items.get(index).setStock(items.get(index).getStock() - count);
   }

   public void PreAddItemReplaceIfExisted(Item item, Integer count)
   {
      items.add(new ItemWrapper(item,count));
   }




}
