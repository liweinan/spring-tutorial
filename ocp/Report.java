public class Report {
	private String content;

	private OutputDevice outputDevice;

	public Report() {
	};

	public Report(OutputDevice outputDevice, String content) {
		super();
		this.outputDevice = outputDevice;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OutputDevice getOutputDevice() {
		return outputDevice;
	}

	public void setOutputDevice(OutputDevice outputDevice) {
		this.outputDevice = outputDevice;
	}

	public void print() {
		outputDevice.output(content);
	}
}
