package proxy.person.bean;

public class MatchMakingTestDrive {
	// instance variables here
	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.drive();
	}
	public MatchMakingTestDrive() {
		initializeDatabase();
	}
	private void initializeDatabase() {
		// TODO Auto-generated method stub
		
	}
	public void drive() {
		PersonBean joe = getPersonFromDatabase("Joe Javabean");
		PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can’t set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can’t set interests from non owner proxy");
		}
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}
	private PersonBean getOwnerProxy(PersonBean joe) {
		// TODO Auto-generated method stub
		return null;
	}
	private PersonBean getNonOwnerProxy(PersonBean joe) {
		// TODO Auto-generated method stub
		return null;
	}
	// other methods like getOwnerProxy and getNonOwnerProxy here
	private PersonBean getPersonFromDatabase(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}