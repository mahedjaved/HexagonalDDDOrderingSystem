package com.food.ordering.system.domain.entity.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    /*
     * Description: Setting it to final makes the Value Object "immutable"
     * */
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    //    used when called by entity objects and data mappers
    public BigDecimal getAmount() {
        return amount;
    }

    //   -----------------------  Monetary Calculations -----------------------   //
    public boolean isGreaterThanZero() {
        /*
         * Description: checks if the amount is greater than zero
         * .compareTo() is used instead of equalsTo since .equalsTo() will truncate decimals to integer before comparison and that will yield false positive result
         * */
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;

    }

    public boolean isGreaterThan(Money money) {
        /*
         * Description: checks if the amount is greater than some money amount as part of the argument
         * */
        return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
    }

    public Money add(Money money) {
        /*
         * Description: you have to watch out for scale issues to prevent rounding errors, for that you need to set the scale similar for both the entities
         * */
        return new Money(setMoneyScale(this.amount.add(money.getAmount())));
    }

    public Money subtract(Money money) {
        return new Money(setMoneyScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiply(Money money) {
        return new Money(setMoneyScale(this.amount.multiply(money.getAmount())));
    }

    public BigDecimal setMoneyScale(BigDecimal input) {
        /*
         * Description: sets the decimal point for money amount to a set specific number
         * Rounding mode to HALF_EVEN uses nearest neighbours to round to nearest figure
         * Rounding also helps in deal with recurring decimals (e.g. 1/3 = 0.33333 ....)
         * */
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
