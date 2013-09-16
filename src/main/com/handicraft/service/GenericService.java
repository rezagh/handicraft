package com.handicraft.service;

import java.util.List;

import com.handicraft.model.BaseDO;

public interface GenericService {
	List getAll(Class c);
	//List getAllActive(Class c);
	Long save(BaseDO base);
	//List findByCriteria(DetachedCriteria criteria);
	BaseDO get(Class clazz,Long id);
	//List getByCode(Class clazz, String code);
	//BaseDO getSingleByCode(Class clazz, String code);
	void delete(BaseDO base);
	void update(BaseDO base);
}
