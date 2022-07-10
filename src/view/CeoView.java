package view;

import java.util.Scanner;

import vo.Branch;

public class CeoView {
	private Scanner sc;	
	boolean branchTime;
	
	public CeoView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println("\n사장 메뉴");
		System.out.println("1. 지점 추가");
		System.out.println("2. 지점 수정");
		System.out.println("3. 지점 삭제");
		System.out.println("4. 지점 목록 보기");
		System.out.println("5. 지점별 메뉴 관리");
		System.out.println("0. 처음 화면으로");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		
		return sel;
	}
	
	public Branch inputBrachInfo() {
		System.out.print("지점 이름을 입력하세요[서울점/인천점/부산점] > ");
		String name = sc.next();
		System.out.print("지점 이용 시간을 입력하세요[런치/디너] : ");
		String time = sc.next();
		
		
		if(time.equals("런치")) {
			branchTime = true;
		} else {
			branchTime = false;
		}
		
		return new Branch(name, branchTime);
	}
	
	public void success(String str) {
		System.out.println(str + " 완료");
	}
	public void noBranch() {
		System.out.println("지점을 찾지 못했습니다.");
	}
	
	public String inputName(String str) {
		System.out.print(str + " 할 지점 이름을 입력하세요[서울점/인천점/부산점] > ");
		String searchName = sc.next();
		
		return searchName;
	}
	
	public void showAllBranch(Branch[] restaurant, int branchIndex) {
		System.out.println("지점 이름\t지점 운영 시간");
		for(int i=0; i<branchIndex; i++) {
			System.out.printf("%s\t%s\n", 
					restaurant[i].getName(), restaurant[i].getTime());
		}
	}
}
