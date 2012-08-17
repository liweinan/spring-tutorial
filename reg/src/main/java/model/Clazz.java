package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
public class Clazz {

	@Id
	@DocumentId
	@GeneratedValue(generator = "hibernate-uuid.hex")
	@GenericGenerator(name = "hibernate-uuid.hex", strategy = "uuid.hex")
	private String id;

	@Field(index = Index.TOKENIZED, store = Store.YES)
	private String clazzName;

	@OneToMany(mappedBy = "clazz", fetch = FetchType.EAGER)
	@OrderBy(clause = "username asc")
	@ContainedIn
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
