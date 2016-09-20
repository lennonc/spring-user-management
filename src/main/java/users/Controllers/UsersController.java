package users;

import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import users.User;

@RestController
public class UsersController {

  @Autowired
  private UserDAO userDAO;

  @RequestMapping(value="/users", method=RequestMethod.GET, produces="application/json")
  public List<User> listUsers() {
    List<User> userList = userDAO.list();
    return userList;
  }

  @RequestMapping(value = "/users/new", method = RequestMethod.POST)
  public ModelAndView saveContact(@RequestBody User user) {
    userDAO.saveOrUpdate(user);
    return user;
  }
}
