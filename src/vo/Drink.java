package vo;

public class Drink extends Goods {
	public Drink() {
	}
	public Drink(String name, int count, int price) {
		super(name, count, price);
	}
	
	public String getKind() {
		return "주류";
	}

}
