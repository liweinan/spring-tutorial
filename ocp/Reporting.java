
public class Reporting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Printer printer = new Printer();
		Screen screen = new Screen();
		Report report = new Report();
		
		report.setOutputDevice(printer);
		report.setContent("Hello, World!");
		report.print();

		report.setOutputDevice(screen);
		report.print();
	}

}
