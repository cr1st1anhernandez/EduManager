package EduManager.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
  private int enrollmentId;
  private int studentId;
  private int groupSubjectId;
}
