package EduManager.Excel;

import EduManager.Controllers.GroupController;
import EduManager.Entities.Group;
import EduManager.DataBase.DatabaseAccess;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class InsertGroups {

    public static void main(String[] args) throws SQLException {
        GroupController groupController = new GroupController();

        String excelFilePath = "Data.xlsx";
        int batchSize = 20;
        Connection connection = null;
	DatabaseAccess dbAccess = new DatabaseAccess();

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(3);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DatabaseAccess.getConnection();
            connection.setAutoCommit(false);

            int count = 0;
            rowIterator.next(); // Skip header row
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                Group group = new Group();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            group.setGroupId(nextCell.getStringCellValue());
                            break;
                    }
                }
		
		groupController.createGroup(group);

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
