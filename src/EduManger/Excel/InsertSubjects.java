package EduManger.Excel;

import EduManager.Controllers.SubjectController;
import EduManager.Entities.Subject;
import EduManager.DataBase.DatabaseAccess;

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

public class InsertSubjects {

    public static void main(String[] args) throws SQLException {
        SubjectController subjectController = new SubjectController();
        DatabaseAccess dbAccess = new DatabaseAccess();
        Connection connection = null;

        try {
            String excelFilePath = "Data.xlsx";
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(4);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DatabaseAccess.getConnection();
            connection.setAutoCommit(false);

            int batchSize = 20;
            int count = 0;
            rowIterator.next(); // Saltar la fila de encabezado

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Cell idCell = nextRow.getCell(0);
                Cell nameCell = nextRow.getCell(1);

                int subjectId = (int) idCell.getNumericCellValue();
                String subjectName = nameCell.getStringCellValue();

                Subject subject = new Subject();
                subject.setSubjectId(subjectId);
                subject.setName(subjectName);
		
		subjectController.createSubject(subject);

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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
