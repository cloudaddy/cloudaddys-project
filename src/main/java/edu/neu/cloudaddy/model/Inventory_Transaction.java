package edu.neu.cloudaddy.model;

public class Inventory_Transaction {
	private int id;
	private String transaction_type;
	private String transaction_created_date;
	private String transaction_modified_date;
	private int product_id;
	private int quantity;
	private int purchase_order_id;
	private int customer_order_id;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getTransaction_created_date() {
		return transaction_created_date;
	}
	public void setTransaction_created_date(String transaction_created_date) {
		this.transaction_created_date = transaction_created_date;
	}
	public String getTransaction_modified_date() {
		return transaction_modified_date;
	}
	public void setTransaction_modified_date(String transaction_modified_date) {
		this.transaction_modified_date = transaction_modified_date;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPurchase_order_id() {
		return purchase_order_id;
	}
	public void setPurchase_order_id(int purchase_order_id) {
		this.purchase_order_id = purchase_order_id;
	}
	public int getCustomer_order_id() {
		return customer_order_id;
	}
	public void setCustomer_order_id(int customer_order_id) {
		this.customer_order_id = customer_order_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
