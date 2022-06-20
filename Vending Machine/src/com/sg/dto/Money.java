package com.sg.dto;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Money {

    private MoneyType moneyType;
    private BigDecimal value;

    public Money(MoneyType moneyType, BigDecimal value) {
        this.moneyType = moneyType;
        this.value = value;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "moneyType=" + moneyType +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return moneyType == money.moneyType;
    }

    @Override
    public int hashCode() {
        return moneyType.hashCode();
    }
}

