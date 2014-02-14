package BEAN;

public class Item {
	private Integer quantity;
	private float price;
	private Integer oid;
	private Product product;
	public Item(Product product, Integer quantity){
		this.product = product;
		this.quantity = quantity;
		this.price = product.getPrice()*quantity;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		this.price = this.quantity*this.product.getPrice();
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
