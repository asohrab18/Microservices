<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UI Frontend Service</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
	rel="stylesheet">

<style>
/* Hover effect for cards */
.card:hover {
	transform: translateY(-5px);
	transition: 0.3s ease-in-out;
	box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
}
</style>
</head>
<body class="bg-light">
	<div class="container py-5">
		<!-- Header -->
		<div class="text-center mb-5">
			<h1 class="fw-bold text-primary">📘 Information Department</h1>
			<p class="text-muted fs-5">Welcome to the UI Frontend
				Microservice Dashboard</p>
		</div>

		<!-- Cards -->
		<div class="row g-4 justify-content-center">

			<!-- Students -->
			<c:if test="${studentsVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-info">
								<i class="bi bi-person-lines-fill"></i>
							</div>
							<h5 class="card-title">Students Department</h5>
							<p class="card-text text-muted">Manage student records and
								information.</p>
							<a
								href="${pageContext.request.contextPath}/html/students.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}"
								class="btn btn-outline-primary w-100"> 👨‍🎓 Enter </a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Employees -->
			<c:if test="${employeesVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-warning">
								<i class="bi bi-people-fill"></i>
							</div>
							<h5 class="card-title">Employees Department</h5>
							<p class="card-text text-muted">Track employee details and
								manage staff.</p>
							<a href="${pageContext.request.contextPath}/html/employees.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">👨‍💼 Enter</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Weight Management -->
			<c:if test="${weightManagementVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-success">
								<i class="bi bi-heart-pulse-fill"></i>
							</div>
							<h5 class="card-title">Weight Management</h5>
							<p class="card-text text-muted">Calculate health goals and
								fitness progress.</p>
							<a href="${pageContext.request.contextPath}/html/weight-management.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🏋️ Enter</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Movies Catalog -->
			<c:if test="${moviesCatalogVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-danger">
								<i class="bi bi-film"></i>
							</div>
							<h5 class="card-title">Movies Catalog</h5>
							<p class="card-text text-muted">Display movies with ratings
								given by users.</p>
							<a href="${pageContext.request.contextPath}/html/movies-catalog.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🎬 Enter</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Calculator -->
			<c:if test="${calculatorVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-primary">
								<i class="bi bi-calculator-fill"></i>
							</div>
							<h5 class="card-title">Calculator</h5>
							<p class="card-text text-muted">Calculate factorial of a
								number.</p>
							<a href="${pageContext.request.contextPath}/html/calculator.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🧮 Enter</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Buying Stocks -->
			<c:if test="${buyingStocksVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-primary">
								<i class="bi bi-calculator-fill"></i>
							</div>
							<h5 class="card-title">Buying Stocks</h5>
							<p class="card-text text-muted">Calculate estimated cost when buying stocks.</p>
							<a href="${pageContext.request.contextPath}/html/buying-stocks.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🧮 Enter</a>
						</div>
					</div>
				</div>
			</c:if>

			<!-- Selling Stocks -->
			<c:if test="${sellingStocksVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-primary">
								<i class="bi bi-calculator-fill"></i>
							</div>
							<h5 class="card-title">Selling Stocks</h5>
							<p class="card-text text-muted">Calculate actual profit when
								selling stocks.</p>
							<a href="${pageContext.request.contextPath}/html/selling-stocks.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🧮 Enter</a>
						</div>
					</div>
				</div>
			</c:if>
			
			<!-- Percentage of a Stock -->
			<c:if test="${percentageStockVisible}">
				<div class="col-md-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<div class="mb-3 fs-1 text-primary">
								<i class="bi bi-calculator-fill"></i>
							</div>
							<h5 class="card-title">Percentage of a Stock</h5>
							<p class="card-text text-muted">Calculate percentage of a Stock.</p>
							<a href="${pageContext.request.contextPath}/html/percentage-stock.html${empty pageContext.request.queryString ? '' : '?'}${pageContext.request.queryString}" class="btn btn-outline-primary w-100">🧮 Enter</a>
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>