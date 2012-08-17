package demo;

import org.springframework.beans.factory.annotation.Autowired;

public class UserV3 {
	private String username;

	@Autowired
	private Appliance appliance;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Appliance getAppliance() {
		return appliance;
	}

}
