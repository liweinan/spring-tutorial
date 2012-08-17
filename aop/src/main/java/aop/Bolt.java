package aop;

public class Bolt {

	public String run(boolean wearShoes) throws Exception {
		if (!wearShoes)
			throw new NoShoesException();

		System.out.print("Bolt is running");
		for (int i = 0; i < 100; i++) {
			System.out.print(".");
		}
		System.out.println("GOAL!");
		return "I'm Bolt!";
	}

}
