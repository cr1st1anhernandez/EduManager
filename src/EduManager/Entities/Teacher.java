package EduManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teacher extends User {
  private int teacherId;
  private String career;
  public Teacher(int teacherId, String name, String curp, String email, String career, String password) {
    super(name, curp, email, career, password);
    this.teacherId = teacherId;
    this.career = career;
  }
}
