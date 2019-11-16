package com.ratenow.provatecnica.services;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;

import org.jfree.chart.JFreeChart;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.awt.geom.Rectangle2D;
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
	
	private static final java.awt.geom.Rectangle2D Rectangle2D = null;

	public PdfService() {}
	
	public static void writeTitleToPDF(TestGraph testGraph, String fileName) {
		
		PdfWriter writer = null;
		Document document = new Document();
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 22, BaseColor.BLACK);
			Chunk chunk = new Chunk(testGraph.getTitle(),font);
			document.add(chunk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}
		
	
	
	public static void writeChartToPDF(TestGraph testGraph, JFreeChart chart, double width, double height, String fileName) {
		
		PdfWriter writer = null;
		Document document = new Document();

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			document.add(new Chunk(testGraph.getTitle(),font));
			document.add(new Chunk(testGraph.toString()));
			PdfContentByte contentByte = writer.getDirectContent();
			PdfTemplate template = contentByte.createTemplate((int)width, (int)height);
			
		//	@SuppressWarnings("deprecation")
		//	Graphics2D graphics2d = template.createGraphics((int)width, (int)height,new DefaultFontMapper());
		//	Rectangle2D rectangle2d = new Rectangle2D.Double(width,height,0,0);
	//		graphics2d.draw((Shape) rectangle2d);
			//rectangle2d.setFrame(width,height,0,0);
	//		chart.draw(graphics2d,Rectangle2D);
			
	//		graphics2d.dispose();
			contentByte.addTemplate(template, 0, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}
}
