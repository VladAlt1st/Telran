package dto;

import lombok.*;

import java.util.Objects;

/**
 *  Клиент
 *  - имя
 *  - возраст
 *  - номер паспорта
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client implements Comparable<Client> {
    private final String passportID;
    private final String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(passportID, client.passportID) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportID, name);
    }

    @Override
    public int compareTo(Client o) {
        return this.passportID.compareTo(o.passportID);
    }
}
