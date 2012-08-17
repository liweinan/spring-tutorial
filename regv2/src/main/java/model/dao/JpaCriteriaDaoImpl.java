package model.dao;

import model.criteria.Authorities;
import model.criteria.Users;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class JpaCriteriaDaoImpl extends JpaDaoSupport implements CriteriaDao {

	@Transactional(readOnly = false)
	public boolean insertAuthNData(String username, String password,
			String authority) {
		if (!StringUtils.hasLength(username)
				|| !StringUtils.hasLength(password)
				|| !StringUtils.hasLength(authority)) {
			return false;
		}

		Users u = new Users();
		u.setUsername(username.trim());
		u.setPassword(password.trim());
		u.setEnabled(true);

		Authorities a = new Authorities();
		a.setAuthority(authority.trim());
		a.setUser(u);

		getJpaTemplate().merge(u);
		getJpaTemplate().merge(a);
		return true;
	}
}
