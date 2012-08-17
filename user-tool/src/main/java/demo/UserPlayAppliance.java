package demo;

public class UserPlayAppliance {

	public static void main(String[] args) {
		UserV2 user = new UserV2();
		user.setUsername("Peter");

		RadioV2 radio = new RadioV2();

		user.setAppliance(radio);
		System.out.println(user.getUsername() + " is using "
				+ user.getAppliance().use());

		Tv tv = new Tv();
		user.setAppliance(tv);
		System.out.println(user.getUsername() + " is using "
				+ user.getAppliance().use());
	}

}
