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
	public int registerMeterprofile(Meterprofile meterprofile) {
		String insert_meterprofile = "insert into electrogrid_meterprofile.meterprofile"
				+ "(id, name, connection_type,estimated_power_consumptionl, owner, initialized_date, initialized_emp, location) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?);";
		System.out.println("registerMeterprofile");
		int result = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert_meterprofile);

			preparedStatement.setString(1, meterprofile.getId());
			preparedStatement.setString(2, meterprofile.getName());
			preparedStatement.setString(3, meterprofile.getConnection_type());
			preparedStatement.setString(4, meterprofile.getEstimated_power_consumption());
			preparedStatement.setString(5, meterprofile.getOwner());
			preparedStatement.setString(6, meterprofile.getInitialized_date());
			preparedStatement.setString(7, meterprofile.getInitialized_emp());
			preparedStatement.setString(8, meterprofile.getLocation());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;

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
	public List<Meterprofile> selectAllMeterprofile() {

		String select_meterprofile_by_user = "select * from electrogrid_meterprofile.meterprofile;";
		List<Meterprofile> meterprofiles = new ArrayList<>();
		Connection connection = null;

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

				}

			connection.close();

		} catch (Exception e) {
			
			System.out.println(e);
		}
		return meterprofiles;
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
	public String updateMeterprofile(Meterprofile meter) {
		String update_meterprofile = "update electrogrid_meterprofile.meterprofile set name=?,connection_type=?,estimated_power_consumption=?,owner=?,initialized_date=?,initialized_emp=?,location=? where id=?;";

		int result = 0;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(update_meterprofile);
			statement.setString(1, meter.getName());
			statement.setString(2, meter.getConnection_type());
			statement.setString(3, meter.getEstimated_power_consumption());
			statement.setString(4, meter.getOwner());
			statement.setString(5, meter.getInitialized_date());
			statement.setString(6, meter.getInitialized_emp());
			statement.setString(7, meter.getLocation());
			statement.setString(8, meter.getId());

			result = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("have an error in Dao update!!!!");
			System.out.println(e);
		}

		return Integer.toString(result);
	}
	//delete meter profile
	public int deleteMeterprofile(String id) {
		System.out.println("Here at Dao");
		String delete_meterprofile = "delete from electrogrid_meterprofile.meterprofile where id=?;";

		int result = 0;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_meterprofile);
			statement.setString(1, id);
			result = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception found in delete Dao");
			System.out.println(e);
		}
		return result;
	}

	public String getCostomers() {
		String apr = "Customer/getCustomer";
		
		return null;
	}
}
