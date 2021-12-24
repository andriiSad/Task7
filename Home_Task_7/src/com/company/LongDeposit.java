package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {
    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();
        if (getPeriod() < 7) return new BigDecimal(0);

        BigDecimal currentAmount = getAmount();
        for (int i = 6; i < getPeriod(); i++) {
            currentAmount = currentAmount.multiply(BigDecimal.valueOf(1.15));
        }
        BigDecimal incomeAmount = currentAmount.subtract(getAmount());

        return incomeAmount.setScale(2, RoundingMode.HALF_DOWN);
    }
}
