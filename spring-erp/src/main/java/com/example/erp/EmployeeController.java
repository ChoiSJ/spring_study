package com.example.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class EmployeeController {
	
	@Autowired
	MappingJackson2JsonView jsonView;
	
	@Autowired
	EmployeeDAO employeeDao;
	
	@RequestMapping("/search.json")
	public @ResponseBody Result<Employee> search(SearchForm searchForm) {
		int rows = employeeDao.getRowCount(searchForm);
		Pagination pagination = null;
		
		if (searchForm.getDisplay() != 0) {
			pagination = new Pagination(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		} else {
			pagination = new Pagination(searchForm.getPageNo(), rows);
		}
			
		searchForm.setBeginIndex(pagination.getBeginIndex());
		searchForm.setEndIndex(pagination.getEndIndex());
		
		List<Employee> employees = employeeDao.getEmployees(searchForm);
		
		Result<Employee> result = new Result<Employee>();
		result.setData(employees);
		result.setRows(rows);
		result.setMessage("데이터 조회 완료");
		result.setCode(1);
		
		return result;
	}
	
	/*
	@RequestMapping("/search.json")
	public ModelAndView search(SearchForm searchForm) {
		int rows = employeeDao.getRowCount(searchForm);
		Pagination pagination = null;
		
		if (searchForm.getDisplay() != 0) {
			pagination = new Pagination(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		} else {
			pagination = new Pagination(searchForm.getPageNo(), rows);
		}
			
		searchForm.setBeginIndex(pagination.getBeginIndex());
		searchForm.setEndIndex(pagination.getEndIndex());
		
		List<Employee> employees = employeeDao.getEmployees(searchForm);
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addObject("data", employees);
		
		return mav;
	}
	*/
	
	/*
	@RequestMapping("/search.json")
	public @ResponseBody List<Employee> search(SearchForm searchForm) {
		int rows = employeeDao.getRowCount(searchForm);
		Pagination pagination = null;
		
		if (searchForm.getDisplay() != 0) {
			pagination = new Pagination(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		} else {
			pagination = new Pagination(searchForm.getPageNo(), rows);
		}
			
		searchForm.setBeginIndex(pagination.getBeginIndex());
		searchForm.setEndIndex(pagination.getEndIndex());
		
		List<Employee> employees = employeeDao.getEmployees(searchForm);
		
		return employees;
	}
	*/
	
	@RequestMapping("/search.do")
	public String search(SearchForm searchForm, Model model) {
		/*
		int beginIndex = (searchForm.getPageNo() - 1) * 10 + 1;
		int endIndex = searchForm.getPageNo() * 10;	
		searchForm.setBeginIndex(beginIndex);
		searchForm.setEndIndex(endIndex);
		*/
		
		// 검색 조건과 일치하는 데이터 갯수 조회하기
		int rows = employeeDao.getRowCount(searchForm);
		Pagination pagination = null;
		
		// 현재 페이지번호, 조회된 데이터 갯수로 Pagination 객체 생성하기
		if (searchForm.getDisplay() != 0) {
			pagination = new Pagination(searchForm.getDisplay(), searchForm.getPageNo(), rows);
		} else {
			pagination = new Pagination(searchForm.getPageNo(), rows);
		}
			
		// 현재 페이지번호에 해당하는 조회시작번호와 조회끝번호를 SearchForm 에 저장하기 
		searchForm.setBeginIndex(pagination.getBeginIndex());
		searchForm.setEndIndex(pagination.getEndIndex());
		
		// 검색조건과 일치하는 데이터 조회하기
		List<Employee> employees = employeeDao.getEmployees(searchForm);
		
		// jsp 에 조회된 데이터 전달하기
		model.addAttribute("employees", employees);
		// jsp 에 페이지내비게이션 정보 전달하기
		model.addAttribute("pagination", pagination);
		// jsp 에 검색 정보 전달하기
		model.addAttribute("search", searchForm);
		
		return "search";
	}
}
