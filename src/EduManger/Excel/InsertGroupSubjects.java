package EduManger.Excel;

import EduManager.Controllers.GroupSubjectController;
import EduManager.Entities.GroupSubject;
import EduManager.DataBase.DatabaseAccess;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class InsertGroupSubjects {

	public static Time covertToTime(double tiempoExcel) {

		long milisegundos = (long) (tiempoExcel * 24 * 60 * 60 * 1000);

		return new Time(milisegundos - TimeZone.getDefault().getRawOffset());
	}

	public static void main(String[] args) throws SQLException, ParseException {
		GroupSubjectController groupSubjectController = new GroupSubjectController();

		String excelFilePath = "Data.xlsx";
		int batchSize = 200;
		Connection connection = null;
		DatabaseAccess dbAccess = new DatabaseAccess();

		try {
			long start = System.currentTimeMillis();

			FileInputStream inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(5);
			Iterator<Row> rowIterator = sheet.iterator();

			connection = DatabaseAccess.getConnection();
			connection.setAutoCommit(false);

			int count = 0;
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				GroupSubject groupSubject = new GroupSubject();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
						case 0:
							groupSubject.setGroupSubjectId((int) nextCell.getNumericCellValue());
							break;
						case 1:
							groupSubject.setGroupId(nextCell.getStringCellValue());
							break;
						case 2:
							groupSubject.setSubjectId((int) nextCell.getNumericCellValue());
							break;
						case 3:
							double startTimeValue = nextCell.getNumericCellValue();
							groupSubject.setStartTime(covertToTime(startTimeValue));
						case 4:
							double endTimeValue = nextCell.getNumericCellValue();
							groupSubject.setEndTime(covertToTime(endTimeValue));
						case 5:
							groupSubject.setTeacherId((int) nextCell.getNumericCellValue());
							break;
						case 6:
							groupSubject.setDaysOfWeek(nextCell.getStringCellValue());
							break;
						case 7:
							groupSubject.setCapacity((int) nextCell.getNumericCellValue());
							break;
						case 8:
							groupSubject.setVacancies((int) nextCell.getNumericCellValue());
							break;

					}
				}
				groupSubjectController.addGroupSubject(groupSubject);

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
