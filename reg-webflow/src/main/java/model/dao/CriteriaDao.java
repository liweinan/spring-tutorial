package model.dao;

public interface CriteriaDao {

	public boolean insertAuthNData(String username, String password,
			String authority);
}
