package EduManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String imagePath;
}
