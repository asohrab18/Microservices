package com.management.weight.model;

import java.math.BigDecimal;

public class SellingShare {
	private BigDecimal lastTradePrice;
	private BigDecimal quantity;
	private BigDecimal totalPrice;
	private BigDecimal chargesIncludingGstOnSelling;
	private BigDecimal actualSellingPrice;
	private BigDecimal avgCost;
	private BigDecimal investedAmount;
	private BigDecimal profitOrLoss;
	private int holdingDurationInMonths;
	private BigDecimal tax;
	private BigDecimal actualProfit;

	public BigDecimal getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(BigDecimal lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getChargesIncludingGstOnSelling() {
		return chargesIncludingGstOnSelling;
	}

	public void setChargesIncludingGstOnSelling(BigDecimal chargesIncludingGstOnSelling) {
		this.chargesIncludingGstOnSelling = chargesIncludingGstOnSelling;
	}

	public BigDecimal getActualSellingPrice() {
		return actualSellingPrice;
	}

	public void setActualSellingPrice(BigDecimal actualSellingPrice) {
		this.actualSellingPrice = actualSellingPrice;
	}

	public BigDecimal getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(BigDecimal avgCost) {
		this.avgCost = avgCost;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getProfitOrLoss() {
		return profitOrLoss;
	}

	public void setProfitOrLoss(BigDecimal profitOrLoss) {
		this.profitOrLoss = profitOrLoss;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getActualProfit() {
		return actualProfit;
	}

	public void setActualProfit(BigDecimal actualProfit) {
		this.actualProfit = actualProfit;
	}

	public int getHoldingDurationInMonths() {
		return holdingDurationInMonths;
	}

	public void setHoldingDurationInMonths(int holdingDurationInMonths) {
		this.holdingDurationInMonths = holdingDurationInMonths;
	}
}
