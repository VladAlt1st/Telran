
import dao.Storage;
import dto.BankCard;
import dto.Client;
import enums.Currency;
import util.Generator;

import java.util.*;

public class Main {

    /*
 - класс Клиент
    - имя
    - возраст
    - номер паспорта
 - класс Банковская карта
    - номер карты
    - срок действия
    - статус
    - платежная система
    - остаток на счету
    - валюта
 - класс Хранилище
    - Map которая хранит ---Клиент, СетКарт--- TreeMap
    * Add Read(валюта) Update Delete
 - класс Генератор
    * генерация Клиента
    * генерация банковских карт
 - класс Мэйн
    */
    public static void main(String[] args) {
        Storage storage = new Storage();

        List<Client> clientList = Generator.generateClients(2);
        List<BankCard> bankCardList = Generator.generateCards(4);

        System.out.println(bankCardList);

        storage.addCard(clientList.get(0), bankCardList.get(0));
        storage.addCard(clientList.get(0), bankCardList.get(1));
        storage.addCard(clientList.get(0), bankCardList.get(1));

        storage.addAllCards(clientList.get(1), Set.of(bankCardList.get(2), bankCardList.get(3)));

        storage.deleteCard(clientList.get(0), bankCardList.get(0));

        System.out.println(storage.getCardSet(clientList.get(0)));

        System.out.println(storage.getByCurrency(Currency.UAH));

        System.out.println(storage.deleteClient(clientList.get(1)));


    }
}

