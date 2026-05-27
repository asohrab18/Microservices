package com.learning.utils;

import java.math.BigDecimal;

public final class ShareTradingContants {

	public ShareTradingContants() {
	}

	/** Numeric */
	public static final int ZERO = 0;
	public static final int TWELVE = 12;
	public static final int SIXTY = 60;
	public static final BigDecimal EXCHANGE_SEBI_PERCENT = new BigDecimal("0.0035");
	public static final BigDecimal GST_PERCENT = new BigDecimal("18");
	public static final BigDecimal HUNDRED = new BigDecimal("100");
	public static final BigDecimal LTCG_EXEMPTION = new BigDecimal("125000");
	public static final BigDecimal LTCG_PERCENT = new BigDecimal("12.5");
	public static final BigDecimal STAMP_DUTY_PERCENT = new BigDecimal("0.015");
	public static final BigDecimal STCG_PERCENT = new BigDecimal("20");
	public static final BigDecimal STT_PERCENT = new BigDecimal("0.1");

	/** OTHERS */
	public static final String BUYING = "buying";
	public static final String BUYING_DETAILS = "buying-details";
	public static final String CHARGES_INCLUDING_GST = "Charges including GST on";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String HOLDING_DURATION = "Holding duration";
	public static final String INVESTMENT_PERCENTAGE = "investment-percentage";
	public static final String MONTH = "month(s)";
	public static final String SELLING = "selling";
	public static final String SELLING_DETAILS = "selling-details";
	public static final String SHARE_TARDING = "share-trading";
	public static final String SPACE = " ";
	public static final String HOLDING_DURATION_COLON = HOLDING_DURATION + COLON + SPACE;
	public static final String SPACE_MONTH = SPACE + MONTH;
	/** Messages */
	public static final String MSG_CHARGES_ON_BUYING = CHARGES_INCLUDING_GST + SPACE + BUYING + COLON + SPACE;
	public static final String MSG_CHARGES_ON_SELLING = CHARGES_INCLUDING_GST + SPACE + SELLING + COLON + SPACE;
	public static final String MSG_INVESTED_AMOUNT = "Invested Amount of a Stock is" + SPACE;
	public static final String MSG_TOTAL_INVESTMENT_PERCENTAGE = "% of Total Investment" + DOT;
	public static final String MSG_INVESTED_AMOUNT_GT_TOTAL_INVESTMENT = "Invested Amount of a Stock cannot be greater than Total Investment"
			+ DOT;
}