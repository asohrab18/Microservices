package com.learning.controller;

import java.math.BigDecimal;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.helper.ShareTradingHelper;
import com.learning.model.BuyingShare;
import com.learning.model.Equity;
import com.learning.model.SellingShare;
import com.learning.model.Stocks;
import com.learning.utils.ShareTradingContants;
import com.learning.utils.ShareTradingUtils;

@RestController
@RefreshScope
@RequestMapping(ShareTradingContants.SHARE_TARDING)
public class ShareTradingController {

	@PostMapping(ShareTradingContants.BUYING_DETAILS)
	public ResponseEntity<BuyingShare> getBuyingDetails(@RequestBody BuyingShare buyingShare) throws Exception {

		BigDecimal oneSharePrice = buyingShare.getOneSharePrice();
		BigDecimal quantity = buyingShare.getQuantity();
		BigDecimal totalSharesPrice = ShareTradingUtils.multiply(oneSharePrice, quantity);

		BigDecimal chargesIncludingGstOnBuying = ShareTradingHelper.getChargesIncludingGstOnBuying(totalSharesPrice);

		BigDecimal totalCostIncludingChargesAndGstOnBuying = ShareTradingUtils.add(totalSharesPrice,
				chargesIncludingGstOnBuying);

		BuyingShare share = new BuyingShare();
		share.setOneSharePrice(oneSharePrice);
		share.setQuantity(quantity);
		share.setTotalSharesPrice(totalSharesPrice);
		share.setChargesIncludingGstOnBuying(chargesIncludingGstOnBuying);
		share.setTotalCostIncludingChargesAndGstOnBuying(totalCostIncludingChargesAndGstOnBuying);

		return new ResponseEntity<>(share, HttpStatus.OK);
	}

	@PostMapping(ShareTradingContants.SELLING_DETAILS)
	public ResponseEntity<SellingShare> getSellingDetails(@RequestBody SellingShare sellingShare) throws Exception {

		BigDecimal lastTradePrice = sellingShare.getLastTradePrice();

		BigDecimal quantity = sellingShare.getQuantity();

		BigDecimal averageCost = sellingShare.getAverageCost();

		BigDecimal investedAmount = ShareTradingUtils.multiply(averageCost, quantity);

		int holdingDurationInMonths = sellingShare.getHoldingDurationInMonths();

		BigDecimal totalSharesPrice = ShareTradingUtils.multiply(lastTradePrice, quantity);

		BigDecimal chargesIncludingGstOnSelling = ShareTradingHelper.getChargesIncludingGstOnSelling(totalSharesPrice);

		BigDecimal actualSellingPrice = ShareTradingUtils.subtract(totalSharesPrice, chargesIncludingGstOnSelling);

		BigDecimal profitOrLoss = ShareTradingUtils.subtract(actualSellingPrice, investedAmount);

		BigDecimal tax = ShareTradingHelper.calculateTax(profitOrLoss, holdingDurationInMonths);

		BigDecimal actualProfit = ShareTradingUtils.subtract(profitOrLoss, tax);

		SellingShare share = new SellingShare();
		share.setLastTradePrice(lastTradePrice);
		share.setQuantity(quantity);
		share.setAverageCost(averageCost);
		share.setInvestedAmount(investedAmount);
		share.setHoldingDurationInMonths(holdingDurationInMonths);
		share.setChargesIncludingGstOnSelling(chargesIncludingGstOnSelling);
		share.setTotalSharesPrice(totalSharesPrice);
		share.setActualSellingPrice(actualSellingPrice);
		share.setProfitOrLoss(profitOrLoss);
		share.setTax(tax);
		share.setActualProfit(actualProfit);

		return new ResponseEntity<>(share, HttpStatus.OK);
	}

	@PostMapping(ShareTradingContants.INVESTMENT_PERCENTAGE)
	public ResponseEntity<String> getPercentageOfInvestment(@RequestBody Stocks stock) throws Exception {

		BigDecimal investedAmountOfOneStock = stock.getInvestedAmountOfOneStock();

		BigDecimal totalInvestment = stock.getTotalInvestment();

		if (investedAmountOfOneStock.compareTo(totalInvestment) > 0) {
			return new ResponseEntity<>(ShareTradingContants.MSG_INVESTED_AMOUNT_GT_TOTAL_INVESTMENT,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

		BigDecimal percentageOfInvestment = ShareTradingUtils.getPercentageOfInvestment(investedAmountOfOneStock,
				totalInvestment);

		StringBuilder sbd = new StringBuilder(ShareTradingContants.SIXTY);
		sbd.append(ShareTradingContants.MSG_INVESTED_AMOUNT);
		sbd.append(percentageOfInvestment);
		sbd.append(ShareTradingContants.MSG_TOTAL_INVESTMENT_PERCENTAGE);

		String response = sbd.toString();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(ShareTradingContants.EQUITY_DETAILS)
	public ResponseEntity<Equity> getDetailsAfterAddingShares(@RequestBody Equity equity) throws Exception {
		equity = ShareTradingHelper.getDetailsAfterAddingShares(equity);
		return new ResponseEntity<>(equity, HttpStatus.OK);
	}
}