package com.learning.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShareTradingUtils {
	public static final Logger LOG = LoggerFactory.getLogger(ShareTradingUtils.class);

	public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
		return value1.add(value2);
	}

	public static BigDecimal multiply(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

	public static BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
		return value1.subtract(value2);
	}

	public static BigDecimal getBigDecimal(String value) {
		return new BigDecimal(value);
	}

	public static BigDecimal getPercentOfAmount(BigDecimal amount, BigDecimal percentage) {
		BigDecimal value = amount.multiply(percentage).divide(ShareTradingContants.HUNDRED);
		LOG.info("Percent of amount: " + value);
		return setScale(value);
	}

	public static BigDecimal setScale(BigDecimal value) {
		return value.setScale(2, RoundingMode.HALF_UP);
	}

	public static BigDecimal getStt(BigDecimal amount) {
		return getPercentOfAmount(amount, ShareTradingContants.STT_PERCENT);
	}

	public static BigDecimal getStampDuty(BigDecimal amount) {
		return getPercentOfAmount(amount, ShareTradingContants.STAMP_DUTY_PERCENT);
	}

	public static BigDecimal getExchangeAndSebiCharges(BigDecimal amount) {
		return getPercentOfAmount(amount, ShareTradingContants.EXCHANGE_SEBI_PERCENT);
	}

	public static BigDecimal getGst(BigDecimal amount) {
		return getPercentOfAmount(amount, ShareTradingContants.GST_PERCENT);
	}

	public static BigDecimal getPercentageOfInvestment(BigDecimal investedAmountOfOneStock,
			BigDecimal totalInvestment) {

		BigDecimal percentageOfInvestment = investedAmountOfOneStock.multiply(ShareTradingContants.HUNDRED)
				.divide(totalInvestment, 2, RoundingMode.HALF_UP);

		return percentageOfInvestment;
	}

	/**This main method is for testing purpose only.*/
	public static void main(String[] args) {
		BigDecimal investedAmountOfOneStock = getBigDecimal("1999899.99");
		BigDecimal totalInvestment = getBigDecimal("4824251.52");
		BigDecimal percentageOfInvestment = getPercentageOfInvestment(investedAmountOfOneStock, totalInvestment);
		System.out.println("Percentage of Investment: " + percentageOfInvestment);
	}
}