package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {
    private final Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        boolean isTrue = false;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public BigDecimal totalIncome() {
        BigDecimal totalIncomeAmount = new BigDecimal(0);
        for (Deposit d : deposits) {
            if (d != null) totalIncomeAmount = totalIncomeAmount.add(d.income());
        }
        return totalIncomeAmount.setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal maxIncome() {
        BigDecimal maxIncomeAmount = new BigDecimal(0);
        for (Deposit d : deposits) {
            if (d != null && maxIncomeAmount.compareTo(d.income()) < 0) maxIncomeAmount = d.income();
        }
        return maxIncomeAmount;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number >= deposits.length)
            throw new IllegalArgumentException("illegal number: more than deposits size");
        if (deposits[number] == null)
            return new BigDecimal(0);
        return deposits[number].income();
    }
}
