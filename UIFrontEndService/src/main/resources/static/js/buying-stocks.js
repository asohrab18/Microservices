function submitBuyingStocksForm(event) {
	event.preventDefault();

	const oneSharePrice = parseFloat($('#oneSharePrice').val());
	const quantity = parseFloat($('#quantity').val());

	// Client-side validations
	if (isNaN(oneSharePrice) || isNaN(quantity)) {
		alert("⚠️ Please fill all fields correctly.");
		return;
	}

	if (oneSharePrice <= 0) {
		alert("One Share Price must be positive number.");
		return;
	}

	if (quantity <= 0) {
		alert("Quantity must be a positive number.");
		return;
	}

	const data = {
		oneSharePrice,
		quantity
	};

	$('#resultContainer').html('<div class="text-center mt-3"><div class="spinner-border text-primary" role="status"><span class="visually-hidden">Loading...</span></div></div>');

	//API Gateway Based URL: 
	$.ajax({
		url: 'http://localhost:8765/share-trading-service/share-trading/buying-details',
		method: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function(response) {
			displayResult(response);
		},
		error: function() {
			$('#resultContainer').html('<div class="alert alert-danger">❌ Failed to calculate plan. Try again later.</div>');
		}
	});
}


function displayResult(data) {
	const html = `
	<div class="card shadow-sm">
	    <div class="card-body">
	        <table class="table table-bordered table-striped text-center align-middle">
	            <thead class="table-dark">
	                <tr>
	                    <th>Quantity (Qty)</th>
	                    <th>Last Trade Price (LTP) of a Share</th>
	                    <th>Price of All Shares = (LTP × Qty)</th>
	                    <th>Charges Including GST on Buying</th>
	                    <th>Total Cost on Buying = (Price of All Shares + Charges Including GST)</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr>
	                    <td>${data.quantity}</td>
	                    <td>${data.oneSharePrice}</td>
	                    <td>${data.totalSharesPrice}</td>
	                    <td>${data.chargesIncludingGstOnBuying}</td>
	                    <td>
	                        <strong>${data.totalCostIncludingChargesAndGstOnBuying}</strong>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	</div>
  `;

	$('#resultContainer').html(html);
}
