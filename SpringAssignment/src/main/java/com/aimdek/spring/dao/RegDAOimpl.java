package com.aimdek.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aimdek.spring.model.RegVO;

public class RegDAOimpl implements RegDAO {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	 this.template = template; 
	}

	
	@Override
	public void insertorupdate(RegVO regvo) {
		if(regvo.getId()>0)//update
		{
			String sql="update employee set fn=? ,ln=? where id=?";
			template.update(sql,regvo.getFirstname(),regvo.getLastname(),regvo.getId());
		}
		else//insert
		{
			String sql="insert into employee (fn,ln) values (?,?)";
			template.update(sql,regvo.getFirstname(),regvo.getLastname());
			
		}	
	
	}


	
	
	  @Override 
	  public List<RegVO> list() {
		  
	  String sql="select * from employee";
	  List<RegVO> emplist=template.query(sql,new RowMapper<RegVO>()   {
	  
	  @Override public RegVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	  RegVO regvo=new RegVO();
	  regvo.setId(rs.getInt("id")); 
	  regvo.setFirstname(rs.getString("fn"));
	  regvo.setLastname(rs.getString("ln")); 
	  return regvo; 
	  }
	  
	  });
	  return emplist;
	  }
  

  @Override
  public void delete(int employeeId) { 
	   String sql="delete from employee where id=?";
	   template.update(sql,employeeId);
   }


  @Override
  public RegVO editlist(int employeeId) {
	  String sql="select * from employee where id=" + employeeId;
	  return template.query(sql,new ResultSetExtractor<RegVO>(){
				 
				  @Override 
				 public RegVO extractData(ResultSet rs) throws SQLException,
				 DataAccessException {
					  if(rs.next()) 
					  {
				RegVO regvo=new RegVO();
				 regvo.setId(rs.getInt("id"));
				 regvo.setFirstname(rs.getString("fn"));
				 regvo.setLastname(rs.getString("ln")); 
				 return regvo; 
				 } 
					  return null; 
					  }
				  });
	  }
	

}

  
	
  	
 
	


