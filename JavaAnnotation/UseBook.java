import java.lang.annotation.Annotation;

public class UseBook {

	public static void main(String[] args) {
		Book b = new Book();
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
