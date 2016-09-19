package users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... strings) throws Exception {
    setupDB();
    seedDB();
  }

  private void seedDB() {
    List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
    jdbcTemplate.batchUpdate("INSERT INTO users(firstName, lastName) VALUES (?,?)", splitUpNames);
  }

  private void setupDB() {
    log.info("Initializing Database");

    jdbcTemplate.execute("DROP TABLE users IF EXISTS");
    jdbcTemplate.execute("CREATE TABLE users(" +
                "id SERIAL, firstName VARCHAR(255), lastName VARCHAR(255), email VARCHAR(255), role VARCHAR(255))");
  }
}
