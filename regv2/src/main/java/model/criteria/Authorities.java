package model.criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities")
public class Authorities {
	@Id
	@GeneratedValue(generator = "hibernate-uuid.hex")
	@GenericGenerator(name = "hibernate-uuid.hex", strategy = "uuid.hex")
	private String id;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private Users user;

	@Column(name = "authority", nullable = false, length = 50)
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
