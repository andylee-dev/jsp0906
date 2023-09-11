package dto;

public class Order1 {
	private String order_date;
	private int cust_code;
	private String order_desc;
	private int sabun;
	private String order_status;

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
	public String getOrder_desc() {
		return order_desc;
	}
	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
}
