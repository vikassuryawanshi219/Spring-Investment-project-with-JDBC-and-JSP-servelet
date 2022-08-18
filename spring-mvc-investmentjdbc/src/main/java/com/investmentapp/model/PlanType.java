package com.investmentapp.model;

public enum PlanType {
	
	mutual("Mutual Fund"),
	ppf("Public Provided fund"),
	ulip("Unit Limited Investment Plan"),
	senior("Senior Pension Scheme"),
	fd("Fixed Deposit");
	
public String type;
	private PlanType (String planType) {
		this.type=planType;
	}
}
