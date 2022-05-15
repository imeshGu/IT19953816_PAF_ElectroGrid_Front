package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Meterprofile;

//dao leyer
//
public class MeterprofileDao {
	// connect with data base
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "taekwon do");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	

	// insert data into meterprofile database
	public String registerMeterprofile(String id, String name, String connection_type, 
			 String estimated_power_consumption, String owner, String initialized_date, String initialized_emp, String location) {
		String insert_meterprofile = "insert into electrogrid_meterprofile.meterprofile"
				+ "(id, name, connection_type,estimated_power_consumptionl, owner, initialized_date, initialized_emp, location) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?);";
		System.out.println("registerMeterprofile");

		String output = "";
		try {
			Connection connection = getConnection();
			if (connection == null) 
			 { 
				return "Error while connecting to the database for inserting."; 
			 } 
			PreparedStatement preparedStatement = connection.prepareStatement(insert_meterprofile);

			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, connection_type);
			preparedStatement.setString(4, estimated_power_consumption);
			preparedStatement.setString(5, owner);
			preparedStatement.setString(6, initialized_date);
			preparedStatement.setString(7, initialized_emp);
			preparedStatement.setString(8, location);

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			connection.close();
			
			String newMeter = selectAllMeterprofile(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 newMeter + "\"}"; 

		} catch (Exception e) {
			System.out.println(e);
		}

		return output;

	}

	// retrieve all meter profiles under a one user
	// output a list of meter profile objects
	public List<Meterprofile> selectAllMeterprofileByUser(String user) {

		String select_meterprofile_by_user = "select * from electrogrid_meterprofile.meterprofile where owner=?;";
		List<Meterprofile> meterprofiles = new ArrayList<>();
		Connection connection = null;

		try {
			connection = getConnection();// get connection
			PreparedStatement statement = connection.prepareStatement(select_meterprofile_by_user);
			statement.setString(1, user);
			System.out.println(statement);
			ResultSet result = statement.executeQuery();// run the sql query

			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				// adding each meter profile to a list
				meterprofiles.add(new Meterprofile(id, name, connection_type, estimated_power_consumption, owner,
						initialized_date, initialized_emp, location));

			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return meterprofiles;
	}

	// retrieve all meter profiles 
	// output a list of meter profile objects
	public String selectAllMeterprofile() {

		String select_meterprofile_by_user = "select * from electrogrid_meterprofile.meterprofile;";
		List<Meterprofile> meterprofiles = new ArrayList<>();
		Connection connection = null;

		// Prepare the html table to be displayed
		String output = "<table border='1'><tr><th>Meterprofile No</th><th>Name</th>" +
				"<th>Connection Type</th>" + 
				"<th>Estimated Power Consumption</th>" +
				"<th>Owner</th>" + "<th>Initialized Date</th>" +
				"<th>Initialized Employee</th>" + "<th>location</th>" + 
				"<th>Update</th><th>Request for Removal</th></tr>";
		
		try {
			connection = getConnection();//get connection between database 
			PreparedStatement statement = connection.prepareStatement(select_meterprofile_by_user);
			System.out.println(statement);
			ResultSet result = statement.executeQuery();//sql

			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				System.out.println(id);
				meterprofiles.add(new Meterprofile(id, name, connection_type, estimated_power_consumption, owner,
						initialized_date, initialized_emp, location));
				
				// Add into the html table
				output += "<tr><td><input type='hidden' name='hideMeterprofileDUpdate' id='hideMeterprofileDUpdate' value='"+id+"'>" + id + "</td>"; 
				output += "<td>" + name + "</td>"; 
				output += "<td>" + connection_type + "</td>"; 
				output += "<td>" + estimated_power_consumption + "</td>";
				output += "<td>" + owner + "</td>";
				output += "<td>" + initialized_date + "</td>"; 
				output += "<td>" + initialized_emp + "</td>"; 
				output += "<td>" + location + "</td>";
				//btn
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-inquiryid='"+id+"'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-secondary' data-inquiryid='"+id+"'></td></tr>"; 


				}

			connection.close();

		} catch (Exception e) {
			
			output = "Error while reading the items."; 
			System.err.println(e.getMessage()); 

		}
		return output;
	}
	//retrieve meter profile by its id
	//output a meter profile objects
	public Meterprofile selectMeterprofile(String id) throws SQLException {

		String select_meterprofile = "select * from electrogrid_meterprofile.meterprofile where id=?;";
		Meterprofile meter = null;
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(select_meterprofile);
			statement.setString(1, id);
			System.out.println(statement);
			ResultSet result = statement.executeQuery();//sql

			while (result.next()) {
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				meter = new Meterprofile(id, name, connection_type, estimated_power_consumption, owner,
						initialized_date, initialized_emp, location);
			
			}

			connection.close();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return meter;

	}
	//retrieve all meter profiles that have been requested to be deleted 
	//output a list of meter profile objects
	public List<Meterprofile> selectMeterprofileByRequest() throws SQLException {

		String select_meterprofile = "SELECT * FROM electrogrid_meterprofile.meterprofile where request_delete=1;";
		List<Meterprofile> meters = new ArrayList<>();
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(select_meterprofile);

			System.out.println(statement);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String connection_type = result.getString("connection_type");
				String estimated_power_consumption = result.getString("estimated_power_consumptionl");
				String owner = result.getString("owner");
				String initialized_date = result.getString("initialized_date");
				String initialized_emp = result.getString("initialized_emp");
				String location = result.getString("location");
				String request_delete = result.getString("request_delete");
				meters.add(new Meterprofile(id, name, connection_type, estimated_power_consumption, owner,
						initialized_date, initialized_emp, location, request_delete));

			}

			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return meters;

	}
	//update meter profile
	public String updateMeterprofile(String id, String name, String connection_type, 
			 String estimated_power_consumption, String owner, String initialized_date, String initialized_emp, String location) {
		String update_meterprofile = "update electrogrid_meterprofile.meterprofile set name=?,connection_type=?,estimated_power_consumption=?,owner=?,initialized_date=?,initialized_emp=?,location=? where id=?;";

	
		String output = ""; 
		Connection connection = null;
		try {
			connection = getConnection();
			if (connection == null) 
			 { 
				return "Error while connecting to the database for updating."; 
			 } 
			PreparedStatement statement = connection.prepareStatement(update_meterprofile);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, connection_type);
			statement.setString(4, estimated_power_consumption);
			statement.setString(5, owner);
			statement.setString(6, initialized_date);
			statement.setString(7, initialized_emp);
			statement.setString(8, location);

			statement.executeUpdate();
			connection.close(); 
			
			String newMeter = selectAllMeterprofile(); 
			output = "{\"status\":\"success\", \"data\": \"" + 
					 newMeter + "\"}"; 

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
			System.err.println(e.getMessage()); 
		}

		return output;
	}
	//delete meter profile
	public String deleteMeterprofile(String id) {
		System.out.println("Here at Dao");
		String delete_meterprofile = "delete from electrogrid_meterprofile.meterprofile where id=?;";
		String output = ""; 
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_meterprofile);
			statement.setString(1, id);
			statement.executeUpdate();
			connection.close();
			
			String newMeter = selectAllMeterprofile(); 
			output = "{\"status\":\"success\", \"data\": \"" + 
					 newMeter + "\"}"; 

			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
			System.err.println(e.getMessage()); 

		}
		return output;
	}

	public String getCostomers() {
		String apr = "Customer/getCustomer";
		
		return null;
	}
}
