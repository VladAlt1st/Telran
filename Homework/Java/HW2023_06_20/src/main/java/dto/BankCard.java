package dto;

import enums.Currency;
import enums.PaymentSystem;
import enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 *  Банковская карта
 *  - номер карты
 *  - срок действия
 *  - статус
 *  - платежная система
 *  - остаток на счету
 *  - валюта
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class BankCard implements Comparable<BankCard> {
    private final String cardNumber;
    private final LocalDate validity;
    private final Status status;
    private final PaymentSystem paymentSystem;
    private final Currency currency;
    private double cardBalance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(cardNumber, bankCard.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public int compareTo(BankCard o) {
        return this.cardNumber.compareTo(o.cardNumber);
    }
}
