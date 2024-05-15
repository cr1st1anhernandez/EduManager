package EduManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coordinator extends User {
  private int coordinatorId;
  private String area;
  public Coordinator(int coordinatorId, String name, String curp, String email, String area, String password) {
    super(name, curp, email, area, password);
    this.coordinatorId = coordinatorId;
    this.area = area;
  }
}
