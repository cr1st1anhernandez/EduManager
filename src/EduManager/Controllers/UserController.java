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
	  if (user == null)
		return false;
	  return true;
  }

  /*public static boolean login(String username, String password) {
    user = Database.login(username, password);
    if (user == null)
      return false;
    if (user instanceof Student) {
      student = (Student) user;
      StudentView student = new StudentView();
      student.setVisible(true);
    } else if (user instanceof Teacher) {
      teacher = (Teacher) user;
      TeacherView teacher = new TeacherView();
      teacher.setVisible(true);
    } else if (user instanceof Coordinator) {
      coordinator = (Coordinator) user;
      CoordinatorView coordinator = new CoordinatorView();
      coordinator.setVisible(true);
    }
    return true;
  }*/

  public static void registerUser(String userType, Integer userId, String name,
      String curp, String email, String career, String password) {
    Database.createUser(userType, userId, name, curp, email, career, password);
  }

  public static void logout() {
    /*LoginView login = new LoginView();
    login.setVisible(true);
    user = null;*/
  }
}
