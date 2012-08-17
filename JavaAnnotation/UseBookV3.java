import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class UseBookV3 {

	@CopyrightV2(value = "All Rights Reserved")
	private Book book;

	@CopyrightV2(value = "GNU Public License")
	private Book book2;

	public static void main(String[] args) {

		UseBookV3 ub = new UseBookV3();

		for (Field field : ub.getClass().getDeclaredFields()) {
			System.out.println("fields found.");
			for (Annotation anno : field.getAnnotations()) {
				System.out.println(anno.annotationType().toString());
				if (anno.annotationType().equals(CopyrightV2.class)) {
					CopyrightV2 c = (CopyrightV2) anno;
					System.out.println("value: " + c.value());
				}
			}
		}
	}
}
