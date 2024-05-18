package EduManager.Entities;

import java.sql.Time;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupSubject {
    private String groupId;
    private int subjectId;
    private Time startTime;
    private Time endTime;
    private int teacherId;
    private int studentId;
}