package dto;

public class Order1Detail {
	private String order_date;
	private int cust_code;
	private int item_code;
	private String item_order_desc;
	private String cancel;

	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getCust_code() {
		return cust_code;
	}
	public void setCust_code(int cust_code) {
		this.cust_code = cust_code;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_order_desc() {
		return item_order_desc;
	}
	public void setItem_order_desc(String item_order_desc) {
		this.item_order_desc = item_order_desc;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
}
