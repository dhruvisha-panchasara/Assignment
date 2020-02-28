package com.aimdek.spring.dao;

import java.util.List;

import com.aimdek.spring.model.RegVO;

public interface RegDAO {
	
	public void insertorupdate(RegVO regvo);
		
	
	  public List<RegVO> list();
	  
	
	  public void delete(int employeeId);
	  
	  public RegVO editlist(int employeeId);
	 
	 

}
