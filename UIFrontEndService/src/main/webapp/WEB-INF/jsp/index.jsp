<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>UI Frontend Service</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

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
      <p class="text-muted fs-5">Welcome to the UI Frontend Microservice Dashboard</p>
    </div>

    <!-- Cards -->
    <div class="row g-4 justify-content-center">

      <!-- Students -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-info"><i class="bi bi-person-lines-fill"></i></div>
            <h5 class="card-title">Students Department</h5>
            <p class="card-text text-muted">Manage student records and information.</p>
            <a href="/html/students.html" class="btn btn-outline-primary w-100">👨‍🎓 Enter</a>
          </div>
        </div>
      </div>

      <!-- Employees -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-warning"><i class="bi bi-people-fill"></i></div>
            <h5 class="card-title">Employees Department</h5>
            <p class="card-text text-muted">Track employee details and manage staff.</p>
            <a href="/html/employees.html" class="btn btn-outline-primary w-100">👨‍💼 Enter</a>
          </div>
        </div>
      </div>

      <!-- Weight Management -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-success"><i class="bi bi-heart-pulse-fill"></i></div>
            <h5 class="card-title">Weight Management</h5>
            <p class="card-text text-muted">Calculate health goals and fitness progress.</p>
            <a href="/html/weight-management.html" class="btn btn-outline-primary w-100">🏋️ Enter</a>
          </div>
        </div>
      </div>

      <!-- Movies Catalog -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-danger"><i class="bi bi-film"></i></div>
            <h5 class="card-title">Movies Catalog</h5>
            <p class="card-text text-muted">Display movies with ratings given by users.</p>
            <a href="/html/movies-catalog.html" class="btn btn-outline-primary w-100">🎬 Enter</a>
          </div>
        </div>
      </div>

      <!-- Calculator -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-primary"><i class="bi bi-calculator-fill"></i></div>
            <h5 class="card-title">Calculator</h5>
            <p class="card-text text-muted">Calculate factorial of a number.</p>
            <a href="/html/calculator.html" class="btn btn-outline-primary w-100">🧮 Enter</a>
          </div>
        </div>
      </div>
      
      <!-- Buying Stocks -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-primary"><i class="bi bi-calculator-fill"></i></div>
            <h5 class="card-title">Buying Stocks</h5>
            <p class="card-text text-muted">Calculate estimated cost when buying stocks.</p>
            <a href="/html/buying-stocks.html" class="btn btn-outline-primary w-100">🧮 Enter</a>
          </div>
        </div>
      </div>

	  <!-- Selling Stocks -->
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body text-center">
            <div class="mb-3 fs-1 text-primary"><i class="bi bi-calculator-fill"></i></div>
            <h5 class="card-title">Selling Stocks</h5>
            <p class="card-text text-muted">Calculate actual profit when selling stocks.</p>
            <a href="/html/selling-stocks.html" class="btn btn-outline-primary w-100">🧮 Enter</a>
          </div>
        </div>
      </div>

    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>