function submitEquityDetailsForm(event) {
  event.preventDefault();

  const quantity = parseFloat($('#quantity').val());
  const averageCost = parseFloat($('#averageCost').val());
  const lastTradePrice = parseFloat($('#lastTradePrice').val());
  const desiredAmountToBeAdded = parseFloat($('#desiredAmountToBeAdded').val());

  // Client-side validations
  if (isNaN(lastTradePrice) || isNaN(quantity) || isNaN(averageCost) || isNaN(desiredAmountToBeAdded)) {
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
  
  if (desiredAmountToBeAdded <= 0) {
        alert("Desired Amount must be a positive number.");
        return;
    }

  const data = {
    quantity,
	averageCost,
	lastTradePrice,
	desiredAmountToBeAdded
  };

  $('#resultContainer').html('<div class="text-center mt-3"><div class="spinner-border text-primary" role="status"><span class="visually-hidden">Loading...</span></div></div>');

//API Gateway Based URL: 
  $.ajax({
    url: 'http://localhost:8765/share-trading-service/share-trading/equity-details',
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
						<th>Desired Amount To Be Added</th>
	  	                <th>New Quantity<br><small>(New Qty)</small></th>
						<th>New Invested Amount<br><small>(LTP * New Qty)</small></th>
						<th>Total Invested Amount<br><small>(Invested Amount + New Invested Amount)</small></th>
		                <th>Total Quantity<br><small>(Qty + New Qty)</small></th>
						<th>New Average Cost<br><small>(New Avg. cost)</small></th>
						<th>Average Cost Difference<br><small>(Avg. cost - New Avg. cost)</small></th>
  	                </tr>
  	            </thead>
  	            <tbody>
  	                <tr>
  	                    <td>${data.quantity}</td>
  	                    <td>${data.averageCost}</td>
  	                    <td>${data.investedAmount}</td>
  	                    <td>${data.lastTradePrice}</td>
  						<td>${data.desiredAmountToBeAdded}</td>
  	                    <td>${data.quantityNew}</td>
  	                    <td>${data.investedAmountNew}</td>
  	                    <td>${data.totalInvestedAmount}</td>
  						<td>${data.totalQuantity}</td>
  	                    <td>
  	                        <strong>${data.averageCostNew}</strong>
  	                    </td>
						<td>${data.averageCostDifference}</td>
  	                </tr>
  	            </tbody>
  	        </table>
  	    </div>
  	</div>
  `;

  $('#resultContainer').html(html);
}
