package users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
  private String firstName, lastName, role, email;
  private int userID;

  public User(String firstName, String lastName, String role, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.email = email;
  }

  public int count() {
    String query = "Select count(id) from users;";
    return 0;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getRole() {
    return this.role;
  }
}
