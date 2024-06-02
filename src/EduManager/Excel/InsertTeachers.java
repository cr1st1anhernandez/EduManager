package EduManager.Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import EduManager.Controllers.TeacherController;
import EduManager.Entities.Teacher;
import EduManager.DataBase.DatabaseAccess;

public class InsertTeachers {

    public static void main(String[] args) {
        DatabaseAccess dbAccess = new DatabaseAccess();
        TeacherController teacherController = new TeacherController();

        String excelFilePath = "Data.xlsx";
        int batchSize = 20;
        Connection connection = null;

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet secondSheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = secondSheet.iterator();

            connection = DatabaseAccess.getConnection();
            connection.setAutoCommit(false);

            int count = 0;
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                Teacher teacher = new Teacher();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            teacher.setUserId((int) nextCell.getNumericCellValue());
                            break;
                        case 1:
                            teacher.setPassword(nextCell.getStringCellValue());
                            break;
                        case 2:
                            teacher.setFirstName(nextCell.getStringCellValue());
                            break;
                        case 3:
                            teacher.setLastName(nextCell.getStringCellValue());
                            break;
                        case 4:
                            teacher.setEmail(nextCell.getStringCellValue());
                            break;
                        case 5:
                            teacher.setPhoneNumber(nextCell.getStringCellValue());
                            break;
                        case 6:
                            teacher.setCurp(nextCell.getStringCellValue());
                            break;
                        case 7:
                            teacher.setGender(nextCell.getStringCellValue().charAt(0));
                            break;
                        case 8:
                            teacher.setCareer(nextCell.getStringCellValue());
                            break;
                        case 9:
                            teacher.setImagePath(nextCell.getStringCellValue());
                            break;
                    }
                }
		
		teacherController.createTeacher(teacher);

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
