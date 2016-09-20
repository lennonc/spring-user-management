package users;

import java.util.List;
import users.User;

 public interface UserDAO {
   public void saveOrUpdate(User user);

   public void delete(int userId);

   public User get(int userId);

   public List<User> list();
 }
