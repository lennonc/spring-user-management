package users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import users.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class UserDAOImpl implements UserDAO {
  private JdbcTemplate jdbcTemplate;

  public UserDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void saveOrUpdate(User user) {
    if (user.getId() > 0) {
      // update
      String query = "UPDATE contact SET firstName=?, lastName=?, email=?, + role=? WHERE id=?";
      jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(), user.getId());
    } else {
      // insert
      String query = "INSERT INTO contact (firstName, lastName, email, role) VALUES (?, ?, ?, ?)";
      jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }
  }

  @Override
  public void delete(int userId) {
    String query = "DELETE FROM contact WHERE id=?";
    jdbcTemplate.update(query, userId);
  }

  @Override
  public List<User> list() {
    String query = "Select * from users";
    List<User> listUser = jdbcTemplate.query(query, new RowMapper<User>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setRole(rs.getString("role"));

        return user;
      }
    });

    return listUser;
  }

  @Override
  public User get(int id) {
    String query = "Select * from users where id =" + id;

    return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

      @Override
      public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          User user = new User();

          user.setId(rs.getInt("id"));
          user.setFirstName(rs.getString("firstName"));
          user.setLastName(rs.getString("lastName"));
          user.setEmail(rs.getString("email"));
          user.setRole(rs.getString("role"));
          return user;
        }
        return null;
      }
    });
  }

}
