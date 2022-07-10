package vo;

public class Seat {
	// 전역 변수
	private boolean[] seat;		// false : 빈 자리, true = 예약한 자리
	// idArray의 각 인덱스가 ID입니다.
	// idArray의 각 인덱스에는 예약한 자리 번호가 저장됩니다.
	// 손님이 받는 ID는 idArray 인덱스+1입니다.
	private int[] idArray;		// 각 ID에 예약한 자리 번호를 저장
	private int lastId;			// 값이 입력된 마지막 ID
	
	// 생성자
	public Seat() {
		seat = new boolean[6];	// 자리 6개 만들기
		idArray = new int[6];	// ID 6개 만들기
		for(int i=0; i<idArray.length; i++) {
			idArray[i] = -1;	// 각 ID 초기값으로 -1 대입, 아무 자리도 예약 하지 않았다는 뜻
		}
		lastId = -1;		// 자리 번호를 저장하고 있는 ID가 없다는 의미에서 -1로 초기화
	}
	
	// getter
	public boolean[] getSeat() {	// seat 반환, 남은 자리 확인할 때 필요
		return seat;
	}
	public int[] getIDArray() {		// idArray 반홥, ID 검색 시 필요
		return idArray;
	}
	public int getLastID() {		// 새로 예약하여 발급된 ID 반환
		return lastId;
	}

	// 자리 예약 관련 메소드
	public boolean isSeat(int seatIndex) {		// 해당 자리 예약 여부 확인
		return seat[seatIndex];		// 해당 자리(seatIndex)가 비어 있으면 false, 예약한 사람이 있으면 true 반환
	}
	public void reservation(int seatIndex) {	// 해당 자리 예약 하기
		seat[seatIndex] = true;		// 해당 자리(seatIndex)를 예약 상태로 바꾸기
	}
	public void cancel(int seatIndex) {			// 해당 자리 예약 취소 하기
		seat[seatIndex] = false;	// 해당 자리(seatIndex)를 빈 자리 상태로 바꾸기
	}
	
	// ID 관련 메소드
	public void addId(int seatIndex) {		// ID 추가하기
		idArray[++lastId] = seatIndex;		// 추가한 ID에 예약한 자리 번호(seatIndex)를 저장
	}
	public void deleteId(int id) {			// ID 삭제하기
		idArray[id] = -1;		// 해당 ID에는 저장된 자리 번호가 사라지게 되었다는 의미에서 -1 대입
		lastId--;				// ID를 삭제했으니 자리 번호를 저장하고 있는 ID수가 하나 줄어듬.
	}
	public int getSeatIndex(int id) {		// 해당 ID의 예약 자리 번호 반환
		return idArray[id];
	}
}
