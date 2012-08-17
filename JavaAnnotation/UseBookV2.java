import java.lang.annotation.Annotation;

public class UseBookV2 {

	public static void main(String[] args) {
		BookV2 b = new BookV2();
		b.setBookname("J2EE Tutorial");
		for (Annotation anno : b.getClass().getAnnotations()) {
			System.out.println(anno.annotationType().toString());
			if (anno.annotationType().equals(Copyright.class)) {
				Copyright c = (Copyright) anno;
				System.out.println("The Copyright of " + b.getBookname() + ": "
						+ c.value());
			}
		}
	}
}
