package main;

public class Product {
	
	public int productID;
	public String productName;
	public String description;
	public float price;
	public String dimen;
	public String category;
	public int quantity;
	public String discountStatus;
	public float discountRate;
	public int storeID;
	
	public Product(int productID, String productName, String description, float price, 
			String dimen, String category, int quantity, String discountStatus,
			float discountRate, int storeID) {
		this.setProductID(productID);
		this.setProductName(productName);
		this.setDescription(description);
		this.price = price;
		this.setDimen(dimen);
		this.setCategory(category);
		this.setQuantity(quantity);
		this.setDiscountStatus(discountStatus);
		this.setDiscountRate(discountRate);
		this.storeID = storeID;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}
	
	/* only manager or admin can change price
	public void setPrice(float price) {
		this.price = price;
	}
	*/
	public String getDimen() {
		return dimen;
	}

	public void setDimen(String dimen) {
		this.dimen = dimen;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDiscountStatus() {
		return discountStatus;
	}

	public void setDiscountStatus(String discountStatus) {
		this.discountStatus = discountStatus;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public int getStoreID() {
		return storeID;
	}

	/* only admin or manager can change the store ID
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	*/
}
