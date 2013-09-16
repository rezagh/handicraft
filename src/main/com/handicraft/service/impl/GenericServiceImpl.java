package com.handicraft.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.annotation.Secured;

import com.handicraft.dao.GenericDao;
import com.handicraft.model.BaseDO;
import com.handicraft.service.GenericService;

public class GenericServiceImpl implements GenericService{
	
	Log log = LogFactory.getLog(GenericServiceImpl.class);
	GenericDao genericDao;
	
	
	@Override
	public List getAll(Class c) {
		return genericDao.getAll(c);
	}

	@Override
	public Long save(BaseDO base) {
		return genericDao.save(base);
	}

	
	@Override
	public BaseDO get(Class clazz, Long id) {
		return genericDao.get(clazz, id);
	}

//	@Override
//	public List<BaseDO> getByCode(Class clazz, String code) {
//		return genericDao.findByCode(clazz, code);
//		
//	}
//
//	@Override
//	public BaseDO getSingleByCode(Class clazz, String code) {
//		return genericDao.findSingleByCode(clazz, code);
//	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void delete(BaseDO base) {
		genericDao.delete(base);
	}

	@Override
	public void update(BaseDO base) {
		genericDao.update(base);
	}
}
