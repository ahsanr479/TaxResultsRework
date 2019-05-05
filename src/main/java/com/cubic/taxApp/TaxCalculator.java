package com.cubic.taxApp;

public class TaxCalculator {
	
	TaxUtil util = new TaxUtil();
	
	public TaxResult taxCalculator(double totalIncome, FilingStatus filingStatus) {
		if(totalIncome <=0 || filingStatus == null) {
			throw new IllegalArgumentException();
		}
		TaxResult t = TaxResult.builder().taxRate(util.getTaxRate(totalIncome, filingStatus)).ssnTax(util.getSsnTax(totalIncome)).medicareTax(util.getMedicareTax(totalIncome)).totalTax(util.getTotalTax(totalIncome, filingStatus)).totalIncome(totalIncome).status(filingStatus).build();
		return t;	
	}
}
