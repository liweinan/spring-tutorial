package support;

import model.Clazz;
import model.dao.ClazzDao;

import org.springframework.binding.convert.converters.StringToObject;

public class ClazzConvertor extends StringToObject {
	private ClazzDao clazzDao;

	public ClazzConvertor(ClazzDao clazzDao) {
		super(Clazz.class);
		this.clazzDao = clazzDao;
	}

	@Override
	protected Object toObject(String id, Class targetClass) throws Exception {
		return clazzDao.findById(id);
	}

	@Override
	protected String toString(Object object) throws Exception {
		Clazz Clazz = (Clazz) object;
		return Clazz.getId();
	}

}
