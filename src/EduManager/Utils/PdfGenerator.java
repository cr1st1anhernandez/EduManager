package EduManager.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.HorizontalAlignment;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.mail.MessagingException;

import EduManager.Entities.GroupSubject;
import java.time.LocalDate;

public class PdfGenerator {
	
	private String userName;
	private String career;
	private LocalDate date = LocalDate.now();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormat = date.format(format);

	public void sendPdfByEmail(String fileName, List<GroupSubject> groupSubjects, String emailTo)
		throws MessagingException {
		generateSchedulePDF(fileName, groupSubjects);

		SendEmail sendEmail = new SendEmail();
		sendEmail.setSubject("🎓 Tu Horario de Clases en EduManager 📚");
		sendEmail.setUserName("Nombre de usuario");
		sendEmail.setContent(
			"Hola "+userName+",\n\n"
			+ "¡Gracias por utilizar EduManager! Has solicitado el envío de tu horario de clases a tu correo electrónico. "
			+ "En el archivo PDF adjunto, encontrarás todos los detalles de tus clases para la próxima semana.\n\n"
			+ "Saludos,\n"
			+ "El equipo de EduManager");
		sendEmail.setAttachment(fileName);
		sendEmail.setEmailTo(emailTo);
		sendEmail.createEmail();
		sendEmail.createEmailWithAttachment();
		sendEmail.sendEmailAsync();
	}

	public void generateSchedulePDF(String fileName, List<GroupSubject> groupSubjects) {
		try (PdfWriter writer = new PdfWriter(new FileOutputStream(fileName)); PdfDocument pdfDoc = new PdfDocument(writer); Document document = new Document(pdfDoc, PageSize.A4)) {

			document.setMargins(20, 20, 20, 20);

			String imagePath = Paths.get(getClass().getResource("/EduManager/Images/logoGreen.png").toURI()).toString();
			DeviceRgb bodyColor = new DeviceRgb(234, 244, 242);
			DeviceRgb headerColor = new DeviceRgb(13, 147, 136);
			DeviceRgb paragraphColor = new DeviceRgb(102, 102, 102);
			ImageData imageData = ImageDataFactory.create(imagePath);
			Image logo = new Image(imageData).scaleToFit(40, 40);

			float[] headerColumnWidths = {1, 11};
			Table headerTable = new Table(UnitValue.createPercentArray(headerColumnWidths)).useAllAvailableWidth();

			Cell logoCell = new Cell().add(logo);
			logoCell.setVerticalAlignment(com.itextpdf.layout.properties.VerticalAlignment.MIDDLE);
			logoCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

			Paragraph title = new Paragraph("Horario de clases")
				.setFontSize(28)
				.setBold()
				.setVerticalAlignment(com.itextpdf.layout.properties.VerticalAlignment.MIDDLE);

			Cell titleCell = new Cell().add(title);
			titleCell.setVerticalAlignment(com.itextpdf.layout.properties.VerticalAlignment.MIDDLE);
			titleCell.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

			headerTable.addCell(logoCell);
			headerTable.addCell(titleCell);

			document.add(headerTable);

			Paragraph paragraph = new Paragraph(
				"Nombre: "+ userName + "\n"
				+ "Carrera: " + career +"\n"
				+ "Fecha: " + dateFormat)
				.setFontSize(12)
				.setFontColor(paragraphColor)
				.setBold();
			document.add(paragraph);

			float[] columnWidths = {1, 2, 1, 1, 2};
			Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();

			table.addHeaderCell(changeBackgroundCell("Días de la semana", headerColor));
			table.addHeaderCell(changeBackgroundCell("Materia", headerColor));
			table.addHeaderCell(changeBackgroundCell("Hora", headerColor));
			table.addHeaderCell(changeBackgroundCell("Grupo", headerColor));
			table.addHeaderCell(changeBackgroundCell("Profesor", headerColor));

			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

			for (GroupSubject groupSubject : groupSubjects) {
				table.addCell(changeBackgroundCell(groupSubject.getFullDaysOfWeek(), bodyColor));
				table.addCell(changeBackgroundCell(groupSubject.getSubjectName(), bodyColor));
				table.addCell(changeBackgroundCell(groupSubject.getStartTime() + "-" + groupSubject.getEndTime(), bodyColor));
				table.addCell(changeBackgroundCell(String.valueOf(groupSubject.getGroupSubjectId()), bodyColor));
				table.addCell(changeBackgroundCell(groupSubject.getTeacherName(), bodyColor));
			}

			document.add(table);

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private Cell changeBackgroundCell(String content, DeviceRgb backgroundColor) {
		Paragraph paragraph = new Paragraph(content);

		Cell cell = new Cell().add(paragraph);
		if (backgroundColor != null) {
			cell.setBackgroundColor(backgroundColor);
		}

		cell.setPadding(5);
		return cell;
	}
	public void setCareer(String career){
		this.career = career;
	}
	public void setUsername(String userName){
		this.userName = userName;
	}
}
