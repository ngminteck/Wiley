package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.Money;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryFileImpl implements Inventory {

    // LinkedHashMap faster iterator to change the count value which represent the value
   private final Map<Item, Integer> items = new LinkedHashMap<>();
   private final Map<Money, Integer> moneys = new LinkedHashMap<>();

   private Map<Money, Integer> userInputMoneys = new LinkedHashMap<>();

   public InventoryFileImpl()
   {
      moneys.put(Money.TWO_DOLLAR,0);
      moneys.put(Money.ONE_DOLLAR,0);
      moneys.put(Money.FIFTY_CENT,0);
      moneys.put(Money.TWENTY_CENT,0);
      moneys.put(Money.TEN_CENT,0);
      moneys.put(Money.FIVE_CENT,0);
      moneys.put(Money.ONE_CENT,0);

      userInputMoneys.put(Money.TWO_DOLLAR,0);
      userInputMoneys.put(Money.ONE_DOLLAR,0);
      userInputMoneys.put(Money.FIFTY_CENT,0);
      userInputMoneys.put(Money.TWENTY_CENT,0);
      userInputMoneys.put(Money.TEN_CENT,0);
      userInputMoneys.put(Money.FIVE_CENT,0);
      userInputMoneys.put(Money.ONE_CENT,0);
   }

   // items & money for change
   public void ReadFile()
   {

   }

   public void SaveFile()
   {

   }


}
