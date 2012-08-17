package model.dao;

import java.util.List;

import model.Clazz;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class JpaClazzDaoImpl extends JpaDaoSupport implements ClazzDao {

	@Transactional(readOnly = false)
	public void store(Clazz clazz) {
		getJpaTemplate().merge(clazz);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Clazz> load() {
		return getJpaTemplate().find("from Clazz c order by c.id desc");

	}

	@Transactional(readOnly = true)
	public Clazz findById(String id) {
		if (!StringUtils.hasLength(id))
			return null;
		List list = getJpaTemplate().find("from Clazz where id=?", id);
		if (list.size() == 1)
			return (Clazz) list.get(0);
		return null;
	}

	public Clazz create() {
		Clazz clazz = new Clazz();
		return clazz;
	}
}
