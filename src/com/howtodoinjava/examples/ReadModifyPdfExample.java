package com.howtodoinjava.examples;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadModifyPdfExample {

  public static void main(String[] args) {
    try {
      //Read file using PdfReader
      PdfReader pdfReader = new PdfReader("pdf-image.pdf");

      //Modify file using PdfReader
      PdfStamper pdfStamper = new PdfStamper(pdfReader,
          new FileOutputStream("pdf-image-Updated.pdf"));

      ColumnText ct = new ColumnText(pdfStamper.getUnderContent(pdfReader.getNumberOfPages()));
      // this are the coordinates where you want to add text
      // if the text does not fit inside it will be cropped
      ct.setSimpleColumn(50, 500, 500, 50);
      ct.setText(new Phrase("Mot hai ba bon nam sau"));
      ct.setText(new Phrase("Mot hai ba bon nam sau"));
      ct.setText(new Phrase("Mot hai ba bon nam sau"));
      ct.go();
      System.out.println("Insert data into pdf success!");
      pdfStamper.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
}
