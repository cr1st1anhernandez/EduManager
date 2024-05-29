package EduManager.Utils;

import EduManager.Entities.GroupSubject;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PdfGenerator {

    public void generateSchedulePDF(String fileName, List<GroupSubject> groupSubjects) {
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream(fileName));
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc, PageSize.A4);
            document.setMargins(5, 5, 5, 5);

            Paragraph title = new Paragraph("Horario del Estudiante")
                    .setFontSize(20);
            document.add(title);

            float[] columnWidths = {100, 200, 100, 100, 200};
            Table table = new Table(columnWidths);

            DeviceRgb customColor = new DeviceRgb(13, 147, 136);

            table.addHeaderCell(new Cell().add(new Paragraph("Días de la semana").setBackgroundColor(customColor)));
            table.addHeaderCell(new Cell().add(new Paragraph("Materia").setBackgroundColor(customColor)));
            table.addHeaderCell(new Cell().add(new Paragraph("Hora").setBackgroundColor(customColor)));
            table.addHeaderCell(new Cell().add(new Paragraph("Grupo").setBackgroundColor(customColor)));
            table.addHeaderCell(new Cell().add(new Paragraph("Profesor").setBackgroundColor(customColor)));

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

            for (GroupSubject groupSubject : groupSubjects) {
                table.addCell(new Cell().add(new Paragraph(groupSubject.getFullDaysOfWeek())));
                table.addCell(new Cell().add(new Paragraph(groupSubject.getSubjectName())));
                table.addCell(new Cell().add(new Paragraph(groupSubject.getStartTime() + "-" + groupSubject.getEndTime())));
                table.addCell(new Cell().add(new Paragraph(groupSubject.getGroupSubjectId() + "")));
                table.addCell(new Cell().add(new Paragraph(groupSubject.getTeacherName())));
            }

            document.add(table);
            document.close();
        } catch (IOException e) {
            
        }
    }
}
