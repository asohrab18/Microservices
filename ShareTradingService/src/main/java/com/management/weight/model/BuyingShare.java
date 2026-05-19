package com.management.weight.model;

import java.math.BigDecimal;

public class BuyingShare {
	private BigDecimal oneSharePrice;
	private BigDecimal quantity;
	private BigDecimal totalSharesPrice;
	private BigDecimal chargesIncludingGstOnBuying;
	private BigDecimal totalCostIncludingChargesAndGstOnBuying;

	public BigDecimal getOneSharePrice() {
		return oneSharePrice;
	}

	public void setOneSharePrice(BigDecimal oneSharePrice) {
		this.oneSharePrice = oneSharePrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalSharesPrice() {
		return totalSharesPrice;
	}

	public void setTotalSharesPrice(BigDecimal totalSharesPrice) {
		this.totalSharesPrice = totalSharesPrice;
	}

	public BigDecimal getChargesIncludingGstOnBuying() {
		return chargesIncludingGstOnBuying;
	}

	public void setChargesIncludingGstOnBuying(BigDecimal chargesIncludingGstOnBuying) {
		this.chargesIncludingGstOnBuying = chargesIncludingGstOnBuying;
	}

	public BigDecimal getTotalCostIncludingChargesAndGstOnBuying() {
		return totalCostIncludingChargesAndGstOnBuying;
	}

	public void setTotalCostIncludingChargesAndGstOnBuying(BigDecimal totalCostIncludingChargesAndGstOnBuying) {
		this.totalCostIncludingChargesAndGstOnBuying = totalCostIncludingChargesAndGstOnBuying;
	}
}
