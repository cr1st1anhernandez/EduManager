package EduManager.Controllers;

import EduManager.DataBase.Database;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import lombok.Data;

@Data
public class UserController {
  static Student student;
  static User user;
  static Teacher teacher;
  static Coordinator coordinator;

  public static User getUser() {
    return user;
  }

  public static Student getStudent() {
    return student;
  }

  public static Teacher getTeacher() {
    return teacher;
  }

  public static Coordinator getCoordinator() {
    return coordinator;
  }
  
  public static boolean login(String username, String password){
	  user = Database.login(username,password);
	  return user != null;
  }

  public static void logout() {
    user = null;
  }
}
