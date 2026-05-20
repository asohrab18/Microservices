package com.management.weight.controller;

import java.math.BigDecimal;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}