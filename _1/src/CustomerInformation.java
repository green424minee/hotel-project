
public class CustomerInformation { // 고객 정보(이름, 전화번호) 입력 저장 삭제 .
	private String customername;
	private String phoneNumber;
	
	public CustomerInformation() {
        this.customername = "";
        this.phoneNumber = "";
    }
	
	public CustomerInformation(String customername, String phoneNumber) {
		this.customername = customername;
		this.phoneNumber = phoneNumber;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
