package BEAN;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, Item> items = new HashMap<Integer, Item>();
	private Float cost = 0f;
	
	//add an item
	public boolean addItem(Product product, int number){
		if(items.containsKey(product.getPid())){
			return false;
		}
		Item item = new Item(product, new Integer(number));
		items.put(product.getPid(), item);
		return true;
	}
	// modify item Number
	public void modifyNumberById(int pid, int quantity){
		Item item = items.get(pid);	
		item.setQuantity(quantity);
	}
	public void deleteItemByProductId(int pid){
		items.remove(pid);
	}
	public void deleteItemByProductId(int[] pids){
		for(int id : pids){
			items.remove(id);
		}
	}
	public void clear(){
		items.clear();
	}
	public Map<Integer, Item> getCartItems(){
		return items;
	}
	public int getItemNumber(){
		return items.size();
	}
	public boolean isEmpty(){
		return items.isEmpty();
	}
	public Float getPrice(){
		cost = 0f;
		for(int id : items.keySet()){
			Item item = items.get(id);
			cost += item.getPrice();
		}
		return cost;
	}
	public Map<Integer, Item> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Item> items) {
		this.items = items;
	}
	public Float getCost() {
		return (Float)this.getPrice();
	}
}
