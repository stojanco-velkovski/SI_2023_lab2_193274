import org.example.SILab2;
import org.example.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SILab2Test {

    User user = null;
    List<User> allUsers = null;

    @Test
    public void test1() {
        assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    public void test2() {
        User user = new User(null, "123", "@test.com");
        List<User> allUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allUsers.add(new User(null, "123", null));
        }
        allUsers.add(new User(null, "123", null)); // existing user with same password

        boolean result = SILab2.function(user, allUsers);

        assertFalse(result);
    }

    @Test
    public void test3() {
        User user = new User("stojanco", "123", "test.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User(null, "123321312312312", null));

        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    public void test4() {
        User user = new User("stoja nco", "12@3", "@test.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("stojanco", "123321312312312", null));

        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    public void test5() {
        User user = new User("stoja nco", "123", "@test.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("stojanco", "123321312312312", null));

        boolean result = SILab2.function(user, allUsers);

        assertFalse(result);
    }
}
