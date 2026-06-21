package com.learning.helper;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.model.Equity;
import com.learning.utils.ShareTradingContants;
import com.learning.utils.ShareTradingUtils;

public class ShareTradingHelper {
	private static final Logger LOG = LoggerFactory.getLogger(ShareTradingHelper.class);

	public static BigDecimal getChargesIncludingGstOnBuying(BigDecimal amount) {

		BigDecimal stt = ShareTradingUtils.getStt(amount);
		BigDecimal stampDuty = ShareTradingUtils.getStampDuty(amount);
		BigDecimal exchangeAndSebiCharges = ShareTradingUtils.getExchangeAndSebiCharges(amount);
		BigDecimal gst = ShareTradingUtils.getGst(exchangeAndSebiCharges);

		BigDecimal chargesIncludingGstOnBuying = stt.add(stampDuty).add(exchangeAndSebiCharges).add(gst);
		LOG.info(ShareTradingContants.MSG_CHARGES_ON_BUYING + chargesIncludingGstOnBuying);
		return ShareTradingUtils.setScale(chargesIncludingGstOnBuying);
	}

	public static BigDecimal getChargesIncludingGstOnSelling(BigDecimal amount) {

		BigDecimal stt = ShareTradingUtils.getStt(amount);
		BigDecimal exchangeAndSebiCharges = ShareTradingUtils.getExchangeAndSebiCharges(amount);
		BigDecimal gst = ShareTradingUtils.getGst(exchangeAndSebiCharges);

		BigDecimal chargesIncludingGstOnSelling = stt.add(exchangeAndSebiCharges).add(gst);
		LOG.info(ShareTradingContants.MSG_CHARGES_ON_SELLING + chargesIncludingGstOnSelling);
		return ShareTradingUtils.setScale(chargesIncludingGstOnSelling);
	}

	/** If holding Duration < 12 Months then Tax = 20% (STCG) */
	public static BigDecimal calculateTax(BigDecimal profit, int holdingDurationInMonths) {
		LOG.info(ShareTradingContants.HOLDING_DURATION_COLON + holdingDurationInMonths
				+ ShareTradingContants.SPACE_MONTH);
		if (profit.compareTo(BigDecimal.ZERO) <= ShareTradingContants.ZERO) {
			return BigDecimal.ZERO;
		}

		if (holdingDurationInMonths < ShareTradingContants.TWELVE) {
			return ShareTradingUtils.getPercentOfAmount(profit, ShareTradingContants.STCG_PERCENT);
		} else {
			profit = profit.subtract(ShareTradingContants.LTCG_EXEMPTION);
			if (profit.compareTo(BigDecimal.ZERO) <= ShareTradingContants.ZERO) {
				return BigDecimal.ZERO;
			}
			return ShareTradingUtils.getPercentOfAmount(profit, ShareTradingContants.LTCG_PERCENT);
		}
	}

	public static Equity getDetailsAfterAddingShares(Equity equity) {
		BigDecimal quantity = equity.getQuantity();
		BigDecimal averagePrice = equity.getAveragePrice();
		BigDecimal lastTradePrice = equity.getLastTradePrice();
		BigDecimal desiredAmountToBeAdded = equity.getDesiredAmountToBeAdded();

		BigDecimal investedAmount = ShareTradingUtils.setScale(ShareTradingUtils.multiply(averagePrice, quantity));

		BigDecimal quantityNew = ShareTradingUtils.divide(desiredAmountToBeAdded, lastTradePrice,
				ShareTradingContants.ZERO);

		BigDecimal investedAmountNew = ShareTradingUtils
				.setScale(ShareTradingUtils.multiply(lastTradePrice, quantityNew));

		BigDecimal totalInvestedAmount = ShareTradingUtils
				.setScale(ShareTradingUtils.add(investedAmount, investedAmountNew));

		BigDecimal totalQuantity = ShareTradingUtils.setScale(ShareTradingUtils.add(quantity, quantityNew),
				ShareTradingContants.ZERO);

		BigDecimal averagePriceNew = ShareTradingUtils.divide(totalInvestedAmount, totalQuantity,
				ShareTradingContants.TWO);

		BigDecimal difference = ShareTradingUtils.setScale(ShareTradingUtils.subtract(averagePrice, averagePriceNew));

		equity.setInvestedAmount(investedAmount);
		equity.setQuantityNew(quantityNew);
		equity.setInvestedAmountNew(investedAmountNew);
		equity.setTotalInvestedAmount(totalInvestedAmount);
		equity.setTotalQuantity(totalQuantity);
		equity.setAveragePriceNew(averagePriceNew);
		equity.setPriceDifference(difference);

		return equity;
	}

}