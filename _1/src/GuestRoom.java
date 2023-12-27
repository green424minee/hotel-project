
public class GuestRoom {
	private static Room[] rooms;

	public static void guestRoom() {
		int totalRooms = 4 * 20; // 총 방의 수
		rooms = new Room[totalRooms];

		int index = 0; // 배열의 인덱스

		for (int i = 2; i <= 5; i++) {
			for (int j = 1; j <= 20; j++) {
				rooms[index++] = new Room(i * 100 + j);
			}
		}
	}

	public static Room[] getRooms() {
		return rooms;
	}

	public static boolean isPrime(int number) {
	    if (number < 2) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(number); i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void setRooms(Room[] rooms) {
		GuestRoom.rooms = rooms;
	}

	public static void showAllRooms() {
		System.out.println("-------------------숙박 가격-----------------");
		System.out.println("싱글룸(S):80,000원   더블룸(D):100,000원  ");
		System.out.println("스위트룸(*):500,000원   디럭스(/):150,000");
		System.out.println("----------------멤버쉽 등급별 할인율-------------");
		System.out.println("플래티넘 할인율:30%   골드할인율:20%");
		System.out.println();
		System.out.println("All Room Numbers:");
		for (int i = 0; i < 20; i++) {
			if (rooms[i].getRoomNumber() % 2 == 0) {
				System.out.print(rooms[i].getRoomNumber() + "D ");
			} else {
				System.out.print(rooms[i].getRoomNumber() + "S ");
			}
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(" " + rooms[i].getState() + "   ");
		}
		System.out.println();
		for (int i = 20; i < 40; i++) {
			if (rooms[i].getRoomNumber() % 2 == 0) {
				System.out.print(rooms[i].getRoomNumber() + "D ");
			} else {
				System.out.print(rooms[i].getRoomNumber() + "S ");
			}
		}
		System.out.println();
		for (int i = 20; i < 40; i++) {
			System.out.print(" " + rooms[i].getState() + "   ");
		}
		System.out.println();
		for (int i = 40; i < 60; i++) {
			if (rooms[i].getRoomNumber() % 2 == 0) {
				System.out.print(rooms[i].getRoomNumber() + "D ");
			} else {
				System.out.print(rooms[i].getRoomNumber() + "S ");
			}
		}
		System.out.println();
		for (int i = 40; i < 60; i++) {
			System.out.print(" " + rooms[i].getState() + "   ");
		}
		System.out.println();
		for (int i = 60; i < 80; i++) {
			if(isPrime(rooms[i].getRoomNumber())){
				System.out.print(rooms[i].getRoomNumber()+"* ");
			}else if (rooms[i].getRoomNumber() % 2 == 0) {
				System.out.print(rooms[i].getRoomNumber() + "/ ");
			}
			else {
			System.out.print(rooms[i].getRoomNumber() + "S ");
			}
		}
		System.out.println();
		for (int i = 60; i < 80; i++) {
			System.out.print(" " + rooms[i].getState() + "   ");
		}
		System.out.println();
		System.out.println();
		System.out.println("상태0:빈방 ,상태1:예약된방 ,상태2:워크인 ,상태3:체크인 ,상태4:체크아웃 ,상태5:수리 및 점검필요");
		System.out.println("상태35: 투숙중인방 수리 및 점검   상태45:체크아웃방 수리및 점검");
		System.out.println();

	}

	public static int checkRoomState(String name, String phoneNumber) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getCustomerInformation() != null
					&& rooms[i].getCustomerInformation().getCustomername().equals(name)
					&& rooms[i].getCustomerInformation().getPhoneNumber().equals(phoneNumber)) {
				return rooms[i].getState();
			}
		}
		return -1;
	}

	public static int checkRoomNumber(String name, String phoneNumber) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null && rooms[i].getCustomerInformation() != null
					&& rooms[i].getCustomerInformation().getCustomername().equals(name)
					&& rooms[i].getCustomerInformation().getPhoneNumber().equals(phoneNumber)) {
				return rooms[i].getRoomNumber();
			}
		}
		return -1;
	}

	public static void showCleanerRooms() {
		System.out.println("All Room Numbers:");
		for (int i = 0; i < 20; i++) {
			System.out.print(rooms[i].getRoomNumber() + " ");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(" " + rooms[i].getState() + "  ");
		}
		System.out.println();
		for (int i = 20; i < 40; i++) {
			System.out.print(rooms[i].getRoomNumber() + " ");
		}
		System.out.println();
		for (int i = 20; i < 40; i++) {
			System.out.print(" " + rooms[i].getState() + "  ");
		}
		System.out.println();
		for (int i = 40; i < 60; i++) {
			System.out.print(rooms[i].getRoomNumber() + " ");
		}
		System.out.println();
		for (int i = 40; i < 60; i++) {
			System.out.print(" " + rooms[i].getState() + "  ");
		}
		System.out.println();
		for (int i = 60; i < 80; i++) {
			System.out.print(rooms[i].getRoomNumber() + " ");
		}
		System.out.println();
		for (int i = 60; i < 80; i++) {
			System.out.print(" " + rooms[i].getState() + "  ");

		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("0.청소가 끝난방 4.청소해야할방");
	}

}
