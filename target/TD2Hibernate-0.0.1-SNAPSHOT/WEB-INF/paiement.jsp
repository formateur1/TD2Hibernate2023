<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paiement</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
	<style type="text/css"><%@ include file="/WEB-INF/css/style.css" %></style>
	<script type="text/javascript"><%@ include file="/WEB-INF/js/script.js" %></script>
</head>
<body>
	<form method="post">
  <div class="mb-3">
    <label for="montant" class="form-label">Montant</label>
    <input type="text" class="form-control" name="montant" >
  </div>
  <div class="mb-3">
    <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="typeP" value="CB" onclick="afficherCB()">
  <label class="form-check-label" for="typeP1">CB</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="typeP" value="Paypal" onclick="afficherPaypal()">
  <label class="form-check-label" for="typeP2">Paypal</label>
</div>
	
	<div id="type"></div>

  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
  <button type="reset" class="btn btn-danger">Reset</button>
</form>
</body>
</html>