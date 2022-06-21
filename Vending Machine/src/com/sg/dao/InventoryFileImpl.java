package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Inventory have a lot of type, like digital , coupon or the item itself
// payment have a lot mode can be cash payment or card payment etc
public class InventoryFileImpl implements Inventory, Cash {

    // LinkedHashMap faster iterator to change the count value which represent the value
   private Set<Pair<Item,Integer>> items = new LinkedHashSet<>();
   private final Map<Money, Integer> moneys = new LinkedHashMap<>();
   private final Map<Money, Integer> userInputMoneys = new LinkedHashMap<>();
   private final BigDecimal maxChangeAmount;

   public InventoryFileImpl(BigDecimal maxChangeAmount)
   {
      InitUserInputMoneyLinkHashMap();
      InitMachineMoneyLinkHashMap();
      this.maxChangeAmount = maxChangeAmount;
   }

   public Set<Pair<Item, Integer>> getItems() {
      return items;
   }

   public void setItems(Set<Pair<Item, Integer>> items) {
      this.items = items;
   }

   public Map<Money, Integer> getMoneys() {
      return moneys;
   }

   public Map<Money, Integer> getUserInputMoneys() {
      return userInputMoneys;
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

   @Override
   public void InitUserInputMoneyLinkHashMap() {
      userInputMoneys.put(Money.TWO_DOLLAR,0);
      userInputMoneys.put(Money.ONE_DOLLAR,0);
      userInputMoneys.put(Money.FIFTY_CENT,0);
      userInputMoneys.put(Money.TWENTY_CENT,0);
      userInputMoneys.put(Money.TEN_CENT,0);
      userInputMoneys.put(Money.FIVE_CENT,0);
      userInputMoneys.put(Money.ONE_CENT,0);
   }

   @Override
   public void InitMachineMoneyLinkHashMap() {
      moneys.put(Money.TWO_DOLLAR,0);
      moneys.put(Money.ONE_DOLLAR,0);
      moneys.put(Money.FIFTY_CENT,0);
      moneys.put(Money.TWENTY_CENT,0);
      moneys.put(Money.TEN_CENT,0);
      moneys.put(Money.FIVE_CENT,0);
      moneys.put(Money.ONE_CENT,0);
   }

   @Override
   public BigDecimal GetMaxChangeAmount() {
      return maxChangeAmount;
   }


   @Override
   public BigDecimal CountTotalUserAmount() {
      return null;
   }

   @Override
   public void AddUserAmountIntoMachine() {

   }

   @Override
   public void ChangeFromUserInput() {

   }

   @Override
   public Boolean ChangeFromMachine(BigDecimal amountNeed) {
      return null;
   }

   @Override
   public Integer CheckMoneyTypeCount(Money money) {
      return null;
   }

   public void PreAddMoneyReplace(Money moneyType, Integer count)
   {
      userInputMoneys.put(moneyType,count);
   }
   public void PreAddItemReplaceIfExisted(Item item, Integer count)
   {
      items.add(new Pair<>(item,count));
   }


}
