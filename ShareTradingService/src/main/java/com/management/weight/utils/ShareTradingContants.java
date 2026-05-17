package com.management.weight.utils;

import java.math.BigDecimal;

public final class ShareTradingContants {
	
	public ShareTradingContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;
	public static final float ONE = 1f;
	public static final int TWELVE = 12;
	public static final int TWENTY_FOUR = 24;
	public static final int THIRTY = 30;
	public static final int SIXTY = 60;
	public static final float CALORIES_EQUIVALENT_TO_ONE_KG = 7700f;
	
	/** Messages */
	public static final String MSG_CURRENT_WT_LT_DESIRED_WT = "currentWeightInKg cannot be less than desiredWeightInKg.";
	public static final String MSG_WELCOME = "Welcome to the world of weight-management!";
	public static final String MSG_ZERO_CAL_LOSS_PER_DAY = "caloriesLossPerDay cannot be zero.";
	public static final String MSG_ZERO_CURRENT_WT = "currentWeightInKg cannot be zero.";
	public static final String MSG_ZERO_DESIRED_WT = "desiredWeightInKg cannot be zero.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";
	
	/** OTHERS */
	public static final BigDecimal HUNDRED = new BigDecimal("100");
	public static final BigDecimal STT_PERCENT = new BigDecimal("0.1");
	public static final BigDecimal STAMP_DUTY_PERCENT = new BigDecimal("0.015");
	public static final BigDecimal EXCHANGE_SEBI_PERCENT = new BigDecimal("0.0035");
	public static final BigDecimal GST_PERCENT = new BigDecimal("18");
	public static final BigDecimal STCG_PERCENT = new BigDecimal("20");
	public static final BigDecimal LTCG_PERCENT = new BigDecimal("12.5");
	public static final BigDecimal LTCG_EXEMPTION = new BigDecimal("125000");
	public static final String SHARE_TARDING = "share-trading";
	public static final String BUYING_DETAILS = "buying-details";

}