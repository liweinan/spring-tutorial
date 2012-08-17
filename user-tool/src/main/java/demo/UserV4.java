package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserV4 {
	private String username;

	@Autowired
	@Qualifier("radio")
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
