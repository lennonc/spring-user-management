package users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DbSchema {
  private static final Logger log = LoggerFactory.getLogger(DbSchema.class);

  public static void createUserTable(JdbcTemplate jdbcTemplate) {
    log.info("Create User Table");
    jdbcTemplate.execute("DROP TABLE users IF EXISTS");
    jdbcTemplate.execute("CREATE TABLE users(id SERIAL, firstName VARCHAR(255), lastName VARCHAR(255), email VARCHAR(255), role VARCHAR(255))");
  }

  public static void seedDB(JdbcTemplate jdbcTemplate) {
    List<Object[]> splitUpNames = Arrays.asList("John Woo example@email.com admin", "Jeff Dean", "Josh Bloch example@email.com admin", "Josh Long example@email.com admin").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
    jdbcTemplate.batchUpdate("INSERT INTO users(firstName, lastName, email, role) VALUES (?,?,?,?)", splitUpNames);
  }
}
