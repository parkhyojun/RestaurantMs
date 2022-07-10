package controller;

import view.MainView;
import vo.Branch;

public class MainController {
	private MainView mainView;
	private Branch[] restaurant;
	
	public MainController() {
		mainView = new MainView();
		restaurant = new Branch[4];
	}
	
	public void main() {
		while(true) {
			int sel = mainView.showMenu();
			
			switch(sel) {
			case 1:
				CeoController cc = new CeoController(restaurant);
				restaurant = cc.main();
				break;
			case 2:
				GuestController gc = new GuestController(restaurant);
				restaurant = gc.main();
				break;
			case 0:
				return;
			}
		}
	}
}
