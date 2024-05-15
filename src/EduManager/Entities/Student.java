package EduManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student extends User {
  private int studentId;
  private String career;
  public Student(int studentId, String name, String curp, String email, String career, String password) {
    super(name, curp, email, career, password);
    this.studentId = studentId;
    this.career = career;
  }
}
