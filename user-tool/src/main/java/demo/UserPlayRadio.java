package demo;

public class UserPlayRadio {

	public static void main(String[] args) {
		User user = new User();
		Radio radio = new Radio();
		user.setUsername("Peter");
		user.setRadio(radio);
		System.out.println(user.getUsername() + " is using " + user.getRadio().use());
		
	}

}
