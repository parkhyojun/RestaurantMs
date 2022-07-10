package vo;

public class Branch {
	private String name;	// 지점 이름
	private boolean time;	// 지점 운영 시간
	
	private Seat seat;		// 지점 자리
	private Goods[] goods;	// 지점 음식
	
	public Branch(String name, boolean time) {
		this.name = name;
		this.time = time;
		seat = new Seat();
		goods = new Goods[20];
	}
	
	public String getName() {
		return name;
	}
	public Goods[] getGoods() {
		return goods;
	}
	public String getTime() {
		if(time == true) {
			return "런치";
		} else {
			return "디너";
		}
	}
	public Seat getSeat( ) {
		return seat;
	}
	
	public void setGoods(Goods[] goods) {
		this.goods = goods;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
