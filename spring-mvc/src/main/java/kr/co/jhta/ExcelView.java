package kr.co.jhta;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@Component
public class ExcelView extends AbstractExcelView {
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] names = (String[]) model.get("data");
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Name");
		
		int rowNumber = 1;
		for (String name : names) {
			HSSFRow row = sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(name);
		}
		
		response.setContentType("application/octect-stream");
		response.setHeader("Content-Disposition", "attachment; filename='data.xls'");
	}
}
