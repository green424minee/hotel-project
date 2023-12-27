import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Acting {
	private Room[] rooms;
	private MembershipNPS[] memberships;
	private Money m;

	public Acting() {
		this.rooms = GuestRoom.getRooms();
		this.memberships = Membership.getMemberships();

	}

	public Acting(Money money) {
		this.rooms = GuestRoom.getRooms();
		this.memberships = Membership.getMemberships();
		this.m = money;
	}

	Scanner sc = new Scanner(System.in);

// 방 예약과 예약취소
	public void reservation(String customerName, String customerPhoneNumber, int roomNum) {
		boolean roomFound = false;

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				roomFound = true;
				if (rooms[i].getCustomerInformation() == null && rooms[i].getState() == 0) {
					rooms[i].setCustomerInformation(new CustomerInformation(customerName, customerPhoneNumber));
					rooms[i].setState(1);
					boolean foundMembership = false;
					for (int j = 0; j < memberships.length; j++) {
						if (memberships[j] != null && memberships[j].getMembershipName().equals(customerName)
								&& memberships[j].getMembershipPhoneNum().equals(customerPhoneNumber)) {

							foundMembership = true;

							System.out.print(customerName + "님은 ");
							if (memberships[j].getGrade() == 1) {
								System.out.println("골드 회원입니다.(10%할인)");
							} else if (memberships[j].getGrade() == 2) {
								System.out.println("플래티넘 회원입니다.(20%할인)");
							} else {
								System.out.println("잘못된 입력값입니다.");

							}
						}
					}
					if (!foundMembership) {
						System.out.println("멤버십 회원이 아닙니다.");
					}

					System.out.println("금액입력");
					int plusMoney = sc.nextInt();
					m.setMoney(m.getMoney() + plusMoney);
					System.out.println("예약이 완료되었습니다.");
				} else if (rooms[i].getState() == 1) {
					System.out.println("이미 예약된 방입니다.");
				} else if (rooms[i].getState() == 2) {
					System.out.println("워크인중인 방입니다.");
				} else if (rooms[i].getState() == 4) {
					System.out.println("청소중인 방입니다.");
				} else if (rooms[i].getState() == 5) {
					System.out.println("수리중인 방입니다.");

				}
				break;
			}
		}
		if (!roomFound) {
			System.out.println("잘못된 방 번호입니다. 다시 입력해주세요.");
		}

	}

	public void checkRoomState(int roomNum) {
		boolean roomFound = false; // 방을 찾았는지 여부를 나타내는 플래그

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				roomFound = true;
				if (rooms[i].getState() == 4 || rooms[i].getState() == 45) {
					System.out.println("체크아웃되어 정보가없는방입니다.");
				} else if (rooms[i].getCustomerInformation() != null) {
					System.out.println("고객명 :" + rooms[i].getCustomerInformation().getCustomername());
					System.out.println("전화번호 :" + rooms[i].getCustomerInformation().getPhoneNumber());
				} else {
					System.out.println("빈방입니다.");
				}
				break; // 방을 찾았으면 반복문 종료
			}
		}

		if (!roomFound) {
			System.out.println("해당 방 번호를 찾을 수 없습니다.");
		}
	}

	public void checkIn(int roomNum) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				if (rooms[i].getState() == 1) {
					rooms[i].setState(3);
					System.out.println("체크인 되었습니다.");
				} else if (rooms[i].getState() == 2) {
					rooms[i].setState(3);
					System.out.println("고객명:");
					String customerName = sc.nextLine();
					System.out.println("전화번호:");
					String customerPhoneNumber = sc.nextLine();
					walkInreservation(customerName, customerPhoneNumber, roomNum);

					System.out.println("체크인 되었습니다.");
				} else if (rooms[i].getState() == 3) {
					rooms[i].setState(4);
					rooms[i].setCustomerInformation(new CustomerInformation());
					System.out.println("체크아웃 되었습니다.");

				} else if (rooms[i].getState() == 35) {
					rooms[i].setState(45);
					rooms[i].setCustomerInformation(new CustomerInformation());
					System.out.println("체크아웃 되었습니다.");

				} else {
					System.out.println("예약되지 않은 방입니다.");
				}

			}
		}
	}

	public void transfer(int originRoomNum, int transferRoomNum) {
		boolean originRoomFound = false;
		boolean transferRoomFound = false;

		for (int i = 0; i < rooms.length; i++) {
			// 0,5,1,15,2,25,3,35,4,45

			// 빈방일때 워크인일때,체크아웃 안됨 0.5.2.25.4.45
			if (rooms[i].getRoomNumber() == originRoomNum && (rooms[i].getState() == 1 || rooms[i].getState() == 15
					|| rooms[i].getState() == 3 || rooms[i].getState() == 35)) {
				originRoomFound = true;
				for (int j = 0; j < rooms.length; j++) {
					if (rooms[j].getRoomNumber() == transferRoomNum && rooms[j].getState() == 0) {
						transferRoomFound = true;
						// 예약중일때 됨, 체크인상태에서 됨, 1.15.3.35.
						rooms[j].setCustomerInformation(rooms[i].getCustomerInformation());
						rooms[i].setCustomerInformation(null);
						if (rooms[i].getState() == 1 || rooms[i].getState() == 3) {
							rooms[j].setState(rooms[i].getState());
							rooms[i].setState(0);
						} else if (rooms[i].getState() == 15 || rooms[i].getState() == 35) {
							rooms[j].setState(rooms[i].getState() / 10);
							rooms[i].setState(5);

						}

						System.out.println("이동이 완료되었습니다.");
						break;
					}
				}
				break;
			}
		}

		if (!originRoomFound) {
			System.out.println("잘못된 출발 방 번호입니다. 다시 입력해주세요.");
		} else if (!transferRoomFound) {
			System.out.println("잘못된 이동 방 번호입니다. 다시 입력해주세요.");
		}
	}

	public void walkInreservation(String customerName, String customerPhoneNumber, int roomNum) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				if (rooms[i].getCustomerInformation() == null) {
					rooms[i].setCustomerInformation(new CustomerInformation(customerName, customerPhoneNumber));
				}
				rooms[i].setCustomerInformation(customerName, customerPhoneNumber);
				rooms[i].setState(3);

			}
		}
	}

	public void unreservation(String customerName, String customerPhoneNumber) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getCustomerInformation() != null
					&& rooms[i].getCustomerInformation().getCustomername().equals(customerName)
					&& rooms[i].getCustomerInformation().getPhoneNumber().equals(customerPhoneNumber)) {
				rooms[i].setCustomerInformation(new CustomerInformation());
				rooms[i].setState(0);
			}

		}
		System.out.println("환불할 금액");
		int minusMoney = sc.nextInt();
		sc.nextLine();
		m.setMoney(m.getMoney() - minusMoney);
	}

	public void PartialUnreservation(String customerName, String customerPhoneNumber, int roomNumber) {
		boolean noFind = false;
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getCustomerInformation() != null
					&& rooms[i].getCustomerInformation().getCustomername().equals(customerName)
					&& rooms[i].getCustomerInformation().getPhoneNumber().equals(customerPhoneNumber)
					&& rooms[i].getRoomNumber() == roomNumber) {
				noFind = true;
				rooms[i].setCustomerInformation(new CustomerInformation());
				System.out.println("환불할 금액");
				int minusMoney = sc.nextInt();
				sc.nextLine();
				m.setMoney(m.getMoney() - minusMoney);
				rooms[i].setState(0);
				System.out.println("부분 환불 완료");
			}

		}
		if (noFind == false) {
			System.out.println("방번호를 잘못 입력했습니다.");
		}
	}

	public void walkIn(int roomNum) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				if (rooms[i].getState() == 0) {
					rooms[i].setState(2);
					System.out.println("워크인 되었습니다.");
				} else {
					System.out.println("워크인 할수 없는 방입니다.");
				}

			}
		}
	}

	public void inspection(int roomNum) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 35) {
				rooms[i].setState(35);
				System.out.println("중복입력 불가");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 45) {
				rooms[i].setState(45);
				System.out.println("중복입력 불가");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 15) {
				rooms[i].setState(15);
				System.out.println("중복입력 불가");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 25) {
				rooms[i].setState(25);
				System.out.println("중복입력 불가");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 1) {
				rooms[i].setState(15);
				System.out.println("수리,점검필요 방으로 변경완료.");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 4) {
				rooms[i].setState(45);
				System.out.println("수리,점검필요 방으로 변경완료.");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 2) {
				rooms[i].setState(25);
				System.out.println("수리,점검필요 방으로 변경완료.");
			} else if (rooms[i].getRoomNumber() == roomNum && rooms[i].getState() == 3) {
				rooms[i].setState(35);
				System.out.println("수리,점검필요 방으로 변경완료.");
			} else if (rooms[i].getRoomNumber() == roomNum) {
				rooms[i].setState(5);
				System.out.println("수리,점검필요 방으로 변경완료.");
			}
		}
	}

	public void disInspection(int roomNum) {
		boolean validInput = false;

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				if (rooms[i].getState() == 35) {
					rooms[i].setState(3);
					System.out.println("수리 및 점검 완료");
					validInput = true;
					break;
				} else if (rooms[i].getState() == 45) {
					rooms[i].setState(4);
					System.out.println("수리 및 점검 완료");
					validInput = true;
					break;
				} else if (rooms[i].getState() == 15) {
					rooms[i].setState(1);
					System.out.println("수리 및 점검 완료");
					validInput = true;
					break;
				} else if (rooms[i].getState() == 25) {
					rooms[i].setState(2);
					System.out.println("수리 및 점검 완료");
					validInput = true;
					break;
				} else if (rooms[i].getState() == 5) {
					rooms[i].setState(0);
					System.out.println("수리 및 점검 완료");
					validInput = true;
					break;
				} else {
					System.out.println("잘못된 입력입니다.");
					validInput = true; // 이 경우에도 이미 처리된 것으로 간주하고 반복문 종료
					break;
				}
			}
		}

		if (!validInput) {
			System.out.println("입력된 방 번호에 해당하는 방이 없습니다.");
		}
	}

	public void cleanCheck(int roomNum) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getRoomNumber() == roomNum) {
				if (rooms[i].getState() == 4) {
					rooms[i].setState(0);
					System.out.println("청소 체크 확인 되었습니다.");
				}
			}
		}
	}

	public List<Integer> searchArrays(String customerName, String customerPhoneNumber) {
		List<Integer> indices = new ArrayList<>();

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].getCustomerInformation() != null
					&& rooms[i].getCustomerInformation().getCustomername().equals(customerName)
					&& rooms[i].getCustomerInformation().getPhoneNumber().equals(customerPhoneNumber)) {
				indices.add(i);
				rooms[i].getRoomNumber();
				if (rooms[i].getState() == 1) {
					System.out.println("예약하신 방은: " + rooms[i].getRoomNumber() + "호");
				} else if (rooms[i].getState() == 3) {
					System.out.println("투숙중인 방은: " + rooms[i].getRoomNumber() + "호");
				} else {

					System.out.println("일치하는 값이 없습니다.");
				}
			}
		}

		return indices;
	}

	public void joinMembership(String membershipName, String membershipPhoneNum, int grade) {
		boolean membershipFound = false;

		for (int i = 0; i < memberships.length; i++) {
			if (memberships[i] != null && memberships[i].getMembershipName().equals(membershipName)
					&& memberships[i].getMembershipPhoneNum().equals(membershipPhoneNum)) {
				// 이미 가입된 경우
				System.out.println("이미 가입된 멤버쉽입니다.");
				membershipFound = true;
				break;
			} else if (memberships[i] == null) {
				memberships[i] = new MembershipNPS(membershipName, membershipPhoneNum, grade);
				System.out.println("멤버쉽 가입이 완료되었습니다.");
				membershipFound = true;
				break;
			}
		}

		if (!membershipFound) {
			System.out.println("멤버쉽 가입 인원 초과");
		}
	}

	public void showAllMembership() {
		for (int i = 0; i < memberships.length; i++) {
			if (memberships[i] != null) {
				System.out.println((i + 1) + ". 성함 : " + memberships[i].getMembershipName());
				System.out.println("    연락처 : " + memberships[i].getMembershipPhoneNum());
				System.out.println("      등급 : " + memberships[i].getGrade());
			}
		}
	}
}
