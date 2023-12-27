import java.util.Scanner;

public class HotelMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Login.Login();
		GuestRoom.guestRoom();
		DefaultShow show = new DefaultShow();
		Membership.Membership();
		Money m = new Money(0);
		Acting acting = new Acting(m);
		int exit = 0;
		do {

			System.out.println("로그인 하세요.");
			System.out.println("Id:");
			String id = sc.nextLine();
			System.out.println("Pw:");
			String pw = sc.nextLine();
			if (Login.containLogin(id, pw) == 1 && Login.findArrNum(id, pw) == 0) {
				System.out.println("반갑습니다." + id + "님");
				int exit1 = 0;
				do {
					show.ManagerMainMenu();
					int mainInput = sc.nextInt();
					sc.nextLine();
					switch (mainInput) {
					case 1:
						int exit2 = 0;
						do {
							GuestRoom.showAllRooms();
							show.Manager1Menu();
							int input1Menu = sc.nextInt();
							sc.nextLine();

							switch (input1Menu) {
							case 1:

								System.out.println("고객명:");
								String customerName = sc.nextLine();
								System.out.println("전화번호:");
								System.out.println("나가기:99");
								String customerPhoneNumber = sc.nextLine();
								if (customerPhoneNumber.equals("99")) {

								} else {
									if (GuestRoom.checkRoomNumber(customerName, customerPhoneNumber) == -1) {
										GuestRoom.showAllRooms();
										System.out.println("예약하고자 하는 방은?");
										int roomNum = sc.nextInt();
										sc.nextLine();
										acting.reservation(customerName, customerPhoneNumber, roomNum);

									} else {
										if (GuestRoom.checkRoomState(customerName, customerPhoneNumber) == 1) {
											acting.searchArrays(customerName, customerPhoneNumber);

											System.out.println("1.예약취소");
											System.out.println("2.돌아가기");
											System.out.println("3.다른방 예약하기");
											int a = sc.nextInt();
											if (a == 1) {
												System.out.println("1. 전체 취소");
												System.out.println("2. 부분취소");
												int unreinput = sc.nextInt();
												switch (unreinput) {
												case 1:

													acting.unreservation(customerName, customerPhoneNumber);
													System.out.println("전체 예약이 취소되었습니다.");
													break;
												case 2:
													System.out.println("취소하실 방번호입력");
													int unreinput2 = sc.nextInt();
													acting.PartialUnreservation(customerName, customerPhoneNumber,
															unreinput2);
													break;
												default:
													System.out.println("입력이 잘못되었습니다.");
													break;

												}
											} else if (a == 3) {
												GuestRoom.showAllRooms();
												System.out.println("예약하고자 하는 방은?");
												int roomNum = sc.nextInt();
												sc.nextLine();
												acting.reservation(customerName, customerPhoneNumber, roomNum);
											} else {
												break;
											}
										} else if (GuestRoom.checkRoomState(customerName, customerPhoneNumber) == 3) {
											acting.searchArrays(customerName, customerPhoneNumber);

										} else {
											System.out.println("잘못된 입력입니다.");
										}
									}
								}
								break;
							case 2:
								System.out.println("고객정보를 확인하고싶은 방번호는?");
								System.out.println("나가기:99");
								int input1RoomNum = sc.nextInt();
								if (input1RoomNum == 99) {

								} else {
									acting.checkRoomState(input1RoomNum);
								}
								break;
							case 3:
								System.out.println("체크인/체크아웃 하실 방은?");
								System.out.println("나가기:99");
								int input1CheckRoomNum = sc.nextInt();
								if (input1CheckRoomNum == 99) {

								} else {
									acting.checkIn(input1CheckRoomNum);
								}
								break;
							case 4:
								System.out.println("워크인 하실 방은?");
								System.out.println("나가기:99");
								int intput1WalkIn = sc.nextInt();
								if (intput1WalkIn == 99) {

								} else {
									acting.walkIn(intput1WalkIn);
								}
								break;
							case 5:
								System.out.println("수리,점검 하실 방은?");
								int intput1inspection = sc.nextInt();
								if (intput1inspection == 99) {

								} else {
									acting.inspection(intput1inspection);
								}
								break;
							case 6:
								System.out.println("수리완료한 방번호 입력");
								int intputdisinspection = sc.nextInt();
								if (intputdisinspection == 99) {

								} else {
									acting.disInspection(intputdisinspection);
								}
								break;
							case 7:
								System.out.println("기존 방번호 입력 :");
								int originRoomNum = sc.nextInt();
								System.out.println("새로운 방번호 입력 :");
								int transferRoomNum = sc.nextInt();
								acting.transfer(originRoomNum, transferRoomNum);
								break;
							case 8:
								exit2 = 1;
								break;
							default:
								System.out.println("입력값이 잘못되었습니다.");
								break;

							}
						} while (exit2 != 1);

						// 예약취소, 방고객정보, 체크인 체크아웃

						break;
					case 2:

						System.out.println("고객명:");
						String customerName = sc.nextLine();
						System.out.println("전화번호:");
						System.out.println("나가기:99");
						String customerPhoneNumber = sc.nextLine();
						if (customerPhoneNumber.equals("99")) {

						} else {
							if (GuestRoom.checkRoomNumber(customerName, customerPhoneNumber) == -1) {
								GuestRoom.showAllRooms();
								System.out.println("예약하고자 하는 방은?");
								int roomNum = sc.nextInt();
								sc.nextLine();
								acting.reservation(customerName, customerPhoneNumber, roomNum);

							} else {
								if (GuestRoom.checkRoomState(customerName, customerPhoneNumber) == 1) {
									acting.searchArrays(customerName, customerPhoneNumber);

									System.out.println("1.예약취소");
									System.out.println("2.돌아가기");
									System.out.println("3.다른방 예약하기");
									int a = sc.nextInt();
									if (a == 1) {
										System.out.println("1. 전체 취소");
										System.out.println("2. 부분취소");
										int unreinput = sc.nextInt();
										switch (unreinput) {
										case 1:

											acting.unreservation(customerName, customerPhoneNumber);
											System.out.println("전체 예약이 취소되었습니다.");
											break;
										case 2:
											System.out.println("취소하실 방번호입력");
											int unreinput2 = sc.nextInt();
											acting.PartialUnreservation(customerName, customerPhoneNumber,
													unreinput2);
											break;
										default:
											System.out.println("입력이 잘못되었습니다.");
											break;

										}
									} else if (a == 3) {
										GuestRoom.showAllRooms();
										System.out.println("예약하고자 하는 방은?");
										int roomNum = sc.nextInt();
										sc.nextLine();
										acting.reservation(customerName, customerPhoneNumber, roomNum);
									} else {
										break;
									}
								} else if (GuestRoom.checkRoomState(customerName, customerPhoneNumber) == 3) {
									acting.searchArrays(customerName, customerPhoneNumber);

								} else {
									System.out.println("잘못된 입력입니다.");
								}
							}
						}
						break;
					case 3:
						System.out.println("--멤버십 가입--");
						System.out.println("멤버십 가입자 성함 : ");
						String membershipName = sc.nextLine();
						System.out.println("멤버십 가입자 연락처 : ");
						String membershipPhoneNum = sc.nextLine();
						System.out.println("멤버십 등급?");
						System.out.println("1.골드 : 100.000원");
						System.out.println("2.플래티넘 : 200.000원");
						System.out.println("나가기 :99");
						int membershipGrade = sc.nextInt();
						if (membershipGrade == 99) {
						} else {

							acting.joinMembership(membershipName, membershipPhoneNum, membershipGrade);
							sc.nextLine();
							int plusMoney;
							if (membershipGrade == 1) {
								plusMoney = 100000;
							} else if (membershipGrade == 2) {
								plusMoney = 200000;
							} else {
								plusMoney = 0;
							}
							m.setMoney(m.getMoney() + plusMoney);
						}

						break;
					case 4:
						acting.showAllMembership();

						break;
					case 5:
						exit1 = 1;
						break;
					default:
						System.out.println("입력이 틀렸습니다.");
						break;
					}

				} while (exit1 != 1);
			} else if (Login.containLogin(id, pw) == 1 && Login.findArrNum(id, pw) == 1) {
				int exit4 = 0;

				do {
					System.out.println("");
					show.CleanerMenu();
					int cleanerInput = sc.nextInt();
					sc.nextLine();

					switch (cleanerInput) {
					case 1:
						GuestRoom.showCleanerRooms();
						break;
					case 2:
						System.out.println("청소 확인 체크할 룸넘버");
						int cleanCheckRoomNum = sc.nextInt();
						sc.nextLine();
						acting.cleanCheck(cleanCheckRoomNum);
						break;
					case 3:
						exit4 = 1;
					default:
					}
				} while (exit4 != 1);

			} else if (Login.containLogin(id, pw) == 1 && Login.findArrNum(id, pw) == 2) {
				int exit5 = 0;

				do {
					System.out.println("");
					show.ManagerMenu();
					int ManagerInput = sc.nextInt();
					sc.nextLine();

					switch (ManagerInput) {
					case 1:
						System.out.println("일매출은 :" + m.getMoney());
						break;
					case 2:
						System.out.println();
						break;
					case 3:
						exit5 = 1;
						break;
					default:
					}
				} while (exit5 != 1);
			} else {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다");

			}
		} while (exit != 1);
	}
}
