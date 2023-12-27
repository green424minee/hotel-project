
public class DefaultShow {

	public void ManagerMainMenu() {
		System.out.println("1.객실정보");
		System.out.println("2.고객명/전화번호로 작업");
		System.out.println("3.멤버십 가입");
		System.out.println("4.멤버십 현황");
		System.out.println("5.로그아웃");
	}

	public void Manager1Menu() {
		System.out.println("1. 예약 및 취소");
		System.out.println("2. 방상태 및 고객정보");
		System.out.println("3. 체크인/체크아웃");
		System.out.println("4. 워크인");
		System.out.println("5. 수리,점검필요");
		System.out.println("6. 수리,점검완료");
		System.out.println("7. 방 이동");
		System.out.println("8. 뒤로가기");
	}

	public void CleanerMenu() {
		System.out.println("1. 청소가 필요한 객실 목록");
		System.out.println("2. 청소 확인");
		System.out.println("3. 로그아웃");
	}
	
	public void ManagerMenu() {
		System.out.println("1. 일매출확인");
		System.out.println("2. 멤버쉽 명단");
		System.out.println("3. 로그아웃");
	}

}
