package EduManager.Entities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.mail.internet.ParseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupSubject {

	private String groupId;
	private int groupSubjectId;
	private String subjectName;
	private String teacherName;
	private int subjectId;
	private Time startTime;
	private Time endTime;
	private int teacherId;
	private String daysOfWeek;
	private String fullDaysOfWeek;
	private int capacity;
	private int vacancies;

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public void setStartTime(String startTimeStr) throws java.text.ParseException {
		this.startTime = convertStringToTime(startTimeStr);
	}

	public void setEndTime(String endTimeStr) throws java.text.ParseException {
		this.endTime = convertStringToTime(endTimeStr);
	}

	private Time convertStringToTime(String timeStr) throws java.text.ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		java.util.Date parsed = format.parse(timeStr);
		return new Time(parsed.getTime());
	}
}
