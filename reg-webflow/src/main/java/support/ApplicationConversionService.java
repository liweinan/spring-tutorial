package support;

import model.dao.ClazzDao;

import org.springframework.binding.convert.service.DefaultConversionService;

public class ApplicationConversionService extends DefaultConversionService {

	public ApplicationConversionService(ClazzDao clazzDao) {
		super();
		addConverter(new ClazzConvertor(clazzDao));
	}

}
