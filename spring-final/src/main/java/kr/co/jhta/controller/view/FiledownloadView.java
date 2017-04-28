package kr.co.jhta.controller.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FiledownloadView extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "utf-8"));
	
		OutputStream out = response.getOutputStream();
		IOUtils.copy(new FileInputStream(new File(directory, filename)), out);
	}
}
