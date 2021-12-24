package com.company;

import java.math.BigDecimal;

public abstract class Deposit {
    private final BigDecimal amount;
    private final int period;

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    Deposit(BigDecimal amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    public abstract BigDecimal income();


}
