package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Registration;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class JpaRegistrationDaoImpl extends JpaDaoSupport implements
		RegistrationDao {

	@Transactional(readOnly = false)
	public void store(Registration registration) {
		boolean isNew = !StringUtils.hasLength(registration.getId());
		if (isNew) {
			Date date = new Date();
			registration.setCreatedAt(date);
			registration.setUpdatedAt(date);
		} else {
			registration.setUpdatedAt(new Date());
		}
		getJpaTemplate().merge(registration);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Registration> load() {
		return getJpaTemplate().find("from Registration order by id desc");

	}

	@Transactional(readOnly = false)
	public Registration findById(String id) {
		if (StringUtils.hasLength(id)) {
			List list = getJpaTemplate().find(
					"from Registration r where r.id=?", id);
			if (list.size() == 1) {
				return (Registration) list.get(0);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Registration> findByUsername(String username) {
		if (StringUtils.hasLength(username)) {
			return getJpaTemplate().find("from Registration where username=?",
					username);

		}
		return null;
	}

	@Transactional(readOnly = true)
	public List search(final String keyword) {
		return getJpaTemplate().executeFind(new JpaCallback() {
			public Object doInJpa(EntityManager entityManager) {
			FullTextEntityManager fullTextEntityManager = 
				org.hibernate.search.jpa.Search
				.createFullTextEntityManager(entityManager);
			MultiFieldQueryParser parser = new MultiFieldQueryParser(
				new String[] { "id", "username" },
				new StandardAnalyzer());
			org.apache.lucene.search.Query query;
			try {
				query = parser.parse(keyword);
				return fullTextEntityManager.
					createFullTextQuery(
						query,Registration.class).
						getResultList();
				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}

}
