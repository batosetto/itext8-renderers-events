package chapter3;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;



public class DocumentRenderer {

    public static final String DEST = "results/chapter03/documentRenderer.pdf";
    public static final String C_EV_TEXT = "src/main/resources/data/C_Evolution.txt";
    public static final String C_EV_IMG = "src/main/resources/img/evolution_C.jpg";
    public static final String FRAME_TEXT = "src/main/resources/data/frameworks.txt";
    public static final String FRAME_IMG = "src/main/resources/img/javaFrame.jpg";
    public static final String JAVA_TEXT = "src/main/resources/data/java.txt";
    public static final String JAVA_IMG = "src/main/resources/img/java.jpg";
    public static final String SIMILARITITES_TEXT = "src/main/resources/data/Similarities_C#_Java.txt";
    public static final String SIMILARITITES_IMG = "src/main/resources/img/javaAndC#.jpg";

    static PdfFont timesNewRoman = null;
    static PdfFont timesNewRomanBold = null;

    public static void main(String[] args) throws IOException {
        timesNewRoman = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        timesNewRomanBold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new DocumentRenderer().createPdf(DEST);
    }

    protected void createPdf(String dest) throws IOException{
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A4;
        Document document = new Document(pdf, ps);

        float offSet = 36;
        float columnHeight = ps.getHeight() - offSet * 2;
        float columnWidth = (ps.getWidth() - offSet * 2 + 10) / 4;

        Rectangle[] columns = {
                new Rectangle(offSet - 5, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth, offSet, columnWidth, columnHeight),
                new Rectangle((offSet + columnWidth) * 2 + 5, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth * 3 + 5, offSet, columnWidth, columnHeight)
        };
        document.setRenderer(new ColumnDocumentRenderer(document, columns));

        Image java_img  = new Image(ImageDataFactory.create(JAVA_IMG)).setWidth(columnWidth);
        String java_text = new String(Files.readAllBytes(Paths.get(JAVA_TEXT)), StandardCharsets.UTF_8);
        DocumentRenderer.addArticle(document, "The Java Revolution", "Gepeto, the Best, 2024", java_img, java_text);

        Image frame_img = new Image(ImageDataFactory.create(FRAME_IMG)).setWidth(columnWidth);
        String frame_text = new String(Files.readAllBytes(Paths.get(FRAME_TEXT)), StandardCharsets.UTF_8);
        DocumentRenderer.addArticle(document, "Java Frameworks Shaping the Future", "Gepeto, the Best, 2024", frame_img, frame_text);

        Image c_evolution_img = new Image(ImageDataFactory.create(C_EV_IMG)).setWidth(columnWidth);
        String c_evolution_text = new String(Files.readAllBytes(Paths.get(C_EV_TEXT)), StandardCharsets.UTF_8);
        DocumentRenderer.addArticle(document, "The Evolution of C Language","Gepeto, the Best, 2024", c_evolution_img, c_evolution_text);

        Image similarities_img = new Image(ImageDataFactory.create(SIMILARITITES_IMG)).setWidth(columnWidth);
        String similarities_text = new String(Files.readAllBytes(Paths.get(SIMILARITITES_TEXT)), StandardCharsets.UTF_8);
        DocumentRenderer.addArticle(document, "Similarities Between Java and C#", "Gepeto, the Best, 2024", similarities_img, similarities_text);

        document.close();
    }

    public static void addArticle(
            Document doc, String title, String author,Image img, String text) throws IOException{
        Paragraph p1 = new Paragraph(title)
                .setFont(timesNewRomanBold)
                .setFontSize(14);
        doc.add(p1);
        doc.add(img);

        Paragraph p2 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(7)
                .setFontColor(ColorConstants.GRAY)
                .add(author);
        doc.add(p2);

        Paragraph p3 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(10)
                .add(text);
        doc.add(p3);
    }

}
