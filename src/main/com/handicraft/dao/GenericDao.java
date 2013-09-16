package com.handicraft.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.handicraft.model.BaseDO;

public interface GenericDao {
	List getAll(Class c);
	Long save(BaseDO base);
	List findByColumn(Class clazz, String columnName, String value);
	List findByCode(Class clazz, String code);
	BaseDO findSingleByCode(Class clazz, String code);
	BaseDO get(Class clazz,Long id);
	List findByCriteria(DetachedCriteria criteria);
	List findByQuery(String query);
	List findByQuery(String query, Object value);
	void update(BaseDO o);
	void delete(BaseDO o);
	
}
