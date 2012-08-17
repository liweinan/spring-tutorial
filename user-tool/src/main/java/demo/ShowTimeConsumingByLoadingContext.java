package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowTimeConsumingByLoadingContext {
	private static long start = 0;

	private static long end = 0;
	
	private static final int TIMES = 100;

	public static void main(String[] args) {
		long timer = 0;
		for (int i = 0; i < TIMES; i++) {
			start = System.currentTimeMillis();
			new ClassPathXmlApplicationContext("config.xml");
			end = System.currentTimeMillis();

			timer += end - start;
		}
		System.out.println("the average time of load is: " + timer / TIMES
				+ "ms");

	}
}
