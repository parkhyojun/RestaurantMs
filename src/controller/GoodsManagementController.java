package controller;

import view.GoodsManagementView;
import vo.Goods;

public class GoodsManagementController {
	private GoodsManagementView gmv;
	private Goods[] goods;
	private int goodsIndex;
	
	public GoodsManagementController(Goods[] goods) {
		gmv = new GoodsManagementView();
		this.goods = goods;
		while(goods[goodsIndex] != null) {
			goodsIndex++;
		}
	}
	
	public Goods[] main() {
		while(true) {
			int sel = gmv.showMenu();
			
			System.out.println();
			switch(sel) {
			case 1:
				addMenu();
				break;
			case 2:
				updateMenu();
				break;
			case 3:
				deleteMenu();
				break;
			case 4:
				showAllMenu();
				break;
			case 0 :
				return goods;
			}
		}
	}
	
	public void addMenu() {
		goods[goodsIndex++] = gmv.inputMenu();
		gmv.success("메뉴 추가");
	}
	public void updateMenu() {
		String searchName = gmv.inputName("수정");
		int searchIndex = searchMenu(searchName);
		
		if(searchIndex == -1) {
			gmv.noMenu();
			return;
		} else {
			goods[searchIndex] = gmv.inputMenu();
		}
		gmv.success("메뉴 수정");
	}
	public void deleteMenu() {
		String searchName = gmv.inputName("삭제");
		int searchIndex = searchMenu(searchName);
		
		if(searchIndex == -1) {
			gmv.noMenu();
			return;
		} else {
			for(int i=searchIndex; i<goodsIndex-1; i++) {
				goods[i] = goods[i+1];
			}
			goodsIndex--;
		}
		gmv.success("메뉴 삭제");
	}
	public void showAllMenu() {
		gmv.showAllMenu(goods, goodsIndex);
	}
	
	public int searchMenu(String searchName) {
		for(int i=0; i<goodsIndex; i++) {
			if(searchName.equals(goods[i].getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
