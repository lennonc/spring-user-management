package users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DbSchema {
  @Autowired
  JdbcTemplate jdbcTemplate;

  private static final Logger log = LoggerFactory.getLogger(DbSchema.class);

  public void createDB() {
    
  }
}
