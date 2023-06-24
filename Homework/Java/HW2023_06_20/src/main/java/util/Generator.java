package util;

import com.github.javafaker.Faker;
import dto.BankCard;
import dto.Client;
import enums.Currency;
import enums.PaymentSystem;
import enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static List<Client> generateClients(int n) {
        List<Client> clientList = new ArrayList<>();
        Faker faker = new Faker();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            long num = faker.number().randomNumber(6, true);

            String passportID = String.valueOf(num);
            String name = faker.name().firstName();
            int age = r.nextInt(72) + 18;

            clientList.add(new Client(passportID, name, age));
        }

        return clientList;
    }

    public static List<BankCard> generateCards(int n) {
        List<BankCard> bankCardList = new ArrayList<>();
        Faker faker = new Faker();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            String cardNumber = faker.business().creditCardNumber().replaceFirst("1", String.valueOf(r.nextInt(10)));
            LocalDate validity = LocalDate.of(2022 + r.nextInt(7), r.nextInt(1, 13), r.nextInt(1, 29));

            Status[] statuses = Status.values();
            Status status = statuses[r.nextInt(statuses.length)];

            PaymentSystem[] systems = PaymentSystem.values();
            PaymentSystem paymentSystem = systems[r.nextInt(systems.length)];

            Currency[] currencies = Currency.values();
            Currency currency = currencies[r.nextInt(currencies.length)];

            double cardBalance = faker.number().numberBetween(100, 2000);

            bankCardList.add(new BankCard(cardNumber, validity, status, paymentSystem, currency, cardBalance));
        }
        return  bankCardList;
    }
}
