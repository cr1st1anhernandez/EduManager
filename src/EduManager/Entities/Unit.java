package EduManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
    private int unitId;
    private int subjectId;
    private int teacherId;
    private int studentId;
    private double score;
}
