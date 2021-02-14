package com.jana.creditreportmodel.report.pdf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.jana.creditreportmodel.entity.CustomersEntity;

@Service
public class PdfReportGeneratorImpl implements ReportGenerator {

	@Override
	public byte[] generatePdfReport(CustomersEntity customersEntity, LocalDate generateDate) {
		   ByteArrayOutputStream out= new ByteArrayOutputStream();
	        generatePdfcontent(customersEntity, generateDate, out);
	        return out.toByteArray();
	}


	private void generatePdfcontent(CustomersEntity customersEntity, LocalDate generateDate,
			OutputStream out) {
		Document document = null;
        try {
        	
        //Document is not auto-closable hence need to close it separately
            document = new Document(PageSize.A4);            
           String title=customersEntity.getCustomerName();

            PdfWriter writer = PdfWriter.getInstance(document,out);
          //  writer.getISOBytes(text)
              HeaderFooter event = new HeaderFooter();
              event.setHeader("Test Report");
              writer.setPageEvent(event);
            document.open();
            PDFCreator.addMetaData(document, title);
            PDFCreator.addTitlePage(document, customersEntity);
            PDFCreator.addContent(document, customersEntity.getOrdersEntityList(),generateDate);
        }catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }
        }
	}




	

	

}
