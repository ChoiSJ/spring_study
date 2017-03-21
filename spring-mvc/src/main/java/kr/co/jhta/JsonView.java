package kr.co.jhta;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.google.gson.Gson;

@Component
public class JsonView extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Gson gson = new Gson();
		String jsonText = gson.toJson(model.get("data"));
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(jsonText);
	}
}
