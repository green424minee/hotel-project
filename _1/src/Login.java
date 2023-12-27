
public class Login { // 객실관리할수 있는 ID, PW 만드는 클래스
	private static LoginIdPw[] loginIdPw;

	public Login(LoginIdPw[] loginIdPw) {
		this.loginIdPw = loginIdPw;
	}

	public static void Login() {
		loginIdPw = new LoginIdPw[] { new LoginIdPw("asd", "asd"), new LoginIdPw("123", "123"), new LoginIdPw("qwe", "qwe") };
	}

	public static LoginIdPw[] getLoginIdPw() {
		return loginIdPw;
	}

	public static void setLoginIdPw(LoginIdPw[] loginIdPw) {
		Login.loginIdPw = loginIdPw;
	}

	public static int containLogin(String Id, String Pw) {
		for (int i = 0; i < loginIdPw.length; i++) {
			if (loginIdPw[i].getDeskId().equals(Id) && loginIdPw[i].getPw().equals(Pw)) {
				return 1;
			}
		}
		return -1;
	}

	public static int findArrNum(String id, String pw) {
		for (int i = 0; i < loginIdPw.length; i++) {
			if (loginIdPw[i].getDeskId().equals(id) && loginIdPw[i].getPw().equals(pw)) {
				return i;

			}
		}
		return -1;

	}

}
