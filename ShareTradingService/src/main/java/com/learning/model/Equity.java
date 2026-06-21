package com.learning.model;

import java.math.BigDecimal;

public class Equity {

	private BigDecimal quantity;
	private BigDecimal averagePrice;
	private BigDecimal lastTradePrice;
	private BigDecimal investedAmount;
	private BigDecimal desiredAmountToBeAdded;
	private BigDecimal quantityNew;
	private BigDecimal investedAmountNew;
	private BigDecimal totalInvestedAmount;
	private BigDecimal totalQuantity;
	private BigDecimal averagePriceNew;
	private BigDecimal priceDifference;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
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

	public BigDecimal getAveragePriceNew() {
		return averagePriceNew;
	}

	public void setAveragePriceNew(BigDecimal averagePriceNew) {
		this.averagePriceNew = averagePriceNew;
	}

	public BigDecimal getPriceDifference() {
		return priceDifference;
	}

	public void setPriceDifference(BigDecimal priceDifference) {
		this.priceDifference = priceDifference;
	}
}
