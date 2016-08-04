package it.estia.controller.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.estia.entity.Policy;


public class PdfMaker {
	
  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

  
  public String getPdf(Policy policyToPrint) throws FileNotFoundException, DocumentException
  {
	  SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yy_hhmmss");
	  String tempdir = System.getProperty("java.io.tmpdir")+"//"+sf.format(new Date())+"_"+policyToPrint.getCity()+".pdf";
	  
	  Document document = new Document();
	  PdfWriter.getInstance(document, new FileOutputStream(tempdir));
	  document.open();
	  
	  addTitlePage(document, policyToPrint);
	  addMetaData(document);
	  
	  document.close();
	  
	  return tempdir;
  }
  
//---------------------------------------------
  
  // iText allows to add metadata to the PDF which can be viewed in your Adobe
  // Reader
  // under File -> Properties
  private static void addMetaData(Document document)
  {
    document.addTitle("Policy");
    document.addAuthor("Estia");
    document.addCreator("Riccardo Bobbo");
  }

  private static void addTitlePage(Document document, Policy policyToAdd) throws DocumentException
  {
    Paragraph preface = new Paragraph();
    // We add one empty line
    addEmptyLine(preface, 1);
    // Lets write a big header
    preface.add(new Paragraph("Polizza stampata il giorno "+new Date(), catFont));
    
    addEmptyLine(preface, 3);
    preface.add(new Paragraph("Città : "+policyToAdd.getCity(), smallBold));
    preface.add(new Paragraph("Inizio polizza : "+policyToAdd.getDatestart(), smallBold));
    preface.add(new Paragraph("Fine polizza: "+policyToAdd.getDatefinish(), smallBold));
    preface.add(new Paragraph("Passeggeri : "+policyToAdd.getPasengernumber(), smallBold));
    
    Paragraph paragraph = new Paragraph();
    addEmptyLine(paragraph, 5);
    preface.add(paragraph);
    preface.add(new Paragraph("Questo documento non ha valore legale", redFont));

    document.add(preface);
    // Start a new page
    document.newPage();
  }

  private static void addEmptyLine(Paragraph paragraph, int number)
  {
    for (int i = 0; i < number; i++)
    {
      paragraph.add(new Paragraph(" "));
    }
  }
  
  
} 