package EduManger.Excel;

import EduManager.Controllers.CoordinatorController;
import EduManager.Entities.Coordinator;
import EduManager.DataBase.DatabaseAccess;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class InsertCoordinators {

    public static void main(String[] args) throws SQLException {
        DatabaseAccess dbAccess = new DatabaseAccess();
        CoordinatorController coordinatorController = new CoordinatorController();

        String excelFilePath = "Data.xlsx";
        int batchSize = 20;
        Connection connection = null;

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(2);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DatabaseAccess.getConnection();
            connection.setAutoCommit(false);

            int count = 0;
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                Coordinator coordinator = new Coordinator();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            coordinator.setUserId((int) nextCell.getNumericCellValue());
                            break;
                        case 1:
                            coordinator.setPassword(nextCell.getStringCellValue());
                            break;
                        case 2:
                            coordinator.setFirstName(nextCell.getStringCellValue());
                            break;
                        case 3:
                            coordinator.setLastName(nextCell.getStringCellValue());
                            break;
                        case 4:
                            coordinator.setEmail(nextCell.getStringCellValue());
                            break;
                        case 5:
                            coordinator.setPhoneNumber(nextCell.getStringCellValue());
                            break;
                        case 6:
                            coordinator.setCurp(nextCell.getStringCellValue());
                            break;
                        case 7:
                            coordinator.setGender(nextCell.getStringCellValue().charAt(0));
                            break;
                        case 8:
                            coordinator.setArea(nextCell.getStringCellValue());
                            break;
                        case 9:
                            coordinator.setImagePath(nextCell.getStringCellValue());
                            break;
                    }
                }
		coordinatorController.createCoordinator(coordinator);

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
