function submitPercentageStockForm(event) {
	event.preventDefault();

	const investedAmountOfOneStock = parseFloat($('#investedAmountOfOneStock').val());
	const totalInvestment = parseFloat($('#totalInvestment').val());

	// Client-side validations
	if (isNaN(investedAmountOfOneStock) || isNaN(totalInvestment)) {
		alert("⚠️ Please fill all fields correctly.");
		return;
	}

	if (investedAmountOfOneStock <= 0) {
		alert("Invested Amount of a Stock must be positive number.");
		return;
	}

	if (totalInvestment <= 0) {
		alert("Total Investment must be a positive number.");
		return;
	}

	if (investedAmountOfOneStock > totalInvestment) {
		alert("Invested Amount of a Stock cannot be greater than Total Investment.");
		return;
	}
	
	const data = {
		investedAmountOfOneStock,
		totalInvestment
	};

	$('#resultContainer').html('<div class="text-center mt-3"><div class="spinner-border text-primary" role="status"><span class="visually-hidden">Loading...</span></div></div>');

	//API Gateway Based URL: 
	$.ajax({
		url: 'http://localhost:8765/share-trading-service/share-trading/investment-percentage',
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
	            <thead style="background-color:#1f2937; color:white;">
	                <tr>
	                    <th>Percentage of a Stock</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr>
	                    <td>${data}</td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	</div>
  `;

	$('#resultContainer').html(html);
}
