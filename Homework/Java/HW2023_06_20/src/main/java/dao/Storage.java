package dao;

import dto.BankCard;
import dto.Client;
import enums.Currency;

import java.util.*;

/**
 *  Хранилище
 *  - Map которая хранит ---Клиент, СетКарт--- (TreeMap)
 *  - CRUD(Add Read(валюта) Update Delete)
 */

public class Storage {
    private final Map<Client, Set<BankCard>> clientCardSet = new TreeMap<>();

    public boolean addCard(Client client, BankCard card) {
        if (client == null) throw new NullPointerException("Client is null.");
        if (card == null) throw new NullPointerException("Card is null.");

        Set<BankCard> cardSet;

        if (clientCardSet.containsKey(client)) {
            cardSet = clientCardSet.get(client);
        } else {
            cardSet = new HashSet<>();
            clientCardSet.put(client, cardSet);
        }
        return cardSet.add(card);
    }

    public boolean addAllCards(Client client, Collection<BankCard> newCards) {
        if (client == null) throw new NullPointerException("Client is null.");
        if (newCards == null) throw new NullPointerException("New cards is null.");

        Set<BankCard> cardSet;

        if (clientCardSet.containsKey(client)) {
            cardSet = clientCardSet.get(client);
        } else {
            cardSet = new HashSet<>();
            clientCardSet.put(client, cardSet);
        }
        return cardSet.addAll(newCards);
    }

    public boolean deleteCard(Client client, BankCard card) {
        if (client == null) throw new NullPointerException("Client is null.");
        if (card == null) throw new NullPointerException("Card is null.");
        return clientCardSet.get(client).remove(card);
    }

    public Set<BankCard> deleteClient(Client client) {
        if (client == null) throw new NullPointerException("Client is null.");
        return clientCardSet.remove(client);
    }

    public Set<BankCard> getCardSet(Client client) {
        if (client == null) throw new NullPointerException("Client is null.");

        Set<BankCard> cardSet = clientCardSet.get(client);

        if (cardSet != null) {
            return new HashSet<>(cardSet);
        } else {
            return null;
        }
    }

    public List<Client> getByCurrency(Currency currency) {
        if (currency == null) throw new NullPointerException("Currency is null");

        List<Client> clients = new ArrayList<>();

        for (Map.Entry<Client, Set<BankCard>> entry : clientCardSet.entrySet()) {
            Set<BankCard> cardList = entry.getValue();

            for (BankCard bankCard : cardList) {
                if (bankCard.getCurrency() == currency) {
                    clients.add(entry.getKey());
                    break;
                }
            }
        }
        return clients;
    }

    public boolean updateCards(Client client, Collection<BankCard> cards) {
        if (client == null) throw new NullPointerException("Client is null.");
        if (cards == null) throw new NullPointerException("Updated cards is null.");

        Set<BankCard> cardSet = new HashSet<>();
        clientCardSet.put(client, cardSet);
        return cardSet.addAll(cards);
    }

    public void displayStorage() {
        System.out.println(clientCardSet);
    }
}
