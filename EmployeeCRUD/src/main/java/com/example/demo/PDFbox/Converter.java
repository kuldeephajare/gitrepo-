package com.example.demo.PDFbox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

@Test
public class Converter {
	public void converFile() throws IOException
	{
	
	
	
	String pdfFile = "C:\\Users\\Admin\\Desktop\\temp\\mypdf.pdf";
	
	PDDocument doc=PDDocument.load(new File(pdfFile));
	
	String filename="word.txt";
	
	File file=new File(filename);
	
	if(!file.exists())
	{
		file.createNewFile();
	
	
	
	}
	 FileOutputStream fos = new FileOutputStream(filename);
	 
	 Writer writer=new OutputStreamWriter(fos);
	 
	 PDFTextStripper striper=new PDFTextStripper();
	 striper.setSortByPosition(true);
	 striper.writeText(doc, writer);
	 
	 writer.close();
	 doc.close();

}

}
