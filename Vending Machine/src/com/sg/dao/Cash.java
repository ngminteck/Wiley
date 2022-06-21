package com.sg.dao;

import com.sg.dto.Money;

import java.math.BigDecimal;

public interface Cash {
    void InitUserInputMoneyLinkHashMap();
    void InitMachineMoneyLinkHashMap();
    BigDecimal GetMaxChangeAmount();
    BigDecimal CountTotalUserAmount();
    void AddUserAmountIntoMachine();
    void ChangeFromUserInput();
    Boolean ChangeFromMachine(BigDecimal amountNeed);
    Integer CheckMoneyTypeCount (Money money);


}
