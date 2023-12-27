
public class Room {
	private int roomNumber;
	private CustomerInformation CustomerInformation;
	private int state;
	
	
	public Room(int roomNumber, CustomerInformation customerInformation, int state) {
		this.roomNumber = roomNumber;
		CustomerInformation = customerInformation;
		this.state = state;
	}
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;

	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public CustomerInformation getCustomerInformation() {
		return CustomerInformation;
	}
	public void setCustomerInformation(CustomerInformation customerInformation) {
		CustomerInformation = customerInformation;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setCustomerInformation(String customerName, String customerPhoneNumber) {
		CustomerInformation.setCustomername(customerName);
		CustomerInformation.setPhoneNumber(customerPhoneNumber);
		
	}

	
	
	

}
