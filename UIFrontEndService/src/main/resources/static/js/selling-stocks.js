function submitSellingStocksForm(event) {
  event.preventDefault();

  const lastTradePrice = parseFloat($('#lastTradePrice').val());
  const quantity = parseFloat($('#quantity').val());
  const averageCost = parseFloat($('#averageCost').val());
  const holdingDurationInMonths = parseInt($('#holdingDurationInMonths').val());

  // Client-side validations
  if (isNaN(lastTradePrice) || isNaN(quantity) || isNaN(averageCost)) {
    alert("⚠️ Please fill all fields correctly.");
    return;
  }

  if (lastTradePrice <= 0) {
    alert("Last Trade Price must be positive number.");
    return;
  }

  if (quantity <= 0) {
    alert("Quantity must be a positive number.");
    return;
  }
  
  if (averageCost <= 0) {
      alert("Average Cost must be a positive number.");
      return;
  }

  const data = {
    lastTradePrice,
    quantity,
	averageCost,
	holdingDurationInMonths
  };

  $('#resultContainer').html('<div class="text-center mt-3"><div class="spinner-border text-primary" role="status"><span class="visually-hidden">Loading...</span></div></div>');

//API Gateway Based URL: 
  $.ajax({
    url: 'http://localhost:8765/share-trading-service/share-trading/selling-details',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(data),
    success: function (response) {
      displayResult(response);
    },
    error: function () {
      $('#resultContainer').html('<div class="alert alert-danger">❌ Failed to calculate plan. Try again later.</div>');
    }
  });
}


function displayResult(data) {
  const html = `
  <div class="card shadow-sm">
  	    <div class="card-body">
  	        <table class="table table-bordered table-striped text-center align-middle">
  	            <thead style="background-color:#1f2937; color:white;">
  	                <tr>
						<th>Quantity<br><small>(Qty)</small></th>
						<th>Average Cost<br><small>(Avg. cost)</small></th>
						<th>Invested Amount<br><small>(Avg. cost * Qty)</small></th>
						<th>Last Trade Price of a Share<br><small>(LTP)</small></th>
						<th>Current Value of all Shares (Cur. val)<br><small>(LTP * Qty)</small></th>
	  	                <th>Charges<br><small>Including GST on Selling</small></th>
						<th>Profit or Loss<br><small>(Cur. val - Invested Amount - Charges)</small></th>
						<th>Holding Duration<br><small>(In Months)</small></th>
		                <th>Tax</th>
						<th>Actual Profit or Loss<br><small>(Profit or Loss - Tax)</small></th>
  	                </tr>
  	            </thead>
  	            <tbody>
  	                <tr>
  	                    <td>${data.quantity}</td>
  	                    <td>${data.averageCost}</td>
  	                    <td>${data.investedAmount}</td>
  	                    <td>${data.lastTradePrice}</td>
  						<td>${data.totalSharesPrice}</td>
  	                    <td>${data.chargesIncludingGstOnSelling}</td>
  	                    <td>${data.profitOrLoss}</td>
  	                    <td>${data.holdingDurationInMonths}</td>
  						<td>${data.tax}</td>
  	                    <td>
  	                        <strong>${data.actualProfit}</strong>
  	                    </td>
  	                </tr>
  	            </tbody>
  	        </table>
  	    </div>
  	</div>
  `;

  $('#resultContainer').html(html);
}
