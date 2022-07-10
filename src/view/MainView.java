package view;

import java.util.Scanner;

public class MainView {
	private Scanner sc;	
	
	public MainView() {
		sc = new Scanner(System.in);
	}

	public int showMenu() {
		System.out.println("\n레스토랑에 오신 것을 환영합니다.");
		System.out.println(" ────────1. 사장님──────");
		System.out.println(" ────────2. 손 님──────");
		System.out.println(" ────────0. 종 료──────");
		System.out.print("선택 : ");
		int sel = sc.nextInt();
		
		return sel;
	}
}
