package com.aimdek.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.spring.dao.RegDAO;
import com.aimdek.spring.model.RegVO;

@Controller
public class HomeController {

	@Autowired RegDAO regdao;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
	//return new ModelAndView("home");
	return new ModelAndView("Registration","data",new RegVO());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(@ ModelAttribute RegVO regvo) throws IOException{
		System.out.print("insert method:::::");
		regdao.insertorupdate(regvo);
		return new ModelAndView("redirect:/searchEmp");
	}
	
	  @RequestMapping(value="/searchEmp",method=RequestMethod.GET) 
	  public ModelAndView searchEmp(ModelAndView model) throws IOException
	  {
	  System.out.print("search method:::::");
	  List<RegVO> emplist=regdao.list();
	  model.addObject("emplist",emplist);
	  model.setViewName("search");
	  return model; 
	  }


  	@RequestMapping(value="delete",method=RequestMethod.GET) 
  		public ModelAndView delete(HttpServletRequest request) throws IOException{
  		System.out.print("delete method:::::"); 
  		int employeeId=Integer.parseInt(request.getParameter("id"));
  		regdao.delete(employeeId);
  		return new ModelAndView("redirect:/searchEmp");
  }


	
	  @RequestMapping(value="edit",method=RequestMethod.GET) public ModelAndView
	  edit(HttpServletRequest request) throws IOException{
	  System.out.print("edit method:::::"); int
	  employeeId=Integer.parseInt(request.getParameter("id")); 
	  RegVO regvo=regdao.editlist(employeeId); 
	  ModelAndView model=new  ModelAndView("Registration"); 
	  model.addObject("data", regvo); 
	  return model;
	  }
	 
  }
  
  
 
