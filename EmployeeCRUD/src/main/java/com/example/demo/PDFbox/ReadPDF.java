package com.example.demo.PDFbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import org.testng.annotations.Test;

public class ReadPDF {

	@Test
	public void readPDFfile() throws Exception {

		PDDocument document = new PDDocument(); // created new document

		PDPage page = new PDPage();

		document.addPage(page);

		PDImageXObject image = PDImageXObject.createFromFile("C:\\Users\\Admin\\Desktop\\temp\\merce.jpg", document);

		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.drawImage(image, 50, 600);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
		contentStream.setLeading(16);
		contentStream.newLineAtOffset(50, page.getTrimBox().getHeight() - 200);

		String text1 = "We are not your typical tech office which looks like the cast and crew of The Big Bang Theory.";
		contentStream.showText(text1);
		contentStream.newLine();

		String text2 = " Tech is what we do, not who we are.";
		contentStream.showText(text2);
		contentStream.newLine();

		String text3 = " We are real people who dream of traffic-free days and daydream about biryani or beer.";
		contentStream.showText(text3);
		contentStream.newLine();

		contentStream.close();

		document.save("C:\\Users\\Admin\\Desktop\\temp\\mypdf.pdf");

		document.close();

	}

}
