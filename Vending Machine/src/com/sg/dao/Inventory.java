package com.sg.dao;

import com.sg.dto.Item;
import com.sg.dto.MoneyType;

public interface Inventory {

    Integer GetMoneyTypeCount(MoneyType moneyType);
    void SetMoneyTypeCount(MoneyType moneyType);


}
