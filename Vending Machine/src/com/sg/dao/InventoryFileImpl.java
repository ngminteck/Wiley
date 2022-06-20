package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.Money;
import com.sg.dto.MoneyType;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryFileImpl implements Inventory {

    // LinkedHashMap faster iterator to change the count value which represent the value
   private Map<Item, Integer> items = new LinkedHashMap<>();
   private Map<Money, Integer> moneys = new LinkedHashMap<>();

   public InventoryFileImpl()
   {
      moneys.put(new Money(MoneyType.ONE_CENT,"One Cent",new BigDecimal(0.01)),0);
      moneys.put(new Money(MoneyType.FIVE_CENT,"Five Cent",new BigDecimal(0.05)),0);
      moneys.put(new Money(MoneyType.TEN_CENT,"Ten Cent",new BigDecimal(0.10)),0);
      moneys.put(new Money(MoneyType.TWENTY_CENT,"Twenty Cent",new BigDecimal(0.20)),0);
      moneys.put(new Money(MoneyType.FIFTY_CENT,"Fifty Cent",new BigDecimal(0.50)),0);
      moneys.put(new Money(MoneyType.ONE_DOLLAR,"One Dollar",new BigDecimal(1.00)),0);
      moneys.put(new Money(MoneyType.TWO_DOLLAR,"Two Dollar",new BigDecimal(2.00)),0);
      moneys.put(new Money(MoneyType.FIVE_DOLLAR,"Five Dollar",new BigDecimal(5.00)),0);
      moneys.put(new Money(MoneyType.TEN_DOLLAR,"Ten Dollar",new BigDecimal(10.00)),0);
   }

   // items & money for change
   public void ReadFile()
   {

   }

   public void SaveFile()
   {

   }


   @Override
   public Integer GetMoneyTypeCount(MoneyType moneyType) {
      return null;
   }

   @Override
   public void SetMoneyTypeCount(MoneyType moneyType) {

   }
}
