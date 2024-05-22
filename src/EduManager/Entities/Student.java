package EduManager.Entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student extends User {

	private String career;
	private Date birthDate;
	private char gender;
	private String curp;
	private int semester;

	public Student(int userId, String password, String firstName, String lastName, String email, String phoneNumber, String curp, Date birthDate, char gender, String career, int semester) {
		super(userId, password, firstName, lastName, email, phoneNumber);
		this.career = career;
		this.birthDate = birthDate;
		this.gender = gender;
		this.curp = curp;
		this.semester = semester;
	}
}
