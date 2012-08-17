package support;

import java.beans.PropertyEditorSupport;

import model.Clazz;
import model.dao.ClazzDao;

import org.springframework.util.StringUtils;

public class ClazzEditor extends PropertyEditorSupport {
	public ClazzEditor(ClazzDao clazzDao) {
		this.clazzDao = clazzDao;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasLength(text)) {
			Clazz c = clazzDao.findById(text);
			setValue(c);
		}
	}

	private final ClazzDao clazzDao;
}
