/**
 * AuthenticationService:
 * Поля:
 * UserDatabase userDatabase
 * Методы:
 * authenticate(String username, String password): Проверяет аутентификацию пользователя.
 * grantAccess(User user): Предоставляет доступ пользователю.
 * revokeAccess(User user): Отзывает доступ у пользователя.
 * Бизнес-логика: Класс предоставляет методы для аутентификации пользователей, предоставления и отзыва доступа.
 */
public class AuthenticationService {
    private final UserDatabase userDatabase;

    public AuthenticationService() {
        this.userDatabase = new UserDatabase();
    }

    /*public boolean authenticate(String username, String password) {
        User user = userDatabase.getUserByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            user.setAuthentication(true);
            return true;
        }
        return false;
    }*/

    public User grantAccess(User user) {
        return null;
    }

    public void revokeAccess(User user) {

    }
}