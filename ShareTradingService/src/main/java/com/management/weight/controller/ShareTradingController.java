package com.management.weight.controller;

import java.math.BigDecimal;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.weight.helper.ShareTradingHelper;
import com.management.weight.model.BuyingShare;
import com.management.weight.model.SellingShare;
import com.management.weight.utils.ShareTradingContants;
import com.management.weight.utils.ShareTradingUtils;

@RestController
@RefreshScope
@RequestMapping(ShareTradingContants.SHARE_TARDING)
public class ShareTradingController {

	@GetMapping(ShareTradingContants.BUYING_DETAILS)
	public ResponseEntity<BuyingShare> getBuyingDetails(@RequestParam BigDecimal oneSharePrice, @RequestParam BigDecimal quantity)
			throws Exception {

		BigDecimal totalSharesPrice = ShareTradingUtils.multiply(oneSharePrice, quantity);

		BigDecimal chargesIncludingGstOnBuying = ShareTradingHelper.getChargesIncludingGstOnBuying(totalSharesPrice);

		BigDecimal totalCostIncludingChargesAndGstOnBuying = ShareTradingUtils.add(totalSharesPrice, chargesIncludingGstOnBuying);

		BuyingShare share = new BuyingShare();
		share.setOneSharePrice(oneSharePrice);
		share.setQuantity(quantity);
		share.setTotalSharesPrice(totalSharesPrice);
		share.setChargesIncludingGstOnBuying(chargesIncludingGstOnBuying);
		share.setTotalCostIncludingChargesAndGstOnBuying(totalCostIncludingChargesAndGstOnBuying);

		return new ResponseEntity<>(share, HttpStatus.OK);
	}

	@GetMapping(ShareTradingContants.SELLING_DETAILS)
	public ResponseEntity<SellingShare> getSellingDetails(@RequestParam String lastTradePrice,
			@RequestParam String quantity, @RequestParam String avgCost, @RequestParam String invested,
			@RequestParam int holdingDurationInMonths) throws Exception {

		BigDecimal ltp = ShareTradingUtils.getBigDecimal(lastTradePrice);
		BigDecimal qty = ShareTradingUtils.getBigDecimal(quantity);
		BigDecimal totalPrice = ShareTradingUtils.multiply(ltp, qty);

		BigDecimal chargesIncludingGstOnSelling = ShareTradingHelper.getChargesIncludingGstOnSelling(totalPrice);

		BigDecimal actualSellingPrice = ShareTradingUtils.subtract(totalPrice, chargesIncludingGstOnSelling);
		BigDecimal averageCost = ShareTradingUtils.getBigDecimal(avgCost);
		BigDecimal investedAmount = ShareTradingUtils.getBigDecimal(invested);
		BigDecimal profitOrLoss = ShareTradingUtils.subtract(actualSellingPrice, investedAmount);

		BigDecimal tax = ShareTradingHelper.calculateTax(profitOrLoss, holdingDurationInMonths);

		BigDecimal actualProfit = ShareTradingUtils.subtract(profitOrLoss, tax);

		SellingShare share = new SellingShare();
		share.setLastTradePrice(ltp);
		share.setQuantity(qty);
		share.setAvgCost(averageCost);
		share.setInvestedAmount(investedAmount);
		share.setHoldingDurationInMonths(holdingDurationInMonths);
		share.setChargesIncludingGstOnSelling(chargesIncludingGstOnSelling);
		share.setTotalPrice(totalPrice);
		share.setActualSellingPrice(actualSellingPrice);
		share.setProfitOrLoss(profitOrLoss);
		share.setTax(tax);
		share.setActualProfit(actualProfit);

		return new ResponseEntity<>(share, HttpStatus.OK);
	}
}