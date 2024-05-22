package EduManager.Controllers;
import EduManager.DataBase.Database;
import EduManager.Entities.GroupSubject;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupSubjectController {
    List<GroupSubject> groupSubjects = new ArrayList<>();

    public List<GroupSubject> getGroupsSubjects() {
	    return groupSubjects = Database.getGroupsSubjects();
    }
    public List<GroupSubject> getGroupsBySemester(int semester) {
        String semesterPrefix = semester + ""; 
        return Database.getGroupsSubjects().stream()
                .filter(gs -> gs.getGroupId().startsWith(semesterPrefix))
                .collect(Collectors.toList());
    }

    public List<GroupSubject> getGroupsBySemesterAndTime(int semester, String time) {
        LocalTime specifiedTime = LocalTime.parse(time);
        String semesterPrefix = semester + "";
        return Database.getGroupsSubjects().stream()
                .filter(gs -> gs.getGroupId().startsWith(semesterPrefix) &&
                              gs.getStartTime().toLocalTime().equals(specifiedTime))
                .collect(Collectors.toList());
    }
}