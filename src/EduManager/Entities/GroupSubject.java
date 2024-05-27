package EduManager.Entities;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupSubject {
    private String groupId;
    private int groupSubjectId;
    private String subjectName;
    private String teacherName;
    private int subjectId;
    private Time startTime;
    private Time endTime;
    private int teacherId;
    private String daysOfWeek;
    private String fullDaysOfWeek;
    private int capacity;
    private int vacancies;
}