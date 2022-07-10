package controller;

import view.ReservationView;
import vo.Branch;

public class ReservationController {
	private ReservationView rv;
	private Branch branch;
	
	public ReservationController(Branch branch) {
		rv = new ReservationView();
		this.branch = branch;
	}
	
	public Branch main() {
		while(true) {
			int sel = rv.showMenu();		// 자리 예약 메뉴 보여주고 선택 받기
			
			switch(sel) {
			case 1:
				seatReservation();			// 자리 예약하기
				break;
			case 2:
				seatCheck();				// 자리 예약 확인하기
				break;
			case 3:
				seatCancel();				// 자리 예약 취소하기
				break;
			case 4:
				seatCheckAll();				// 남은 자리 확인하기
				break;
			case 0:
				return branch;
			}
		}
	}
	
	public void seatReservation() {			// 자리 예약하기
		int peopleNum = rv.inputPeopleNum();		// 자리 예약할 사람 수 입력 받기
		if(peopleNum >= 6-branch.getSeat().getLastID()) {		// 자리가 부족할 경우
			rv.overPeopleNum();	// 자리가 부족하다는 메세지 출력
			return;					// 다시 메뉴로 돌아가기
		}
		
		for(int i=0; i<peopleNum; i++) {	// 자리 예약할 사람 수 만큼 반복
			int seatIndex = rv.seatReservation(i);	// 자리 예약하기
			
			if(branch.getSeat().isSeat(seatIndex-1)) {		// 이미 예약된 자리인 경우
				rv.noReservation();	// 예약할 수 없다는 메시지 출력
				i--;					// i번째 손님이 다시 예약할 수 있도록 i 값 감소 시킴
				continue;				// i번째 손님 다시 예약하기
			}
			
			String goodsName = rv.goodsSelect(branch.getGoods());
			int goodsIndex = searchGoods(goodsName);
			
			if(goodsIndex == -1) {
				rv.noGoods();
				return;
			} else {
				int count = rv.inputCount();
				
				if(branch.getGoods()[goodsIndex].getCount() - count < 0) {
					rv.lackGoods();
					return;
				} else {
					branch.getGoods()[goodsIndex].purchase(count);
				}
			}
			
			branch.getSeat().reservation(seatIndex-1);						// 자리 예약하기
			branch.getSeat().addId(seatIndex-1);							// 해당 ID에 예약한 자리 번호 저장하기
			rv.showIdSeat(branch.getSeat().getLastID()+1, seatIndex);		// ID, 예약한 자리 보여주기 
		}
	}
	public void seatCheck() {			// 자리 예약 확인하기
		int id = rv.searchId(branch.getSeat().getIDArray());				// ID 입력 받기
		
		if(id == -1) {		// 해당 ID가 없을 경우
			rv.noId();	// 해당 ID가 존재하지 않는다는 메시지 출력
			return;			// 메뉴로 돌아감.
		} else {			// 해당 ID가 있을 경우
			rv.showIdSeat(id, branch.getSeat().getSeatIndex(id-1)+1);		// 예약한 자리, ID 보여주기 
		}
	}
	public void seatCancel() {			// 자리 예약 취소하기
		int id = rv.searchId(branch.getSeat().getIDArray());				// ID 입력 받기
		
		if(id == -1) {		// 해당 ID가 없을 경우
			rv.noId();	// 해당 ID가 존재하지 않는다는 메시지 출력
			return;			// 메뉴로 돌아감.
		} else {			// 해당 ID가 있을 경우
			branch.getSeat().cancel(branch.getSeat().getSeatIndex(id-1));	// 자리 예약 취소하기
			branch.getSeat().deleteId(id-1);					// ID 삭제하기
		}
		rv.showReservationCancel();	// 예약 취소 완료 메시지 출력
	}
	public void seatCheckAll() {		// 남은 자리 확인하기
		rv.seatCheckAll(branch.getSeat());
	}
	
	public int searchGoods(String goodsName) {
		for(int i=0; branch.getGoods()[i] != null; i++) {
			if(goodsName.equals(branch.getGoods()[i].getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
