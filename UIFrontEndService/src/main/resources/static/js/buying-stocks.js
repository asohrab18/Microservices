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
	  	<p><strong>Quantity:</strong> ${data.quantity}</p>
        <p><strong>Last Trade Price (LTP) of a share:</strong> ${data.oneSharePrice}</p>
        <p><strong>Price of all shares = (LTP * Qty):</strong> ${data.totalSharesPrice}</p>
        <p><strong>Charges including GST on buying:</strong> ${data.chargesIncludingGstOnBuying}</p>
        <hr />
        <p><strong>Total Cost on buying = (Price of all shares + Charges including GST):</strong> ${data.totalCostIncludingChargesAndGstOnBuying}</p>
      </div>
    </div>
  `;

  $('#resultContainer').html(html);
}
