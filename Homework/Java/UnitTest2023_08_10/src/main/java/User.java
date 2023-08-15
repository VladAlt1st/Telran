import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User:
 * Поля:
 * int id
 * String username
 * String email
 * Set<Role> roles
 * Методы:
 * getUserInfo(): Возвращает строку с информацией о пользователе.
 * addRole(Role role): Добавляет роль пользователю.
 * removeRole(Role role): Удаляет роль у пользователя.
 * Бизнес-логика: Класс описывает пользователя с уникальным идентификатором, именем, адресом электронной почты и списком ролей.
 * Пользователь может иметь несколько ролей.
 */
public class User {
    private final int id;
    private final String username;
    private final String password;
    private final String email;
    private boolean hasAccess;
    private final Set<Role> roles;

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        hasAccess = false;
        this.roles = new HashSet<>();
    }

    public String getUserInfo() {
        return this.toString();
    }

    public boolean addRole(Role role) {
        roleNullChecker(role);
        return roles.add(role);
    }

    public boolean removeRole(Role role) {
        roleNullChecker(role);
        return roles.remove(role);
    }

    private void roleNullChecker(Role role) {
        if (role == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasAccess() {
        return hasAccess;
    }

    public void setAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}