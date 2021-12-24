package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {
    public BaseDeposit(BigDecimal amount, int period) {

        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();

        BigDecimal currentAmount = getAmount();
        for (int i = 0; i < getPeriod(); i++) {
            currentAmount = currentAmount.multiply(BigDecimal.valueOf(1.05));
        }
        BigDecimal incomeAmount = currentAmount.subtract(getAmount());

        return incomeAmount.setScale(2, RoundingMode.HALF_DOWN);
    }
}
