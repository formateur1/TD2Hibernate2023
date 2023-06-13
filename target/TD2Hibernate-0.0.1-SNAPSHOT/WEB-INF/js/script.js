function afficherCB()
{
	var type = document.getElementById("type");
	while (type.firstChild) {
	  type.removeChild(type.firstChild);
	}
	
	var numeroCB = document.createElement("input");
	numeroCB.type = "text";
	numeroCB.placeholder = "Numéro CB";
	numeroCB.name = "numeroCB";
	
	type.appendChild(numeroCB);
	
	var dateE = document.createElement("input");
	dateE.type = "date";
	dateE.name = "dateE";
	dateE.placeholder = "date expiration";
	
	type.appendChild(dateE);
	
}

function afficherPaypal()
{
	var type = document.getElementById("type");
	while (type.firstChild) {
	  type.removeChild(type.firstChild);
	}
	
	var numPaypal = document.createElement("input");
	numPaypal.type = "number";
	numPaypal.placeholder = "Numéro Paypal";
	numPaypal.name = "numPaypal";
	
	type.appendChild(numPaypal);
}