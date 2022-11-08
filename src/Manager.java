package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Store {
	
	public String name;
	int managerID;
	int storeID;
	String username;
	String password;
	
	public Manager(int managerID, String name, int storeID,
			String username, String password) {
		super();
		this.managerID = managerID;
		this.name = name;
		this.storeID = storeID;
		this.username = username;
		this.password = password;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "insert into manager(managerID, managerName, storeID, userName, passw)"
					+ "values(?,?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setInt(1, managerID);
			pst.setString(2, name);
			pst.setInt(3, storeID);
			pst.setString(4, username);
			pst.setString(5, password);
			pst.executeUpdate();
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE manager" + 
					" SET managerName= '" + name +
					"' WHERE userName='" + username +
					"' AND passw='" + password+"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public int getManagerID() {
		return managerID;
	}
	
	/*
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	*/
	
	public int getStoreID() {
		return storeID;
	}
	/* ONLY ADMIN CAN CHANGE THE STORE ID OF THE MANAGER
	public void setStoreID(int storeID) {
		this.storeID = storeID;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE manager" + 
					" SET storeID= " + storeID +
					"WHERE userName='" + username +
					"' AND passw='" + password+"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}
	*/
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE manager" + 
					" SET userName='" + username +
					"' WHERE managerName='" + name +
					"' AND passw=" + password +"'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
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
			
			String query = "UPDATE manager " + 
					"SET passw='" + password +
					"' WHERE managerName='" + name +
					"' AND userName='" + username + "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public void addProduct(Product product) {
		this.category = product.category;
		this.description = product.description;
		this.dimen = product.dimen;
		this.discountRate = product.discountRate;
		this.discountStatus = product.discountStatus;
		this.price = product.price;
		this.productID = product.productID;
		this.productName = product.productName;
		this.quantity = product.quantity;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "insert into inventory(productID, productName, descr,"
					+ "price, dimen, category, quantity, discountStatus, discountRate, storeID )"
					+ "values(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setInt(1, product.getProductID());
			pst.setString(2, product.getProductName());
			pst.setString(3, product.getDescription());
			pst.setFloat(4, product.getPrice());
			pst.setString(5, product.getDimen());
			pst.setString(6, product.getCategory());
			pst.setInt(7, product.getQuantity());
			pst.setString(8, product.getDiscountStatus());
			pst.setFloat(9,product.getDiscountRate());
			pst.setInt(10, product.getStoreID());
			pst.executeUpdate();

			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void removeProduct(Product product) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "DELETE FROM inventory "
					+ "WHERE productID = "+ product.getProductID();
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			product = null;
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public void addSaleItem(Product product) {
		product.discountStatus = "YES";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET discountStatus = 'YES'"
					+ " WHERE productID = " + product.getProductID();
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void removeSaleItem(Product product) {
		product.discountStatus = "NO";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET discountStatus = 'NO'"
					+ " WHERE productID = " + product.getProductID();
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void setItemPrice(Product product, float price) {
		if (price > 0) {
			product.price = price;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ "SET price = " + price 
						+ " WHERE productID = " + product.getProductID();
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}
		
	}
	
	public void setItemName(Product product, String string) {
		product.productName = string;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET productName = '" + string 
					+ "' WHERE productID = " + product.getProductID();
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void setItemCategory(Product product, String string) {
		product.setCategory(string);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET category = '" + string 
					+ "' WHERE productID = " + product.getProductID();
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void setItemQuantity(Product product, int quantity) {
		if (quantity > 0) {
			product.setQuantity(quantity);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ " SET quantity = " + quantity 
						+ " WHERE productID = " + product.getProductID();
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}		
	}
	
	public void setItemDiscRate(Product product, float rate) {
		if (rate > 0) {
			product.setDiscountRate(rate);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ "SET discountRate = " + rate
						+ " WHERE productID = " + product.getProductID();
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}
		
	}
	
	public void setStoreName(Store store, String storeName) {
		store.storeName = storeName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE storeList" + 
					" SET storeName='" + storeName +
					"' WHERE storeID= " + storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public void setStoreLocation(Store store, String storeLocation) {
		store.setLocation(storeLocation);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "UPDATE storeList" + 
					" SET storeLocation='" + storeLocation +
					"' WHERE storeID= " + storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}
	
	public List<String> viewInventoryList() {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE storeID=" + storeID;
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
	
	public List<String> viewDiscountedItems() {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE storeID=" + storeID 
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
	
	public List<String> searchItemsByName(String string) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE productName=" + string;
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
					+ " WHERE category=" + string;
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
}
