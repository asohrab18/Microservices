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
import com.management.weight.utils.ShareTradingContants;
import com.management.weight.utils.ShareTradingUtils;

@RestController
@RefreshScope
@RequestMapping(ShareTradingContants.SHARE_TARDING)
public class ShareTradingController {

	@GetMapping(ShareTradingContants.BUYING_DETAILS)
	public ResponseEntity<BuyingShare> getBuyingDetails(@RequestParam String price, @RequestParam String quantity)
			throws Exception {

		BigDecimal oneSharePrice = ShareTradingUtils.getBigDecimal(price);
		BigDecimal qty = ShareTradingUtils.getBigDecimal(quantity);
		BigDecimal totalPrice = ShareTradingUtils.multiply(oneSharePrice, qty);

		BigDecimal chargesIncludingGstOnBuying = ShareTradingHelper.getChargesIncludingGstOnBuying(totalPrice);

		BigDecimal totalCostIncludingChargesAndGstOnBuying = ShareTradingUtils.add(totalPrice,
				chargesIncludingGstOnBuying);

		BuyingShare share = new BuyingShare();
		share.setOneSharePrice(oneSharePrice);
		share.setQuantity(qty);
		share.setTotalPrice(totalPrice);
		share.setChargesIncludingGstOnBuying(chargesIncludingGstOnBuying);
		share.setTotalCostIncludingChargesAndGstOnBuying(totalCostIncludingChargesAndGstOnBuying);

		return new ResponseEntity<>(share, HttpStatus.OK);
	}
}