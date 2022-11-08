package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Manager{

	private int adminID;
	private String name;
	private String username;
	private String password;
	
	public Admin(int adminID, String name, String username, String password) {
		super();
		this.adminID = adminID;
		this.name = name;
		this.username = username;
		this.password = password;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "insert into administrator(adminID, adminName, userName, passw)"
					+ "values(?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setInt(1, adminID);
			pst.setString(2, name);
			pst.setString(4, username);
			pst.setString(5, password);
			pst.executeUpdate();
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public int getAdminID() {
		return adminID;
	}
	
	/*
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE administrator" + 
					" SET adminName='" + name +
					"' WHERE userName='" + username +
					"' AND passw='" + password+ "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
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
			
			String query = "UPDATE administrator" + 
					" SET userName='" + username +
					"' WHERE adminName='" + name +
					"' AND passw='" + password + "'";
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
			
			String query = "UPDATE administrator" + 
					" SET passw='" + password+
					"' WHERE adminName='" + name +
					"' AND userName='" + username + "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
			
		} catch (Exception exc) {
		}
	}

	public void addManager(Manager manager) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "insert into manager(managerID, managerName, storeID, userName, passw)values(?,?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setInt(1, manager.managerID);
			pst.setString(2, manager.name);
			pst.setInt(3, manager.storeID);
			pst.setString(4, manager.username);
			pst.setString(5, manager.password);
			pst.executeUpdate();

			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void removeManager(Manager manager) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "DELETE FROM manager "
					+ "WHERE managerID = " + manager.managerID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			manager = null;
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void changeManagerStore(Manager manager, int storeID) {
		manager.storeID = storeID;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE manager "
					+ "SET storeID = '" + storeID
					+ "' WHERE managerID = '" + manager.managerID + "'";
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void addProduct(Product product, Store store) {
		product.storeID = store.storeID;
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
			pst.setInt(10, store.storeID);
			pst.executeUpdate();

			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void removeProduct(Product product, Store store) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "DELETE FROM inventory "
					+ " WHERE productID = "+ product.getProductID()
					+ " AND storeID = " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			product = null;
			Con.close();
			
		} catch (Exception exc) {
		}
	}
	
	public void addSaleItem(Product product, Store store) {
		product.discountStatus = "YES";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ " SET discountStatus = 'YES'"
					+ " WHERE productID = " + product.getProductID()
					+ " AND storeID = " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void removeSaleItem(Product product, Store store) {
		product.discountStatus = "NO";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET discountStatus = 'NO'"
					+ " WHERE productID = " + product.getProductID()
					+ " AND storeID = " + store.storeID;;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}
	
	public void setItemPrice(Product product, float price, Store store) {
		if (price > 0f) {
			product.price = price;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ "SET price = " + price 
						+ " WHERE productID = " + product.getProductID()
						+ " AND storeID = " + store.storeID;
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}
		
	}
	
	public void setItemName(Product product, String string, Store store) {
		product.productName = string;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET productName = '" + string 
					+ "' WHERE productID = " + product.getProductID()
					+ " AND storeID = " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void setItemCategory(Product product, String string, Store store) {
		product.category = string;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE inventory "
					+ "SET category = '" + string 
					+ "' WHERE productID = " + product.getProductID()
					+ " AND storeID = " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void setItemQuantity(Product product, int quantity, Store store) {
		if (quantity > 0) {
			product.quantity = quantity;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ " SET quantity = " + quantity 
						+ " WHERE productID = " + product.getProductID()
						+ " AND storeID = " + store.storeID;
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}
		
	}
	
	public void setItemDiscRate(Product product, float rate, Store store) {
		if (rate > 0f) {
			product.discountRate = rate;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
				
				String query = "UPDATE inventory "
						+ "SET discountRate = " + rate
						+ " WHERE productID = " + product.getProductID()
						+ " AND storeID = " + store.storeID;
				PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
				pst.executeUpdate();
				
				Con.close();
			} catch (Exception exc) {
			}
		}
	}

	public void setOpenTime(String openTime, Store store) {
		store.openTime = openTime;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE storeList" + 
					" SET openTime='" + openTime +
					"' WHERE storeID= " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}
	
	public void setCloseTime(String closeTime, Store store) {
		store.closeTime = closeTime;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE storeList" + 
					" SET closeTime='" + closeTime +
					"' WHERE storeID= " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public void addStore(Store store) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			String query = "INSERT INTO storeList(storeID, storeName, storeLocation, openTime, closeTime) VALUES(?,?,?,?,?)";

			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.setInt(1, store.storeID);
			pst.setString(2, store.storeName);
			pst.setString(3, store.storeLocation);
			pst.setString(4, store.openTime);
			pst.setString(5, store.closeTime);
			pst.executeUpdate();

			Con.close();
		} catch (Exception exc) {
		}
	}

	public void removeStore(Store store) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "DELETE FROM storeList "
					+ "WHERE storeID = " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();
			
			Con.close();
		} catch (Exception exc) {
		}
	}

	public void setStoreName(Store store, String storeName) {
		store.storeName = storeName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE storeList" + 
					" SET storeName='" + storeName +
					"' WHERE storeID= " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
	}

	public void setStoreLocation(String storeLocation, Store store) {
		store.storeLocation = storeLocation;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "UPDATE storeList" + 
					" SET storeLocation='" + storeLocation +
					"' WHERE storeID= " + store.storeID;
			PreparedStatement pst = (PreparedStatement) Con.prepareStatement(query);
			pst.executeUpdate();

			Con.close();
			
		} catch (Exception ex) {
		}
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

	public List<String> searchItemsByName(String string, Store store) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE productName=" + string
					+ " AND storeID= " + store.storeID;
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
	
	public List<String> searchItemsByCategory(String string, Store store) {
		List<String> result = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegistrationInfo","root", "tenlalong");
			
			String query = "SELECT * FROM inventory"
					+ " WHERE category='" + string
					+ "' AND storeID= " + store.storeID;
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
