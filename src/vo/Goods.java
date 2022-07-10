package vo;

public abstract class Goods {
	private String name;	// 이름
	private int count;		// 수량
	private int price;		// 가격
	
	public Goods() {
	}
	public Goods(String name, int price, int count) {
		super();
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract String getKind();
	
	public void purchase(int count) {
		this.count -= count;
	}
}
