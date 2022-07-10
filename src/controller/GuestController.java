package controller;

import view.GuestView;
import vo.Branch;

public class GuestController {
	private GuestView gv;
	private Branch[] restaurant;
	
	public GuestController(Branch[] restaurant) {
		gv = new GuestView();
		this.restaurant = restaurant;
	}

	public Branch[] main() {
		while(true) {
			int sel = gv.showMenu();
			
			switch(sel) {
			case 1:
				int searchIndex = branchSelect();
				if(searchIndex != -1) {
					ReservationController rc = new ReservationController(restaurant[searchIndex]);
					restaurant[searchIndex] = rc.main();
				}
				break;
			case 0:
				return restaurant;
			}
		}
	}
	
	public int branchSelect() {
		String searchName = gv.inputName("메뉴 관리");
		int searchIndex = searchBranch(searchName);
		
		if(searchIndex == -1) {
			gv.noBranch();
			return -1;
		} else {
			return searchIndex;
		}
	}
	
	public int searchBranch(String searchName) {
		for(int i=0; restaurant[i] != null; i++) {
			if(searchName.equals(restaurant[i].getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
