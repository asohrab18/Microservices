package com.management.weight.helper;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.management.weight.utils.ShareTradingContants;
import com.management.weight.utils.ShareTradingUtils;

public class ShareTradingHelper {
	private static final Logger LOG = LoggerFactory.getLogger(ShareTradingHelper.class);

	public static BigDecimal getChargesIncludingGstOnBuying(BigDecimal amount) {

		BigDecimal stt = ShareTradingUtils.getStt(amount);
		BigDecimal stampDuty = ShareTradingUtils.getStampDuty(amount);
		BigDecimal exchangeAndSebiCharges = ShareTradingUtils.getExchangeAndSebiCharges(amount);
		BigDecimal gst = ShareTradingUtils.getGst(exchangeAndSebiCharges);

		BigDecimal chargesIncludingGstOnBuying = stt.add(stampDuty).add(exchangeAndSebiCharges).add(gst);
		LOG.info("Charges including GST on buying: " + chargesIncludingGstOnBuying);
		return ShareTradingUtils.setScale(chargesIncludingGstOnBuying);
	}

	public static BigDecimal getChargesIncludingGstOnSelling(BigDecimal amount) {

		BigDecimal stt = ShareTradingUtils.getStt(amount);
		BigDecimal exchangeAndSebiCharges = ShareTradingUtils.getExchangeAndSebiCharges(amount);
		BigDecimal gst = ShareTradingUtils.getGst(exchangeAndSebiCharges);

		BigDecimal chargesIncludingGstOnSelling = stt.add(exchangeAndSebiCharges).add(gst);
		LOG.info("Charges including GST on selling: " + chargesIncludingGstOnSelling);
		return ShareTradingUtils.setScale(chargesIncludingGstOnSelling);
	}

	/** If holding Duration < 12 Months then Tax = 20% (STCG) */
	public static BigDecimal calculateTax(BigDecimal profit, int holdingDurationInMonths) {
		LOG.info("Holding duration = " + holdingDurationInMonths + " month(s)");
		if (profit.compareTo(BigDecimal.ZERO) <= 0) {
			return BigDecimal.ZERO;
		}

		if (holdingDurationInMonths < 12) {
			return ShareTradingUtils.getPercentOfAmount(profit, ShareTradingContants.STCG_PERCENT);
		} else {
			profit = profit.subtract(ShareTradingContants.LTCG_EXEMPTION);
			if (profit.compareTo(BigDecimal.ZERO) <= 0) {
				return BigDecimal.ZERO;
			}
			return ShareTradingUtils.getPercentOfAmount(profit, ShareTradingContants.LTCG_PERCENT);
		}
	}
}