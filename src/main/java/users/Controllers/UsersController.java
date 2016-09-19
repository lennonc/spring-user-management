package users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {

  @RequestMapping("/users")
  public User user(@RequestParam(value="name", defaultValue="1") String name) {
    String firstName = "Lennon";
    String lastName = "Chimbumu";
    String email = "lennon@us.gov";
    String role = "Jedi in Training";

    return new User(firstName, lastName, role, email);
  }
}
