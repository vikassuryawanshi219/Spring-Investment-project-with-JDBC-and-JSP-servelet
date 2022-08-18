package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.model.Investment;
import com.investmentapp.model.Nominee;
import com.investmentapp.model.PlanType;
import com.investmentapp.model.Purpose;
import com.investmentapp.model.Risk;
import com.investmentapp.repository.IInvestmentRepository;
@Service
public class InvestmentServiceImpl implements IInvestmentService {

	public IInvestmentRepository investmentRepository;
	
	@Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository=investmentRepository;
	}
	
	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.addInvestment(investment);
}

	@Override
	public void updateInvestment(int planId, double amount) {
	investmentRepository.updateInvestment(planId, amount);

	}
	@Override
	public void deleteInvestment(int planId) {
		investmentRepository.deleteInvestment(planId);
		
	}



	@Override
	public List<Investment> getbyRiskAndTerm(String risk, int term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> getbyType(String type) {
		// TODO Auto-generated method stub
		return investmentRepository.findbyType(type);
	}

	@Override
	public List<Investment> getbyPurpose(String purpose) {
		// TODO Auto-generated method stub
		return investmentRepository.findbyPurpose(purpose);
	}

	@Override
	public List<Investment> getAll() {
		// TODO Auto-generated method stub
		return investmentRepository.findAll();
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getById(int planId) {
		
		return investmentRepository.findById(planId);
	}

	
}
