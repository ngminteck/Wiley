package com.sg.dto;

public enum MoneyType {
    TWO_DOLLAR
            {
                public String toString() {
                    return "two dollar";
                }
            },
    ONE_DOLLAR
            {
                public String toString() {
                    return "one dollar";
                }
            },
    FIFTY_CENT
            {
                public String toString() {
                    return "fifty cent";
                }
            },
    TWENTY_CENT
            {
                @Override
                public String toString() {
                    return "twenty cent";
                }
            },
    TEN_CENT
            {
                @Override
                public String toString() {
                    return "ten cent";
                }
            },
    FIVE_CENT
            {
                @Override
                public String toString() {
                    return "five cent";
                }
            },
    ONE_CENT
            {
                @Override
                public String toString() {
                    return "one cent";
                }

            }

}
