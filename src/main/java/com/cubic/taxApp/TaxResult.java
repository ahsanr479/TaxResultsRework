package com.cubic.taxApp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaxResult {
	
	private double ssnTax;
	private double medicareTax;
	private double taxRate;
	private double totalTax;
	private FilingStatus status;
	private double totalIncome;

}
