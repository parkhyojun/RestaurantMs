package controller;

import view.CeoView;
import vo.Branch;

public class CeoController {
	private CeoView cv;
	private Branch[] restaurant;
	private int branchIndex;
	
	public CeoController(Branch[] restaurant) {
		cv = new CeoView();
		this.restaurant = restaurant;
		while(restaurant[branchIndex] != null) {	
			branchIndex++;
		}	
	}

	public Branch[] main() {
		while(true) {
			int sel = cv.showMenu();
			
			System.out.println();
			switch(sel) {
			case 1:
				addBranch();
				break;
			case 2:
				updateBranch();
				break;
			case 3:
				deleteBrach();
				break;
			case 4:
				showAllBranch();
				break;
			case 5:
				int searchIndex = branchSelect();
				if(searchIndex != -1) {	//음식컨트롤러에서 gmc객체를 생성해서 
					GoodsManagementController gmc = new GoodsManagementController(restaurant[searchIndex].getGoods());
					restaurant[searchIndex].setGoods(gmc.main());
				}
				break;
			case 0 :
				return restaurant;
			}
		}
	}
	
	public void addBranch() {
		restaurant[branchIndex++] = cv.inputBrachInfo();	//지점추가
		cv.success("지점 추가");
	}
	public void updateBranch() {
		String searchName = cv.inputName("수정");
		int searchIndex = searchBranch(searchName);
		
		if(searchIndex == -1) {
			cv.noBranch();
			return;
		} else {
			restaurant[searchIndex] = cv.inputBrachInfo();
		}
		cv.success("지점 수정");
	}
	public void deleteBrach() {
		String searchName = cv.inputName("삭제");
		int searchIndex = searchBranch(searchName);
		
		if(searchIndex == -1) {
			cv.noBranch();
			return;
		} else {
			for(int i=searchIndex; i<branchIndex-1; i++) {
				restaurant[i] = restaurant[i+1];
			}
			branchIndex--;
		}
		cv.success("지점 삭제");
	}
	public void showAllBranch() {
		cv.showAllBranch(restaurant, branchIndex);
	}
	
	public int branchSelect() {
		String searchName = cv.inputName("메뉴 관리");
		int searchIndex = searchBranch(searchName);
		
		if(searchIndex == -1) {
			cv.noBranch();
			return -1;
		} else {
			return searchIndex;
		}
	}
	
	public int searchBranch(String searchName) {
		for(int i=0; i<branchIndex; i++) {
			if(searchName.equals(restaurant[i].getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
