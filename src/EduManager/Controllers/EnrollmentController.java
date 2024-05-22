package EduManager.Controllers;
import java.util.List;
import java.util.stream.Collectors;

import EduManager.DataBase.Database;
import EduManager.Entities.Enrollment;

public class EnrollmentController {

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        List<Enrollment> allEnrollments = Database.getEnrollments();

        List<Enrollment> filteredEnrollments = allEnrollments.stream()
                .filter(enrollment -> enrollment.getStudentId() == studentId)
                .collect(Collectors.toList());

        return filteredEnrollments;
    }

}
