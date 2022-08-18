package com.investmentapp.service;

import java.util.List;

import com.investmentapp.model.Investment;

public interface IInvestmentService {
void addInvestment(Investment investment);
void updateInvestment(int planId,double amount);
void deleteInvestment(int planId);


List<Investment> getbyRiskAndTerm(String risk,int term);
List<Investment> getbyType(String type);
List<Investment> getbyPurpose(String purpose);
List<Investment> getAll();

double calculateMaturity(Investment investment);
Investment getById(int planId);

}
