package EduManager.Entities;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coordinator extends User {

	private String area;
	private Date birthDate;
	private char gender;
	private String curp;

	public Coordinator(int userId, String password, String firstName, String lastName, String email, String phoneNumber, String curp, Date birthDate, char gender, String area) {
		super(userId, password, firstName, lastName, email, phoneNumber);
		this.area = area;
	}
}
