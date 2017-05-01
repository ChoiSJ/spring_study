package kr.co.jhta.view;

import java.net.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import kr.co.jhta.vo.*;

import kr.co.jhta.controller.view.AbstractITextPdfView;
 
public class PDFBuilder extends AbstractITextPdfView {
	 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest req, HttpServletResponse res)
            throws Exception {
		System.out.println("---- PdfDownloadView.buildPdfDocument() ----");
		Syllabus syllabus = (Syllabus) model.get("syllabus");
		
		if(syllabus == null) {
			throw new RuntimeException();
		}
		  
		String userAgent = req.getHeader("User-Agent");
		String fileName = syllabus.getSubname() + "_" + syllabus.getName() + ".pdf";
		  
		if(userAgent.indexOf("MSIE") > -1){
			 fileName = URLEncoder.encode(fileName, "utf-8");
		}else{
			 fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		}
		  
		res.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		res.setHeader("Content-Transfer-Encoding", "binary");

    	doc.setPageSize(PageSize.A4);
    	
    	
    	BaseFont baseFont = BaseFont.createFont("c:/Windows/Fonts/malgun.ttf",
    			BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    	Font font = new Font(baseFont, 12);
    	PdfPTable table = new PdfPTable(2);
    	table.setWidthPercentage(100.0f);
    	table.setWidths(new float[] {1.0f, 4.0f});
    	table.setSpacingAfter(10);
    	table.setSpacingBefore(10);
    	
    	Chunk chunk = new Chunk("강의 계획서", font);
    	Paragraph ph = new Paragraph(chunk);
    	ph.setAlignment(Element.ALIGN_CENTER);
    	doc.add(ph);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일");
    	Date date = new Date(); 
    	String today = sdf.format(date);
    	Chunk dateChunk = new Chunk("출력일 : " + today, font);
    	Paragraph ph2 = new Paragraph(dateChunk);
    	ph2.setAlignment(Element.ALIGN_RIGHT);
    	doc.add(ph2);
    	
    	doc.add(Chunk.NEWLINE);     	   	
    	PdfPCell cellName = new PdfPCell(new Phrase("과목", font));
    	cellName.setMinimumHeight(21);
    	cellName.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell subjectName = new PdfPCell(new Phrase(syllabus.getSubname(), font));
    	table.addCell(cellName);
    	table.addCell(subjectName);

    	PdfPCell cellProf = new PdfPCell(new Phrase("교수", font));
    	cellProf.setMinimumHeight(21);
    	cellProf.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell profName = new PdfPCell(new Phrase(syllabus.getName(), font));
    	table.addCell(cellProf);
    	table.addCell(profName);
    	
    	PdfPCell cellContact = new PdfPCell(new Phrase("이메일 / 연락처", font));
    	cellContact.setMinimumHeight(21);
    	cellContact.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell profContact = new PdfPCell(new Phrase(syllabus.getEmail() + " / " + syllabus.getPhone(), font));
    	table.addCell(cellContact);
    	table.addCell(profContact);
    	
    	PdfPCell cellSubjectGoal = new PdfPCell(new Phrase("학습 목표", font));
    	cellSubjectGoal.setMinimumHeight(21);
    	cellSubjectGoal.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell subjectGoal = new PdfPCell(new Phrase(syllabus.getGoals(), font));
    	table.addCell(cellSubjectGoal);
    	table.addCell(subjectGoal);
    	
    	PdfPCell cellRateInScore = new PdfPCell(new Phrase("성적 기준", font));
    	cellRateInScore.setMinimumHeight(21);
    	cellRateInScore.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell rateInScore = new PdfPCell(
    			new Phrase("중간 고사: " +syllabus.getMidtrum() +
    					"/ 기말 고사: " +syllabus.getFinal1() +
    					"/ 출석 : " +syllabus.getAtlen() +
    					"/ 과제 : " +syllabus.getProject(), font));
    	table.addCell(cellRateInScore);
    	table.addCell(rateInScore);
    	
    	PdfPCell cellDistri = new PdfPCell(new Phrase("득점 기준", font));
    	cellDistri.setMinimumHeight(21);
    	cellDistri.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell distri = new PdfPCell(new Phrase(syllabus.getDistri(), font));
    	table.addCell(cellDistri);
    	table.addCell(distri);
    	
    	PdfPCell cellOutline = new PdfPCell(new Phrase("개요", font));
    	cellOutline.setMinimumHeight(150);
    	cellOutline.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell outline = new PdfPCell(new Phrase(syllabus.getOutline(), font));
    	table.addCell(cellOutline);
    	table.addCell(outline);
    	
    	PdfPCell cellBook = new PdfPCell(new Phrase("교재", font));
    	cellBook.setMinimumHeight(21);
    	cellBook.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell subjectBook = new PdfPCell(new Phrase(syllabus.getBook(), font));
    	table.addCell(cellBook);
    	table.addCell(subjectBook);
    	
    	PdfPCell cellMiddleTerm = new PdfPCell(new Phrase("중간고사 일정", font));
    	cellMiddleTerm.setMinimumHeight(21);
    	cellMiddleTerm.setHorizontalAlignment(Element.ALIGN_CENTER);
    	Date examStartDate = syllabus.getMidst();
    	String examStartDateParsed = sdf.format(examStartDate);
    	Date examEndDate = syllabus.getMidend(); 
    	String examEndDateParsed = sdf.format(examEndDate);
    	PdfPCell middleTerm = new PdfPCell(new Phrase(examStartDateParsed + " ~ " + examEndDateParsed, font));
    	table.addCell(cellMiddleTerm);
    	table.addCell(middleTerm);
    	
    	
    	PdfPCell cellFinalTerm = new PdfPCell(new Phrase("기말고사 일정", font));
    	cellFinalTerm.setMinimumHeight(21);
    	cellFinalTerm.setHorizontalAlignment(Element.ALIGN_CENTER);
    	examStartDate = syllabus.getFinalst();
    	examStartDateParsed = sdf.format(examStartDate);
    	examEndDate = syllabus.getFinalend(); 
    	examEndDateParsed = sdf.format(examEndDate);
    	PdfPCell finalTerm = new PdfPCell(new Phrase(examStartDateParsed + " ~ " + examEndDateParsed, font));
    	table.addCell(cellFinalTerm);
    	table.addCell(finalTerm);
    	
    	
    	PdfPCell cellReportTerm = new PdfPCell(new Phrase("레포트 일정", font));
    	cellReportTerm.setMinimumHeight(21);
    	cellReportTerm.setHorizontalAlignment(Element.ALIGN_CENTER);
    	examStartDate = syllabus.getProst();
    	examStartDateParsed = sdf.format(examStartDate);
    	examEndDate = syllabus.getProend(); 
    	examEndDateParsed = sdf.format(examEndDate);
    	PdfPCell reportTerm = new PdfPCell(new Phrase(examStartDateParsed + " ~ " + examEndDateParsed, font));
    	table.addCell(cellReportTerm);
    	table.addCell(reportTerm);
    	
    	
    	PdfPCell cellWeeks1 = new PdfPCell(new Phrase("1 주차", font));
    	cellWeeks1.setMinimumHeight(60);
    	cellWeeks1.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks1 = new PdfPCell(new Phrase(syllabus.getWeek1(), font));
    	table.addCell(cellWeeks1);
    	table.addCell(weeks1);
    	
    	PdfPCell cellWeeks2 = new PdfPCell(new Phrase("2 주차", font));
    	cellWeeks2.setMinimumHeight(60);
    	cellWeeks2.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks2 = new PdfPCell(new Phrase(syllabus.getWeek2(), font));
    	table.addCell(cellWeeks2);
    	table.addCell(weeks2);
    	
    	PdfPCell cellWeeks3 = new PdfPCell(new Phrase("3 주차", font));
    	cellWeeks3.setMinimumHeight(60);
    	cellWeeks3.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks3 = new PdfPCell(new Phrase(syllabus.getWeek3(), font));
    	table.addCell(cellWeeks3);
    	table.addCell(weeks3);
    	
    	PdfPCell cellWeeks4 = new PdfPCell(new Phrase("4 주차", font));
    	cellWeeks4.setMinimumHeight(60);
    	cellWeeks4.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks4 = new PdfPCell(new Phrase(syllabus.getWeek4(), font));
    	table.addCell(cellWeeks4);
    	table.addCell(weeks4);
    	
    	PdfPCell cellWeeks5 = new PdfPCell(new Phrase("5 주차", font));
    	cellWeeks5.setMinimumHeight(60);
    	cellWeeks5.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks5 = new PdfPCell(new Phrase(syllabus.getWeek5(), font));
    	table.addCell(cellWeeks5);
    	table.addCell(weeks5);
    	
    	PdfPCell cellWeeks6 = new PdfPCell(new Phrase("6 주차", font));
    	cellWeeks6.setMinimumHeight(60);
    	cellWeeks6.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks6 = new PdfPCell(new Phrase(syllabus.getWeek6(), font));
    	table.addCell(cellWeeks6);
    	table.addCell(weeks6);
    	
    	PdfPCell cellWeeks7 = new PdfPCell(new Phrase("7 주차", font));
    	cellWeeks7.setMinimumHeight(60);
    	cellWeeks7.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks7 = new PdfPCell(new Phrase(syllabus.getWeek7(), font));
    	table.addCell(cellWeeks7);
    	table.addCell(weeks7);
    	
    	PdfPCell cellWeeks8 = new PdfPCell(new Phrase("8 주차", font));
    	cellWeeks8.setMinimumHeight(60);
    	cellWeeks8.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks8 = new PdfPCell(new Phrase(syllabus.getWeek8(), font));
    	table.addCell(cellWeeks8);
    	table.addCell(weeks8);
    	
    	PdfPCell cellWeeks9 = new PdfPCell(new Phrase("9 주차", font));
    	cellWeeks9.setMinimumHeight(60);
    	cellWeeks9.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks9 = new PdfPCell(new Phrase(syllabus.getWeek9(), font));
    	table.addCell(cellWeeks9);
    	table.addCell(weeks9);
    	
    	PdfPCell cellWeeks10 = new PdfPCell(new Phrase("10 주차", font));
    	cellWeeks10.setMinimumHeight(60);
    	cellWeeks10.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks10 = new PdfPCell(new Phrase(syllabus.getWeek10(), font));
    	table.addCell(cellWeeks10);
    	table.addCell(weeks10);
    	
    	PdfPCell cellWeeks11 = new PdfPCell(new Phrase("11 주차", font));
    	cellWeeks11.setMinimumHeight(60);
    	cellWeeks11.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks11 = new PdfPCell(new Phrase(syllabus.getWeek11(), font));
    	table.addCell(cellWeeks11);
    	table.addCell(weeks11);
    	
    	PdfPCell cellWeeks12 = new PdfPCell(new Phrase("12 주차", font));
    	cellWeeks12.setMinimumHeight(60);
    	cellWeeks12.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks12 = new PdfPCell(new Phrase(syllabus.getWeek12(), font));
    	table.addCell(cellWeeks12);
    	table.addCell(weeks12);
    	
    	PdfPCell cellWeeks13 = new PdfPCell(new Phrase("13 주차", font));
    	cellWeeks13.setMinimumHeight(60);
    	cellWeeks13.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks13= new PdfPCell(new Phrase(syllabus.getWeek13(), font));
    	table.addCell(cellWeeks13);
    	table.addCell(weeks13);
    	    	
    	PdfPCell cellWeeks14 = new PdfPCell(new Phrase("14 주차", font));
    	cellWeeks14.setMinimumHeight(60);
    	cellWeeks14.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks14 = new PdfPCell(new Phrase(syllabus.getWeek14(), font));
    	table.addCell(cellWeeks14);
    	table.addCell(weeks14);
    	
    	PdfPCell cellWeeks15 = new PdfPCell(new Phrase("15 주차", font));
    	cellWeeks15.setMinimumHeight(60);
    	cellWeeks15.setHorizontalAlignment(Element.ALIGN_CENTER);
    	PdfPCell weeks15 = new PdfPCell(new Phrase(syllabus.getWeek15(), font));
    	table.addCell(cellWeeks15);
    	table.addCell(weeks15);    	
    	
    	doc.add(table);    	
    	doc.close();
         
    }
 
}