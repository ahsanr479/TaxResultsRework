package com.cubic.taxApp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaxCalculatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	TaxCalculator t = new TaxCalculator();
	
	
	@Test
	public void taxCalcSingleOne() {
		TaxResult result = t.taxCalculator(35000, FilingStatus.SINGLE);
		assertEquals("TaxResult(ssnTax=2275.0, medicareTax=525.0, taxRate=0.022, totalTax=3570.0, status=SINGLE, totalIncome=35000.0)", result.toString());
	}
	@Test
	public void taxCalcSingleTwo() {
		TaxResult result = t.taxCalculator(70000, FilingStatus.SINGLE);
		assertEquals("TaxResult(ssnTax=4550.0, medicareTax=1050.0, taxRate=0.024, totalTax=7280.0, status=SINGLE, totalIncome=70000.0)", result.toString());
	}
	@Test
	public void taxCalcSingleThree() {
		TaxResult result = t.taxCalculator(100000, FilingStatus.SINGLE);
		assertEquals("TaxResult(ssnTax=6500.0, medicareTax=1500.0, taxRate=0.032, totalTax=11200.0, status=SINGLE, totalIncome=100000.0)", result.toString());
	}
	@Test
	public void taxCalcSingleFour() {
		TaxResult result = t.taxCalculator(350000, FilingStatus.SINGLE);
		assertEquals("TaxResult(ssnTax=8320.0, medicareTax=1920.0, taxRate=0.035, totalTax=22490.0, status=SINGLE, totalIncome=350000.0)", result.toString());
	}
	@Test
	public void taxCalcMarriedOne() {
		TaxResult result = t.taxCalculator(35000, FilingStatus.MARRIED);
		assertEquals("TaxResult(ssnTax=2275.0, medicareTax=525.0, taxRate=0.012, totalTax=3220.0, status=MARRIED, totalIncome=35000.0)", result.toString());
	}
	@Test
	public void taxCalcMarriedTwo() {
		TaxResult result = t.taxCalculator(70000, FilingStatus.MARRIED);
		assertEquals("TaxResult(ssnTax=4550.0, medicareTax=1050.0, taxRate=0.022, totalTax=7140.0, status=MARRIED, totalIncome=70000.0)", result.toString());
	}
	@Test
	public void taxCalcMarriedThree() {
		TaxResult result = t.taxCalculator(100000, FilingStatus.MARRIED);
		assertEquals("TaxResult(ssnTax=6500.0, medicareTax=1500.0, taxRate=0.024, totalTax=10400.0, status=MARRIED, totalIncome=100000.0)" , result.toString());
	}
	@Test
	public void taxCalcMarriedFour() {
		TaxResult result = t.taxCalculator(350000, FilingStatus.MARRIED);
		assertEquals("TaxResult(ssnTax=8320.0, medicareTax=1920.0, taxRate=0.032, totalTax=21440.0, status=MARRIED, totalIncome=350000.0)", result.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void taxCalcInvalidIncome() {
		t.taxCalculator(0, FilingStatus.MARRIED);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void taxCalcInvalidStatus() {
		t.taxCalculator(60000, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void taxCalcInvalidData() {
		t.taxCalculator(-60, null);
	}
	

}
