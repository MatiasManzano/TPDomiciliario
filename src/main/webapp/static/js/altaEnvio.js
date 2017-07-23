$(document).ready(function() {
	if ($("#tipo").val() == "3") {
		$("#divNroCertificacion").show();
	}

	$("#tipo").change(function() {
		if ($("#tipo").val() == "3") {
			$("#divNroCertificacion").show();
		} else {
			$("#divNroCertificacion").hide();
		}
	});

	$('#verimporte').click(function() {
		$(".alert").show();
		calcularImporte();
	});
	

		function calcularImporte() {
		var ciudad = $("#ciudad").val();
		var json = {
			ciudad : ciudad
		};

		$.ajax({
			url : 'nuevoEnvio',
			data : json,
			type : "GET",
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			timeout: 9999999,
			success : function(res) {
				$("#importe").html(res.importe);
			}

		})

	}
	
	
	

});