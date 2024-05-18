package EduManager.Controllers;

import EduManager.DataBase.Database;
import EduManager.Entities.Admin;
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
    static Admin admin;

    public static User getUser() {
        return user;
    }
    
    public static Admin getAdmin() {
        return admin;
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

    public static boolean login(String username, String password) {
        user = Database.login(username, password);
        
        student = null;
        teacher = null;
        coordinator = null;
	admin = null;

        if (user instanceof Student) {
            student = (Student) user;
        } else if (user instanceof Teacher) {
            teacher = (Teacher) user;
        } else if (user instanceof Coordinator) {
            coordinator = (Coordinator) user;
        } else if(user instanceof Admin){
	    admin = (Admin) user;
	}

        return user != null;
    }

    public static void logout() {
        user = null;
        student = null;
        teacher = null;
        coordinator = null;
	admin = null;
    }
}

