package com.sg.dto;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Money {
    TWO_DOLLAR(new BigDecimal("2.00"))
            {
                public String toString() {
                    return "two dollar";
                }

            },
    ONE_DOLLAR(new BigDecimal("1.00"))
            {
                public String toString() {
                    return "one dollar";
                }
            },
    FIFTY_CENT(new BigDecimal("0.50"))
            {
                public String toString() {
                    return "fifty cent";
                }
            },
    TWENTY_CENT(new BigDecimal("0.20"))
            {
                @Override
                public String toString() {
                    return "twenty cent";
                }
            },
    TEN_CENT(new BigDecimal("0.10"))
            {
                @Override
                public String toString() {
                    return "ten cent";
                }
            },
    FIVE_CENT(new BigDecimal("0.05"))
            {
                @Override
                public String toString() {
                    return "five cent";
                }
            },
    ONE_CENT(new BigDecimal("0.01"))
            {
                @Override
                public String toString() {
                    return "one cent";
                }

            };

    final BigDecimal moneyValue;

    private static final Map<BigDecimal,Money> valueToEnum = new HashMap<>();

    Money(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
    }

    public BigDecimal getMoneyValue() {
        return moneyValue;
    }

    static {

        for (Money enumType : EnumSet.allOf(Money.class)) {
            valueToEnum.put(enumType.moneyValue, enumType);
        }
    }

    public static Map<BigDecimal,Money> GetAllEnumForLoop()
    {
        return valueToEnum;
    }

    public static Money GetEnumByMoneyValue(BigDecimal moneyValue)
    {
        return valueToEnum.get(moneyValue);
    }

}
