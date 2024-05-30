package EduManager.Entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teacher extends User {
    private String career;
    private Date birthDate;
    private char gender;
    private String curp;

    public Teacher(int userId, String password, String firstName, String lastName, String email, String phoneNumber, String curp, Date birthDate, char gender, String career, String imagePath) {
        super(userId, password, firstName, lastName, email, phoneNumber, imagePath);
        this.career = career;
        this.birthDate = birthDate;
        this.gender = gender;
        this.curp = curp;
    }
}
