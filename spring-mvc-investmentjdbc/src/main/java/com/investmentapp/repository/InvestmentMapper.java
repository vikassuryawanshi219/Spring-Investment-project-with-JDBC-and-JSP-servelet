package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.investmentapp.model.Investment;

public class InvestmentMapper implements RowMapper<Investment> {
	@Override
	public Investment mapRow(ResultSet rs,int rowNum) throws SQLException{
		
		//get the value using resultset
		String planName=rs.getString("plan_name");
		String purpose=rs.getString("purpose");
		String nominee=rs.getString("nominee");
		String planType=rs.getString("type");
		String risk=rs.getString("risk");
		int term=rs.getInt("term");
		int entryAge=rs.getInt("entry_age");
		double amount=rs.getDouble("amount");
		int planId=rs.getInt("plan_id");
		
		//set in the domain object
		Investment investment=new Investment();
		investment.setAmount(amount);
		investment.setEntryAge(entryAge);
		investment.setRisk(risk);
		investment.setPlanName(planName);
		investment.setPlanId(planId);
		investment.setPurpose(purpose);
		investment.setNominee(nominee);
		investment.setType(planType);
		investment.setTerm(term);
		
		return investment;
	}
	

}
