import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDatabaseTest {
    private UserDatabase userDatabase;
    @Mock
    private User user1;
    @Mock
    private User user2;
    @Mock
    private User user3;
    @BeforeEach
    void setUp() {
        userDatabase = new UserDatabase();
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
    }

    // отрабатывает в отдельном тесте, но не работает в общем
    @Test
    void getUserByIdTest() {
        Mockito.when(user1.getId()).thenReturn(1);
        Mockito.when(user2.getId()).thenReturn(2);

        // если поменять на user2, то работает в общем, но не работает в отдельном тесте
        Assertions.assertEquals(user1, userDatabase.getUserById(1));
        Mockito.verify(user1).getId();
        Mockito.verify(user2).getId();
        // перед коммитом стало работать через раз
    }

    @Test
    void getUnaddedUserByIdTest() {
        Mockito.when(user1.getId()).thenReturn(1);
        Mockito.when(user2.getId()).thenReturn(2);

        Assertions.assertNull(userDatabase.getUserById(3));
        Mockito.verify(user1).getId();
        Mockito.verify(user2).getId();
    }

    @Test
    void getUserByBelowOrEqualZeroIdTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.getUserById(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.getUserById(-1));
    }

    // проблемы как и в тесте выше
    @Test
    void getUserByUsername() {
        Mockito.when(user1.getUsername()).thenReturn("A");
        Mockito.when(user2.getUsername()).thenReturn("B");

        Assertions.assertEquals(user1, userDatabase.getUserByUsername("A"));
        Mockito.verify(user1).getUsername();
        Mockito.verify(user2).getUsername();
    }

    @Test
    void getUnaddedUserByUsername() {
        Mockito.when(user1.getUsername()).thenReturn("A");
        Mockito.when(user2.getUsername()).thenReturn("B");

        Assertions.assertNull(userDatabase.getUserByUsername("C"));
        Mockito.verify(user1).getUsername();
        Mockito.verify(user2).getUsername();
    }

    @Test
    void getUserByNullUsername() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.getUserByUsername(null));
    }

    @Test
    void addUserPositiveTest() {
        Assertions.assertTrue(userDatabase.addUser(user3));
    }

    @Test
    void addDuplicateUserTest() {
        Assertions.assertFalse(userDatabase.addUser(user2));
    }

    @Test
    void addNullUserTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.addUser(null));
    }
}