/**
 * 
 */
document.write("Creating an external JavaScript file in Eclipse");

//create XMLHttpRequest object
const request = new XMLHttpRequest();
//open a get request with the remote server URL
request.open("GET", "http://localhost:8088/Meterprofile/myService/meterprofile/read");


//send the Http request
request.send();

request.onload =  function(){
	obj = json.parse(this.responseText);
	let text = "<table border='1'><tr><th>ID</th><th>Name</th><th>Connection Type</th>" + 
				"<th>Estimated Power consumption</th>" + 
				"<th>Owner</th><th>Initialized Date</th>" + 
				"<th>Initialized Date</th><tr>" + 
				"<th>Initialized emp</th><th>Location</th></tr>"
	for(let x in obj){
		for(let y in x){
			text += "<tr><td>" + id + "</td>";
			text += "<tr><td>" + name + "</td>";
			text += "<tr><td>" + connection_type + "</td>";
			text += "<tr><td>" + estimated_power_consumption + "</td>";
			text += "<tr><td>" + owner + "</td>";
			text += "<tr><td>" + initialized_date + "</td>";
			text += "<tr><td>" + initialized_emp + "</td>";
			text += "<tr><td>" + location + "</td>";
		}
		text  += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" +
						"<td><form method='post' action='items.jsp'>" +
						"<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" +
						"<input name='itemID' type='hidden' value='" 
						+ id + "'>" + "</form></td></tr>";
	}
				
}
document.getElementById("content_meter").innerHTML = request.send()


