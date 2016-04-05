package edu.neu.cloudaddy.model;

public class Products {
private String supplier_ids;
private int id;
private String product_code;
private String product_name;
private String description;
private double standard_cost;
private double list_price;
private int reorder_level;
private int target_level;
private String quantity_per_unit;
private int discontinued;
private int minimum_reorder_quantity;
private String category;
private String attachments;
public String getSupplier_ids() {
	return supplier_ids;
}
public void setSupplier_ids(String supplier_ids) {
	this.supplier_ids = supplier_ids;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct_code() {
	return product_code;
}
public void setProduct_code(String product_code) {
	this.product_code = product_code;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getStandard_cost() {
	return standard_cost;
}
public void setStandard_cost(double standard_cost) {
	this.standard_cost = standard_cost;
}
public double getList_price() {
	return list_price;
}
public void setList_price(double list_price) {
	this.list_price = list_price;
}
public int getReorder_level() {
	return reorder_level;
}
public void setReorder_level(int reorder_level) {
	this.reorder_level = reorder_level;
}
public int getTarget_level() {
	return target_level;
}
public void setTarget_level(int target_level) {
	this.target_level = target_level;
}
public String getQuantity_per_unit() {
	return quantity_per_unit;
}
public void setQuantity_per_unit(String quantity_per_unit) {
	this.quantity_per_unit = quantity_per_unit;
}
public int getDiscontinued() {
	return discontinued;
}
public void setDiscontinued(int discontinued) {
	this.discontinued = discontinued;
}
public int getMinimum_reorder_quantity() {
	return minimum_reorder_quantity;
}
public void setMinimum_reorder_quantity(int minimum_reorder_quantity) {
	this.minimum_reorder_quantity = minimum_reorder_quantity;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getAttachments() {
	return attachments;
}
public void setAttachments(String attachments) {
	this.attachments = attachments;
}

	
}
