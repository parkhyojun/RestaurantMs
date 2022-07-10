package view;

import java.util.Scanner;

public class GuestView {
	private Scanner sc;	
	
	public GuestView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println("\n손님 메뉴");
		System.out.println("1. 지점 선택하기");
		System.out.println("0. 처음 화면으로");
		System.out.print("선택 > ");
		int select = sc.nextInt();		
		return select;
	}
	
	public void noBranch() {
		System.out.println("지점을 찾지 못했습니다.");
	}
	
	public String inputName(String str) {
		System.out.print(str + " 할 지점 이름을 입력하세요[서울점/인천점/부산점] > ");
		String searchName = sc.next();
		
		return searchName;
	}
}
