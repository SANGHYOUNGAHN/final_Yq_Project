package final_Project_Vo;

public class MenuVO {
	
/*
 * date -> string ?
 * price -> int ? (for calculate)
 */
	private String mn_id;
	private String mn_date;
	private String mn_name;
	private int mn_price;
	private String chain;
	private String mn_type;
	private String mn_sold;
	
	public String getMn_sold() {
		return mn_sold;
	}
	public void setMn_sold(String mn_sold) {
		this.mn_sold = mn_sold;
	}
	public String getMn_id() {
		return mn_id;
	}
	public void setMn_id(String mn_id) {
		this.mn_id = mn_id;
	}
	public String getMn_date() {
		return mn_date;
	}
	public void setMn_date(String mn_date) {
		this.mn_date = mn_date;
	}
	public String getMn_name() {
		return mn_name;
	}
	public void setMn_name(String mn_name) {
		this.mn_name = mn_name;
	}
	
	public int getMn_price() {
		return mn_price;
	}
	public void setMn_price(int i) {
		this.mn_price = i;
	}
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	public String getMn_type() {
		return mn_type;
	}
	public void setMn_type(String mn_type) {
		this.mn_type = mn_type;
	}

	
}
