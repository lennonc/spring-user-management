package users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {
  private String firstName, lastName, role, email;
  private int id;

  private static final Logger log = LoggerFactory.getLogger(User.class);
  private JdbcTemplate jdbcTemplate;

  public User() {

  }

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

  public int getId() {
    return this.id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setRole(String role) {
    this.role = role;
  }

//   public static void getAllUsers() {
//     String query = "Select * from users;";
//     log.info(query);
// ;
//     jdbcTemplate.query(query, (rs, rowNum) -> new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("role"))).forEach(user -> log.info(user.toString()));
//   }

  @Override
  public String toString() {
    String template = "User{firstName='%s', lastName='%s'}";
    return String.format(template, firstName, lastName);
  }
}
