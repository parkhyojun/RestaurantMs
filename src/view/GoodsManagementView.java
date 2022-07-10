package view;

import java.util.Scanner;

import vo.Drink;
import vo.Goods;
import vo.Meals;

public class GoodsManagementView {
	private Scanner sc;	
	
	public GoodsManagementView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println("\n메뉴 관리");
		System.out.println("1. 메뉴 추가하기");
		System.out.println("2. 메뉴 수정하기");
		System.out.println("3. 메뉴 삭제하기");
		System.out.println("4. 메뉴 목록보기");
		System.out.println("0. 이전 화면으로");
		System.out.print("선택 : ");
		int sel = sc.nextInt();
		
		return sel;
	}
	
	public Goods inputMenu() {
		System.out.print("식사류인가요, 주류인가요? : ");
		String kind = sc.next();
		System.out.print(kind + " 이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print(kind + " 가격을 입력하세요 : ");
		int price = sc.nextInt();
		System.out.print(kind + " 수량을 입력하세요 : ");
		int count = sc.nextInt();
		
		if(kind.equals("식사류")) {
			return new Meals(name, price, count);
		} else {
			return new Drink(name, price, count);
		}
	}
	
	public void success(String str) {
		System.out.println(str + " 완료");
	}
	public void noMenu() {
		System.out.println("해당 메뉴를 찾지 못했습니다.");
	}
	
	public String inputName(String str) {
		System.out.print(str + " 메뉴 이름을 입력하세요. : ");
		String searchName = sc.next();
		
		return searchName;
	}
	
	public void showAllMenu(Goods[] goods, int goodsIndex) {
		System.out.println("이름\t가격\t수량");
		for(int i=0; i<goodsIndex; i++) {
			System.out.printf("%s\t%d\t%d\n", 
					goods[i].getName(), goods[i].getPrice(), goods[i].getCount());
		}
	}
}
