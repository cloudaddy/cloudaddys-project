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

	/*
	 * public static void main(String[] args) { StringBuffer buff = new
	 * StringBuffer(); int count =90; int order =30; for (int i = 1; i < 100;
	 * i++) {
	 * buff.append("Insert into inventory_transactions(`transaction_type`," +
	 * "`transaction_created_date`, `transaction_modified_date`," +
	 * "`product_id`, `quantity`, `purchase_order_id`, " +
	 * "`customer_order_id`, `comments`) values ("); buff.append(1 + (int)
	 * (Math.random() * ((4 - 1) + 1)) + ",'"); buff.append((new
	 * SimpleDateFormat
	 * ("yy-MM-dd HH:mm:ss")).format(ProductDaoImpl.getDate(i)));
	 * buff.append("', '"); buff.append((new
	 * SimpleDateFormat("yy-MM-dd HH:mm:ss"
	 * )).format(ProductDaoImpl.getDate(i))); buff.append("', "); buff.append(i
	 * + ", "); buff.append(i + ", "); if(count > 111) count = 89; if(order
	 * >81){ order =30; } buff.append(count++ + ", "); buff.append(order++ +
	 * ", \""); buff.append("NULL\");"); buff.append("\n");
	 * System.out.println(buff.toString());
	 * 
	 * }
	 * 
	 * }
	 */

}
