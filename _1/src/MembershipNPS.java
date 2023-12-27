
public class MembershipNPS {
	private String membershipName;
	private String membershipPhoneNum;
	private int grade;

	public MembershipNPS(String membershipName, String membershipPhoneNum, int grade) {
		super();
		this.membershipName = membershipName;
		this.membershipPhoneNum = membershipPhoneNum;
		this.grade = grade;
	}

	public String getMembershipName() {
		return membershipName;
	}

	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}

	public String getMembershipPhoneNum() {
		return membershipPhoneNum;
	}

	public void setMembershipPhoneNum(String membershipPhoneNum) {
		this.membershipPhoneNum = membershipPhoneNum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


}
