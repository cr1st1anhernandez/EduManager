package EduManager.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.GroupSubject;

public class GroupSubjectController {
    List<GroupSubject> groupSubjects = new ArrayList<>();

    private static final Map<Character, String> dayMap = new HashMap<>();

    static {
        dayMap.put('L', "Lunes");
        dayMap.put('M', "Martes");
        dayMap.put('X', "Miércoles");
        dayMap.put('J', "Jueves");
        dayMap.put('V', "Viernes");
        dayMap.put('S', "Sábado");
        dayMap.put('D', "Domingo");
    }

    private static String convertDaysOfWeek(String abbreviatedDays) {
        StringBuilder fullDays = new StringBuilder();
        for (char day : abbreviatedDays.toCharArray()) {
            String fullDay = dayMap.get(day);
            if (fullDay != null) {
                if (fullDays.length() > 0) {
                    fullDays.append(" ");
                }
                fullDays.append(fullDay);
            }
        }
        return fullDays.toString();
    }

    public List<GroupSubject> getGroupsSubjects() {
        groupSubjects = new ArrayList<>();
        try {
            DatabaseAccess.connect();
            String query = "SELECT gs.groupSubjectId, gs.groupId, gs.subjectId, s.name AS subjectName, gs.startTime, gs.endTime, gs.teacherId, "
                    + "CONCAT(t.firstName, ' ', t.lastName) AS teacherName, gs.daysOfWeek, gs.vacancies, gs.capacity "
                    + "FROM GroupSubject gs "
                    + "JOIN Subject s ON gs.subjectId = s.subjectId "
                    + "JOIN Teacher t ON gs.teacherId = t.teacherId";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GroupSubject groupSubject = new GroupSubject();
                groupSubject.setGroupSubjectId(resultSet.getInt("groupSubjectId"));
                groupSubject.setGroupId(resultSet.getString("groupId"));
                groupSubject.setSubjectId(resultSet.getInt("subjectId"));
                groupSubject.setSubjectName(resultSet.getString("subjectName"));
                groupSubject.setStartTime(resultSet.getTime("startTime"));
                groupSubject.setEndTime(resultSet.getTime("endTime"));
                groupSubject.setTeacherId(resultSet.getInt("teacherId"));
                groupSubject.setTeacherName(resultSet.getString("teacherName"));
                groupSubject.setDaysOfWeek(resultSet.getString("daysOfWeek"));
                groupSubject.setVacancies(resultSet.getInt("vacancies"));
                groupSubject.setCapacity(resultSet.getInt("capacity"));
                groupSubject.setFullDaysOfWeek(convertDaysOfWeek(resultSet.getString("daysOfWeek")));
                groupSubjects.add(groupSubject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return groupSubjects;
    }

    public List<GroupSubject> getGroupsBySemester(int semester) {
        String semesterPrefix = semester + "";
        return getGroupsSubjects().stream()
                .filter(gs -> gs.getGroupId().startsWith(semesterPrefix))
                .collect(Collectors.toList());
    }

    public List<GroupSubject> getGroupsBySemesterAndTime(int semester, String time) {
        LocalTime specifiedTime = LocalTime.parse(time);
        String semesterPrefix = semester + "";
        return getGroupsSubjects().stream()
                .filter(gs -> gs.getGroupId().startsWith(semesterPrefix) &&
                        gs.getStartTime().toLocalTime().equals(specifiedTime))
                .collect(Collectors.toList());
    }

    public GroupSubject getGroupSubjectById(int groupSubjectId) {
        for (GroupSubject groupSubject : getGroupsSubjects()) {
            if (groupSubject.getGroupSubjectId() == groupSubjectId) {
                return groupSubject;
            }
        }
        return null;
    }

    public List<GroupSubject> getGroupsSubjectsByTeacherId(int teacherId) {
        return getGroupsSubjects().stream()
                .filter(gs -> gs.getTeacherId() == teacherId)
                .collect(Collectors.toList());
    }

    public boolean updateVacancies(int groupSubjectId, int vacanciesChange) {
        try {
            DatabaseAccess.connect();
            String query = "UPDATE GroupSubject SET vacancies = vacancies + ? WHERE groupSubjectId = ?";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, vacanciesChange);
            preparedStatement.setInt(2, groupSubjectId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

    public int getVacancies(int groupSubjectId) {
        try {
            DatabaseAccess.connect();
            String query = "SELECT vacancies FROM GroupSubject WHERE groupSubjectId = ?";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, groupSubjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("vacancies");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return -1;
    }
}
