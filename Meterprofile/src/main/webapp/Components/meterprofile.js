
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
	var status = validateItemForm();
	// If not valid
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid----------------------- 
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
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

	// Generate the card and append
	var student = getStudentCard($("#txtName").val().trim(),
		$('input[name="rdoGender"]:checked').val(),
		$("#ddlYear").val());
	$("#colStudents").append(student);

	$("#alertSuccess").text("Saved successfully.");
	$("#alertSuccess").show();

	$("#formStudent")[0].reset();

});

$(document).on("click", ".btnUpdate", function(event) {
	$("#hidMeterprofileIDSave").val($(this).data("id"));
	$("#itemCode").val($(this).closest("tr").find('td:eq(0)').text());
	$("#itemName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#itemPrice").val($(this).closest("tr").find('td:eq(2)').text());
	$("#itemDesc").val($(this).closest("tr").find('td:eq(3)').text());
	$("#itemCode").val($(this).closest("tr").find('td:eq(0)').text());
	$("#itemName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#itemPrice").val($(this).closest("tr").find('td:eq(2)').text());
	$("#itemDesc").val($(this).closest("tr").find('td:eq(3)').text());
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
	if ($("#accountNum").val().trim() == "") {
		return "Insert Account number.";
	}
	// Customer name
	if ($("#Name").val().trim() == "") {
		return "Insert Customer name.";
	}
	// Contact number
	if ($("#contactNum").val().trim() == "") {
		return "Insert Contact number.";
	}
	// is numerical value
	var tmpContact = $("#contactNum").val().trim();
	if (!$.isNumeric(tmpContact)) {
		return "Insert a numerical value for Contact number.";
	}

	// Email address
	if ($("#email").val().trim() == "") {
		return "Insert Email address.";
	}
	// Inquiry details
	if ($("#inquiryDet").val().trim() == "") {
		return "Insert your Inquiry.";
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

function onItemDeleteComplete(response, status) {
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
