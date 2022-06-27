package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Inventory have a lot of type, like digital , coupon or the item itself
// payment have a lot mode can be cash payment or card payment etc
public class InventoryFileImpl implements Inventory {

   public static final String FILENAME = "vm.txt";
    // At vending machine item choice maybe duplicate due to limit of space
   private final ArrayList<ItemWrapper> items = new ArrayList<>();


   public ArrayList<ItemWrapper> getItems() {
      return items;
   }

   public InventoryFileImpl()
   {

   }

   @Override
   public void AddNewItemProduct(String name, BigDecimal price, Integer count)
   {
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
   public void RemoveItemProduct(int index)
   {
      items.remove(index);

   }


   @Override
   public void RemoveItemCount(int index, Integer count)
   {
      items.get(index).setStock(items.get(index).getStock() - count);

   }

   public void PreAddItemReplaceIfExisted(Item item, Integer count)
   {
      items.add(new ItemWrapper(item,count));
   }


   public void FileWrite() throws VendingMachineException
   {
      PrintWriter out;

      try {
         out = new PrintWriter(new FileWriter(FILENAME));
      } catch (IOException e) {
         throw new VendingMachineException(
                 "Could not save vending machine data.", e);
      }

      out.println(LocalDateTime.now());
      out.flush();

      items.forEach(i -> {
         StringBuilder stringData = Serialization(i);
         out.println(stringData);
         out.flush();
      } );

      System.out.println("Data saved.");

      out.close();

   }

   private StringBuilder Serialization (ItemWrapper data)
   {
       StringBuilder write = new StringBuilder("\"" + data.getItem().getName() +"\"");
       write.append(",");
       write.append(data.getItem().getCost());
       write.append(",");
       write.append(data.getStock());
       return write;
   }

   public void ReadFile()throws VendingMachineException
   {
      List<String> list = new ArrayList<>();

      try (BufferedReader br = Files.newBufferedReader(Paths.get(FILENAME))) {

         //br returns as stream and convert it into a List
         list = br.lines().collect(Collectors.toList());
         System.out.println("Data loaded.");

      } catch (IOException e) {
         e.printStackTrace();
      }

      list.forEach(this::DeSerialization);

   }

   public void DeSerialization(String string)
   {

      // remove the first "
      string = string.substring(1);
      int index =  string.indexOf("\"");

      // invalid for the name"";
      if(index < 0)
         return;

      String name = string.substring(0,index);

      string = string.substring(index);

      // check can it remove ", if length less than 2 surely corrupted
      if(string.length() < 2)
         return;

      string = string.substring(2);

      String[] data = string.split(",");

      // invalid as you need at least 2 data
      if(data.length < 2)
         return;

      double value;
      try
      {
         value = Double.parseDouble(data[0]);
      }
      // invalid
      catch (NumberFormatException ignored)
      {
         return;
      }



      int stock;
      try
      {
         stock = Integer.parseInt(data[1]);
      }
      // invalid
      catch (NumberFormatException ignored)
      {
         return;
      }

      BigDecimal cost = new BigDecimal(value);
      cost = cost.setScale(2, RoundingMode.HALF_UP);

      items.add(new ItemWrapper(new Item(name,cost),stock));


   }

}
