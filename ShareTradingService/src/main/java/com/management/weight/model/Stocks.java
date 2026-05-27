package com.management.weight.model;

import java.math.BigDecimal;

public class Stocks {
	private BigDecimal investedAmountOfOneStock;
	private BigDecimal totalInvestment;

	public BigDecimal getInvestedAmountOfOneStock() {
		return investedAmountOfOneStock;
	}

	public void setInvestedAmountOfOneStock(BigDecimal investedAmountOfOneStock) {
		this.investedAmountOfOneStock = investedAmountOfOneStock;
	}

	public BigDecimal getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(BigDecimal totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

}
