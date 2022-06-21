package com.sg.dto;

import java.math.BigDecimal;

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
    FIVE_CENT(new BigDecimal("0.50"))
            {
                @Override
                public String toString() {
                    return "five cent";
                }
            },
    ONE_CENT(new BigDecimal("0.10"))
            {
                @Override
                public String toString() {
                    return "one cent";
                }

            };

    final BigDecimal value;

    Money(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

}
