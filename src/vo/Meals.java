package vo;

public class Meals extends Goods{
	public Meals() {
	}
	public Meals(String name, int count, int price) {
		super(name, count, price);
	}
	
	public String getKind() {
		return "식사류";
	}
}
