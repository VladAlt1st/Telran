import java.util.HashSet;
import java.util.Set;

/**
 * UserDatabase:
 * Поля:
 * Set<User> users
 * Методы:
 * getUserById(int id): Возвращает пользователя по его идентификатору.
 * getUserByUsername(String username): Возвращает пользователя по имени пользователя.
 * addUser(User user): Добавляет нового пользователя в базу данных.
 * Бизнес-логика: Класс управляет хранением и доступом к пользователям.
 */
public class UserDatabase {
    private final Set<User> users;

    public UserDatabase() {
        users = new HashSet<>();
    }

    public User getUserById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> id == user.getId())
                .findFirst().orElse(null);
    }

    public User getUserByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst().orElse(null);
    }

    public boolean addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        return users.add(user);
    }
}