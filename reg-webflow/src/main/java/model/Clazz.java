package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

@Entity
public class Clazz implements Serializable {
	private static final long serialVersionUID = -1288922567958676914L;

	@Id
	@GeneratedValue(generator = "hibernate-uuid.hex")
	@GenericGenerator(name = "hibernate-uuid.hex", strategy = "uuid.hex")
	private String id;

	private String clazzName;

	@OneToMany(mappedBy = "clazz", fetch = FetchType.EAGER)
	@OrderBy(clause = "username asc")
	private Set<Registration> registrations = new HashSet<Registration>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String setClazzName) {
		this.clazzName = setClazzName;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

}
