
$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});
$(document).on("click", "#btnSave", function(event) {
	// Clear status msges---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateMeterprofileForm();
	// If not valid
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid----------------------- 
	var type = ($("#hidMeterprofileSave").val() == "") ? "POST" : "PUT";
	$.ajax(
		{
			url: "MeterprofileServlet",
			type: type,
			data: $("#formMeterprofile").serialize(),
			dataType: "text",
			complete: function(response, status) {
				onItemSaveComplete(response.responseText, status);
			}
		});

	

});

$(document).on("click", ".btnUpdate", function(event) {
	$("#hidMeterprofileIDSave").val($(this).data("id"));
	$("#id").val($(this).closest("tr").find('td:eq(0)').text());
	$("#name").val($(this).closest("tr").find('td:eq(1)').text());
	$("#connection_type").val($(this).closest("tr").find('td:eq(2)').text());
	$("#estimated_power_consumption").val($(this).closest("tr").find('td:eq(3)').text());
	$("#owner").val($(this).closest("tr").find('td:eq(0)').text());
	$("#initialized_date").val($(this).closest("tr").find('td:eq(1)').text());
	$("#initialized_emp").val($(this).closest("tr").find('td:eq(2)').text());
	$("#location").val($(this).closest("tr").find('td:eq(3)').text());
});

$(document).on("click", ".btnRemove", function(event) {
	$.ajax(
		{
			url: "MeterprofileServlet",
			type: "DELETE",
			data: "itemID=" + $(this).data("itemid"),
			dataType: "text",
			complete: function(response, status) {
				onItemDeleteComplete(response.responseText, status);
			}
		});
});


function validateItemForm() {
	// Account number
	if ($("#id").val().trim() == "") {
		return "Insert Account number.";
	}
	// Customer name
	if ($("#name").val().trim() == "") {
		return "Insert Customer name.";
	}
	
	if ($("#connection_type").val().trim() == "") {
		return "Insert connection type.";
	}
	if ($("#estimated_power_consumption").val().trim() == "") {
		return "Insert power consumption.";
	}
	if ($("#owner").val().trim() == "") {
		return "Insert owner.";
	}
	if ($("#initialized_date").val().trim() == "") {
		return "Insert date.";
	}
	if ($("#location").val().trim() == "") {
		return "Insert location.";
	}
	// is numerical value
	var consumption = $("#estimated_power_consumption").val().trim();
	if (!$.isNumeric(consumption)) {
		return "Insert a numerical value.";
	}


	
	return true;
}


function onMeterprofileSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divMeterprofileGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidMeterprofileIDSave").val("");
	$("#formMeterprofile")[0].reset();
}

function onMeterprofileDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}
