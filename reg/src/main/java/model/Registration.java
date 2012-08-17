package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
public class Registration {

	@Id
	@DocumentId
	@GeneratedValue(generator = "hibernate-uuid.hex")
	@GenericGenerator(name = "hibernate-uuid.hex", strategy = "uuid.hex")
	private String id;

	@Field(index = Index.TOKENIZED, store = Store.NO)
	private String username;

	private Date createdAt;

	private Date updatedAt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clazz_id", nullable = false)
	@IndexedEmbedded(prefix="inClazz_")
	private Clazz clazz;

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
