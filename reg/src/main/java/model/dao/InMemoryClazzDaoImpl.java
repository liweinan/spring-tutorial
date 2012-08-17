package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Clazz;

import org.springframework.util.StringUtils;

public class InMemoryClazzDaoImpl implements ClazzDao {

	private static final List<Clazz> clazzPool = new ArrayList<Clazz>();

	public Clazz findById(String id) {
		if (!StringUtils.hasLength(id))
			return null;
		for (Clazz clazz : clazzPool) {
			if (id.equals(clazz.getId()))
				return clazz;
		}
		return null;
	}

	public List<Clazz> load() {
		return clazzPool;
	}

	public void store(Clazz clazz) {
		if (clazz == null)
			return;
		boolean isNew = !StringUtils.hasLength(clazz.getId());
		if (isNew)
			clazz.setId(UUID.randomUUID().toString());

		clazzPool.add(clazz);
	}

}
