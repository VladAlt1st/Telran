import java.util.Objects;

/**
 * Role:
 * Поля:
 * int id
 * String roleName
 * String description
 * Методы:
 * getRoleInfo(): Возвращает строку с информацией о роли.
 * setDescription(String description): Устанавливает описание роли.
 * Бизнес-логика: Класс описывает роль с уникальным идентификатором, названием и описанием.
 */
// TODO: 14.08.2023 сделать проверку id и roleName при создании роли.
public class Role {
    private final int id;
    private final String roleName;
    private String description;

    public Role(int id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleInfo() {
        return this.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}