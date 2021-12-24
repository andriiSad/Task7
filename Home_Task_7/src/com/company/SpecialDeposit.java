package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit {
    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();

        BigDecimal incomeAmount;
        BigDecimal currentAmount = getAmount();
        BigDecimal startPercent = BigDecimal.valueOf(1.0);
        for (int i = 0; i < getPeriod(); i++) {
            startPercent = startPercent.add(BigDecimal.valueOf(0.01));
            currentAmount = currentAmount.multiply(startPercent);
        }
        incomeAmount = currentAmount.subtract(getAmount());

        return incomeAmount.setScale(2, RoundingMode.HALF_DOWN);

    }
}
