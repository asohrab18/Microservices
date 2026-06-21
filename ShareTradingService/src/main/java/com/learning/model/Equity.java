package com.learning.model;

import java.math.BigDecimal;

public class Equity {
	private BigDecimal quantity;
	private BigDecimal averageCost;
	private BigDecimal lastTradePrice;
	private BigDecimal investedAmount;
	private BigDecimal desiredAmountToBeAdded;
	private BigDecimal quantityNew;
	private BigDecimal investedAmountNew;
	private BigDecimal totalInvestedAmount;
	private BigDecimal totalQuantity;
	private BigDecimal averageCostNew;
	private BigDecimal averageCostDifference;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(BigDecimal averageCost) {
		this.averageCost = averageCost;
	}

	public BigDecimal getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(BigDecimal lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getDesiredAmountToBeAdded() {
		return desiredAmountToBeAdded;
	}

	public void setDesiredAmountToBeAdded(BigDecimal desiredAmountToBeAdded) {
		this.desiredAmountToBeAdded = desiredAmountToBeAdded;
	}

	public BigDecimal getQuantityNew() {
		return quantityNew;
	}

	public void setQuantityNew(BigDecimal quantityNew) {
		this.quantityNew = quantityNew;
	}

	public BigDecimal getInvestedAmountNew() {
		return investedAmountNew;
	}

	public void setInvestedAmountNew(BigDecimal investedAmountNew) {
		this.investedAmountNew = investedAmountNew;
	}

	public BigDecimal getTotalInvestedAmount() {
		return totalInvestedAmount;
	}

	public void setTotalInvestedAmount(BigDecimal totalInvestedAmount) {
		this.totalInvestedAmount = totalInvestedAmount;
	}

	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigDecimal totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getAverageCostNew() {
		return averageCostNew;
	}

	public void setAverageCostNew(BigDecimal averageCostNew) {
		this.averageCostNew = averageCostNew;
	}

	public BigDecimal getAverageCostDifference() {
		return averageCostDifference;
	}

	public void setAverageCostDifference(BigDecimal averageCostDifference) {
		this.averageCostDifference = averageCostDifference;
	}

}
