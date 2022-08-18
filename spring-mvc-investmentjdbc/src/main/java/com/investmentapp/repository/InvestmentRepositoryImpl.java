package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;
@Repository
public class InvestmentRepositoryImpl implements IInvestmentRepository {

	private JdbcTemplate jdbcTemplate;
	
@Autowired
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public void addInvestment(Investment investment) {
	// String sql=DBQueries.INSERTQUERY;
	Object[] investmentArray= {
			investment.getPlanName(),investment.getEntryAge(),investment.getType(),investment.getAmount(),
			investment.getPurpose(),investment.getRisk(),investment.getNominee(),investment.getTerm()
	        };
	jdbcTemplate.update(DBQueries.INSERTQUERY, investmentArray);
	}

	@Override
	public void updateInvestment(int planId, double amount) {
		String sql=DBQueries.UPDATEQUERY;
		jdbcTemplate.update(sql,amount,planId);
		

	}

	@Override
	public void deleteInvestment(int planId) {
		String sql=DBQueries.deleteQUERY;
		jdbcTemplate.update(sql,planId);

	}

	@Override
	public List<Investment> findbyRiskAndTerm(String risk, int term) {
		// TODO Auto-generated method stub
		return null;
	}
//by Lamada Expression
	@Override
	public List<Investment> findbyType(String type) {
		List<Investment> investments=jdbcTemplate.query(DBQueries.SELECTBYTYPE,
				(rs,rowNum)->{
					Investment investment= new Investment();
					investment.setPlanName(rs.getString("plan_name"));
					investment.setPurpose(rs.getString("purpose"));
					investment.setAmount(rs.getDouble("amount"));
					investment.setEntryAge(rs.getInt("entry_age"));
					investment.setRisk(rs.getString("risk"));
					investment.setNominee(rs.getString("nominee"));
					investment.setType(rs.getString("type"));
					investment.setTerm(rs.getInt("term"));
					
					int planId=rs.getInt("plan_id");
					investment.setPlanId(planId);
					return investment;
				},type);
					
			return investments;
	}
//BY Annonymus InnerClass
	@Override
	public List<Investment> findbyPurpose(String purpose) {
	List<Investment> investments=jdbcTemplate.query(DBQueries.SELECTBYPURPOSE,
			new RowMapper<Investment>() {
		

		@Override
		public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Investment investment= new Investment();
			investment.setPlanName(rs.getString("plan_name"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setAmount(rs.getDouble("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setRisk(rs.getString("risk"));
			investment.setNominee(rs.getString("nominee"));
			investment.setType(rs.getString("type"));
			investment.setTerm(rs.getInt("term"));
			
			return investment;
		}
		
		},purpose);
		return investments;
	}

	@Override
	public List<Investment> findAll() {
	RowMapper<Investment> mapper=new InvestmentMapper();
	List<Investment> investments=
			jdbcTemplate.query(DBQueries.SELECTQUERY, mapper);
	
		return investments;
	}

	@Override
	public Investment findById(int planId) {
		Investment ninvestment=jdbcTemplate.queryForObject(DBQueries.SELECTBYID,
				(rs,rowNum)->{
					Investment investment= new Investment();
					investment.setPlanName(rs.getString("plan_name"));
					investment.setPurpose(rs.getString("purpose"));
					investment.setAmount(rs.getDouble("amount"));
					investment.setEntryAge(rs.getInt("entry_age"));
					investment.setRisk(rs.getString("risk"));
					investment.setNominee(rs.getString("nominee"));
					investment.setType(rs.getString("type"));
					investment.setTerm(rs.getInt("term"));
					
	//				int planId=rs.getInt("plan_id");
					investment.setPlanId(planId);
					return investment;
				},planId);
					
			return ninvestment;
}}
