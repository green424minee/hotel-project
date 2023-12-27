
public class Membership {
	private static MembershipNPS[] memberships;
	
	public static void Membership() {
        memberships = new MembershipNPS[20];
    }

	public static MembershipNPS[] getMemberships() {
		return memberships;
	}

	public static void setMemberships(MembershipNPS[] memberships) {
		Membership.memberships = memberships;
	}
	
	

}
