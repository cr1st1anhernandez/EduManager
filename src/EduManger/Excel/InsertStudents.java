package EduManger.Excel;

import EduManager.Controllers.StudentController;
import EduManager.Entities.Student;
import EduManager.DataBase.DatabaseAccess;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class InsertStudents {

	public static void main(String[] args) throws SQLException {
		DatabaseAccess dbAccess = new DatabaseAccess();
		StudentController studentController = new StudentController();

		String excelFilePath = "Data.xlsx";
		int batchSize = 20;
		Connection connection = null;

		try {
			long start = System.currentTimeMillis();

			FileInputStream inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();

			connection = DatabaseAccess.getConnection();
			connection.setAutoCommit(false);

			int count = 0;
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				Student student = new Student();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
						case 0:
							student.setUserId((int) nextCell.getNumericCellValue());
							break;
						case 1:
							student.setPassword(nextCell.getStringCellValue());
							break;
						case 2:
							student.setFirstName(nextCell.getStringCellValue());
							break;
						case 3:
							student.setLastName(nextCell.getStringCellValue());
							break;
						case 4:
							student.setEmail(nextCell.getStringCellValue());
							break;
						case 5:
							student.setPhoneNumber(nextCell.getStringCellValue());
							break;
						case 6:
							student.setCurp(nextCell.getStringCellValue());
							break;
						case 7:
							student.setGender(nextCell.getStringCellValue().charAt(0));
							break;
						case 8:
							student.setCareer(nextCell.getStringCellValue());
							break;
						case 9:
							student.setSemester((int) nextCell.getNumericCellValue());
							break;
						case 10:
							student.setImagePath(nextCell.getStringCellValue());
							break;
					}
				}
				studentController.createStudent(student);
				if (++count % batchSize == 0) {
					connection.commit();
				}
			}

			workbook.close();
			connection.commit();
			connection.close();

		} catch (IOException ex1) {
			System.out.println("Error al leer el archivo");
			ex1.printStackTrace();
		} catch (SQLException ex2) {
			System.out.println("Error de base de datos");
			ex2.printStackTrace();
		}
	}
}
