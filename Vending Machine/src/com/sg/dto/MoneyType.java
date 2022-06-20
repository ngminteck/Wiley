package com.sg.dto;

public enum MoneyType {
    ONE_CENT
            {
                @Override
                public String toString() {
                    return "one cent";
                }

            },
    FIVE_CENT
            {
        @Override
        public String toString() {
            return "five cent";
        }
    },
    TEN_CENT
            {
                @Override
                public String toString() {
                    return "ten cent";
                }
            },
    TWENTY_CENT
            {
                @Override
                public String toString() {
                    return "twenty cent";
                }
            },
    FIFTY_CENT
            {
                public String toString() {
                    return "fifty cent";
                }
            },
    ONE_DOLLAR
            {
                public String toString() {
                    return "one dollar";
                }
            },
    TWO_DOLLAR
            {
                public String toString() {
                    return "two dollar";
                }
             },
    FIVE_DOLLAR
            {
                public String toString() {
                    return "five dollar";
                }
            },
    TEN_DOLLAR
            {
                public String toString() {
                    return "ten dollar";
                }
            }

}
