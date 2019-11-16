package com.ratenow.provatecnica.services;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.ratenow.provatecnica.model.TestGraph;

public class PdfService {

    public PdfService() {
    }

    public static void writeTitleToPDF(TestGraph testGraph, String fileName) {

        PdfWriter writer = null;
        Document document = new Document();
        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 22, BaseColor.BLACK);
            Chunk chunk = new Chunk(testGraph.getTitle(), font);
            document.add(chunk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    public static void writeChartToPDF(TestGraph testGraph, JFreeChart chart, double width, double height, String filePath) {

        PdfWriter writer = null;
        Document document = new Document();

        try {
            String fileName = filePath + testGraph.getTitle() + ".pdf";
            writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate((int) width, (int) height);

            Graphics2D graphics2d = new PdfGraphics2D(contentByte, (int) width, (int) height, new DefaultFontMapper());
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);

            chart.draw(graphics2d, rectangle2d, null, null);

            graphics2d.dispose();
            contentByte.addTemplate(template, 0, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    public static void generationImageBarChar(JFreeChart chart, String filePath, String title) throws IOException {

        String fileName = filePath + title + ".png";
        ChartUtilities.saveChartAsPNG(new File(fileName), chart, 500, 400);
    }
}
