package com.handicraft.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.handicraft.dao.GenericDao;
import com.handicraft.model.BaseDO;

public class GenericDaoImpl extends HibernateDaoSupport implements GenericDao {
	Log log = LogFactory.getLog(GenericDaoImpl.class);
	private String CODE = "code";
	
	@Override
    public final List getAll(Class c) {
		//getHibernateTemplate().setCacheQueries(true);
	       
		return super.getHibernateTemplate().loadAll(c);
    }

	@Override
	public Long save(BaseDO base) {
		//base.setDateModified(new Date());
		return (Long)super.getHibernateTemplate().save(base);
	}

	@Override
	public List findByCriteria(DetachedCriteria criteria) {
		//getHibernateTemplate().setCacheQueries(true);
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List findByQuery(String query) {
		//getHibernateTemplate().setCacheQueries(true);
		return super.getHibernateTemplate().find(query);
	}

	@Override
	public List findByQuery(String query, Object value) {
		return super.getHibernateTemplate().find(query,value);
	}

	@Override
	public BaseDO get(Class clazz,Long id) {
		 return (BaseDO)super.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void update(BaseDO o) {
		super.getHibernateTemplate().update(o);
	}

	@Override
	public void delete(BaseDO o) {
		super.getHibernateTemplate().delete(o);
	}

	@Override
	public List findByCode(Class clazz, String code) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz).add( Property.forName(CODE).eq(code));
		return getHibernateTemplate().findByCriteria(query);
	}

	@Override
	public BaseDO findSingleByCode(Class clazz, String code) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz).add( Property.forName(CODE).eq(code));
		return (BaseDO)getHibernateTemplate().findByCriteria(query).get(0);
	}

	@Override
	public List findByColumn(Class clazz, String columnName, String value) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz).add( Property.forName(columnName).eq(value));
		return getHibernateTemplate().findByCriteria(query);
	}

}
