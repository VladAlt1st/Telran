import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {
    private User user;
    @Mock
    private Role role1;
    @Mock
    private Role role2;
    @Mock
    private Role role3;

    @BeforeEach
    void setUp() {
        user = new User(1, "A", "a.@gmail.com", "123");
        user.addRole(role1);
        user.addRole(role2);
    }

    @Test
    void addRolePositiveTest() {
        Assertions.assertTrue(user.addRole(role3));
    }

    @Test
    void addDuplicateRoleTest() {
        Assertions.assertFalse(user.addRole(role2));
    }

    @Test
    void addNullRoleTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.addRole(null));
    }

    @Test
    void removeAddedRoleTest() {
        Assertions.assertTrue(user.removeRole(role2));
    }

    @Test
    void removeUnaddedRoleTest() {
        Assertions.assertFalse(user.removeRole(role3));
    }

    @Test
    void removeNullRoleTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.addRole(null));
    }
}