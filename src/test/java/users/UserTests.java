package users;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserTests {
  @Test
  public void shouldCreateNewUserObject() {
    String firstName = "Lennon";
    String lastName = "Chimbumu";
    String email = "lennon@us.gov";
    String role = "Jedi in Training";

    User user = new User(firstName, lastName, role, email);

    assertEquals(user.getFirstName(), firstName);
    assertEquals(user.getLastName(), lastName);
    assertEquals(user.getEmail(), email);
    assertEquals(user.getRole(), role);
  }
}
