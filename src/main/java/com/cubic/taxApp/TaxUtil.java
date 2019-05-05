package com.cubic.taxApp;

import java.util.HashMap;
import java.util.Map;



public class TaxUtil {
	
	final double SSN_TAX = 0.065;
	final double MEDICARE_TAX = 0.015;
	final double SSN_CAP = 128000 ;
	private Map<String, Double> taxRates = new HashMap<String, Double>();

	public TaxUtil() {
		taxRates.put(createKey(Categories.one, FilingStatus.SINGLE), 0.022);
		taxRates.put(createKey(Categories.two, FilingStatus.SINGLE), 0.024);
		taxRates.put(createKey(Categories.three, FilingStatus.SINGLE), 0.032);
		taxRates.put(createKey(Categories.four, FilingStatus.SINGLE), 0.035);
		taxRates.put(createKey(Categories.one, FilingStatus.MARRIED), 0.012);
		taxRates.put(createKey(Categories.two, FilingStatus.MARRIED), 0.022);
		taxRates.put(createKey(Categories.three, FilingStatus.MARRIED), 0.024);
		taxRates.put(createKey(Categories.four, FilingStatus.MARRIED), 0.032);
	}
	
	private String createKey(Categories cat, FilingStatus filingstatus) {
		return cat.name() + "#" + filingstatus.name();
	}
	
	private Categories getCetgory(double totalIncome) {
		if(totalIncome <= 37000) {
			return Categories.one;
		}if(totalIncome > 37000 && totalIncome <= 78000) {
			return Categories.two;
		}if(totalIncome > 78000 && totalIncome <= 128000) {
			return Categories.three; 
		}else {
			return Categories.four;
		}
	}
	
	public double getTaxRate(double totalIncome, FilingStatus filingStatus) {
		return taxRates.get(createKey(getCetgory(totalIncome), filingStatus));

	}
	
	public double getSsnTax(double totalIncome){
		if(totalIncome > this.SSN_CAP) {
			return this.SSN_CAP * this.SSN_TAX;
		}
		return totalIncome * this.SSN_TAX;
	}
	
	public double getMedicareTax(double totalIncome){
		if(totalIncome > this.SSN_CAP) {
			return this.SSN_CAP * this.MEDICARE_TAX;
		}
		return totalIncome * this.MEDICARE_TAX;
	}
	
	public double getTotalTax(double totalIncome, FilingStatus filingStatus) {
		return (totalIncome *getTaxRate(totalIncome, filingStatus)) + getSsnTax(totalIncome) + getMedicareTax(totalIncome);		
		
	}
	
	
	
	

}
