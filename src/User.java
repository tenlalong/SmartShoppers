package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class User {
	public String fullName;
	private String username;
	private String password;
	private String phoneNumber;
	private String currentLocation;
	private String preferredLocation;
	
	public User(String fullName, String username, String password,
			String phoneNumber, String currentLocation, String preferredLocation) {
		
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.currentLocation = currentLocation;
		this.preferredLocation = preferredLocation;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "insert into customerInfo(fullName, userName, passw, phoneNo, currLocation, prefLocation)"
					+ "values(?,?,?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setString(1, fullName);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, phoneNumber);
			pst.setString(5, currentLocation);
			pst.setString(6, preferredLocation);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public User() {
		
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "UPDATE CustomerInfo" + 
					" SET fullName= '" + fullName +
					"' WHERE userName= '" + username +
					"' AND passw='" + password+"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {

		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE CustomerInfo" + 
					" SET userName='" + username +
					"' WHERE fullName='" + fullName +
					"' AND passw='" + password +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE CustomerInfo" + 
					" SET passw= '" + password+
					"' WHERE fullName= '" + fullName +
					"' AND userName=" + username + "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE CustomerInfo " + 
					"SET phoneNo='" + phoneNumber +
					"' WHERE fullName='" + fullName +
					"' AND userName=" + username +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE CustomerInfo" + 
					" SET currLocation='" + currentLocation +
					"' WHERE fullName= '" + fullName +
					"' AND userName=" + username +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public String getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "UPDATE CustomerInfo" + 
					" SET prefLocation='" + preferredLocation +
					"' WHERE fullName= '" + fullName +
					"' AND userName='" + username + "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}
	
	public void deleteUser() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "DELETE FROM CustomerInfo " +
					" WHERE fullName='" + fullName +
					"' AND userName='" + username +
					"' AND passw='" + password +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
		} catch (Exception ex) {
		}
	}

	public List<String> searchItemsByName(String string) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE productName='" + string+"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString(2));	// Get the list of inventory names
			}
			Con.close();
		} catch (Exception exc) {
		}
		return result;
	}
	
	public List<String> searchItemsByCategory(String string) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE category='" + string +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString(2));	// Get the list of inventory names
			}
			Con.close();
		} catch (Exception exc) {
		}
		return result;
	}
	
	public List<String> viewInventoryList(Store store) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE storeID=" + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString(2));	// Get the list of inventory names
			}
			Con.close();
		} catch (Exception exc) {
		}
		return result;
	}
	
	public List<String> viewDiscountedItems(Store store) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE storeID=" + store.storeID 
					+ " AND discountStatus='YES'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString(2));	// Get the list of inventory names
			}
			Con.close();
		} catch (Exception exc) {
		}
		return result;
	}

	public void addItemtoCart(List<String> cart, Product product) {
		cart.add(product.productName);
	}

	public void addItemPricetoCart(List<Float> cartPrice, Product product) {
		cartPrice.add(product.price);
	}
	
	public void removeItemFromCart(List<String> cart, Product product) {
		cart.remove(product.productName);
	}
	
	public void removeItemPriceFromCart(List<Float> cart, Product product) {
		cart.remove(product.price);
	}
}
